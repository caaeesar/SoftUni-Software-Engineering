const BASE_URL = 'http://localhost:3030/jsonstore/matches';

const endpoints = {
    update: (id) => `${BASE_URL}/${id}`,
    delete: (id) => `${BASE_URL}/${id}`,
};

let hostElement = document.getElementById("host");
let scoreElement = document.getElementById("score");
let guestElement = document.getElementById("guest");

let list = document.getElementById('list');
let addBtn = document.getElementById("add-match");
let editBtn = document.getElementById("edit-match");
let loadBtn = document.getElementById("load-matches");

let selectedMatchId = null;

function attachEvents() {
    loadBtn.addEventListener('click', loadMatchesEventHandler);
    addBtn.addEventListener('click', createMatchEventHandler);
    editBtn.addEventListener('click', editMatchEventHandler);
}

async function loadMatchesEventHandler() {
    clearAllSections();
    try {
        const res = await fetch(BASE_URL);
        const allMatches = await res.json();
        Object.values(allMatches).forEach((match) => {
            const container = document.createElement('li');
            container.className = 'match';

            const content = document.createElement('div');
            content.className = 'info';

            const hostElem = document.createElement('p');
            hostElem.textContent = match.host;

            const scoreElem = document.createElement('p');
            scoreElem.textContent = match.score;

            const guestElem = document.createElement('p');
            guestElem.textContent = match.guest;

            const buttonsContainer = document.createElement('div');
            buttonsContainer.className = 'btn-wrapper';

            const changeBtn = document.createElement('button');
            changeBtn.className = 'change-btn';
            changeBtn.textContent = 'Change';

            const deleteBtn = document.createElement('button');
            deleteBtn.className = 'delete-btn';
            deleteBtn.textContent = 'Delete';

            buttonsContainer.appendChild(changeBtn);
            buttonsContainer.appendChild(deleteBtn);

            content.appendChild(hostElem);
            content.appendChild(scoreElem);
            content.appendChild(guestElem);

            container.appendChild(content);
            container.appendChild(buttonsContainer);

            list.appendChild(container);
        });
        attachEventListeners();
    } catch (err) {
        console.error(err);
    }
}

function attachEventListeners() {
    const changeButtons = document.querySelectorAll('.change-btn');
    const deleteButtons = document.querySelectorAll('.delete-btn');

    changeButtons.forEach((changeButton) => {
        changeButton.addEventListener('click', (event) => {
            const matchElement = event.target.closest('.match');
            const host = matchElement.querySelector('p').textContent;
            const score = matchElement.querySelector('p:nth-child(2)').textContent;
            const guest = matchElement.querySelector('p:nth-child(3)').textContent;
            editMatch(host, score, guest);
            enableEditBtn();
        });
    });

    deleteButtons.forEach((deleteButton) => {
        deleteButton.addEventListener('click', (event) => {
            const matchElement = event.target.closest('.match');
            const host = matchElement.querySelector('p').textContent;
            deleteMatch(host);
        });
    });
}

function enableEditBtn() {
    addBtn.disabled = true;
    editBtn.disabled = false;
}

function enableAddBtn() {
    addBtn.disabled = false;
    editBtn.disabled = true;
}

function createMatchEventHandler(ev) {
    ev.preventDefault();
    if (hostElement.value !== '' && scoreElement.value !== '' && guestElement.value !== '') {
        const headers = {
            method: 'POST',
            body: JSON.stringify({
                host: hostElement.value,
                score: scoreElement.value,
                guest: guestElement.value,
            }),
            headers: {
                'Content-Type': 'application/json'
            }
        };

        fetch(BASE_URL, headers)
            .then(loadMatchesEventHandler)
            .catch(console.error);

        clearAllInputs();
    }
}

async function editMatch(host, score, guest) {
    selectedMatchId = await getMatchIdByHost(host);
    hostElement.value = host;
    scoreElement.value = score;
    guestElement.value = guest;
}

function editMatchEventHandler(ev) {
    ev.preventDefault();
    const data = {
        host: hostElement.value,
        score: scoreElement.value,
        guest: guestElement.value,
        _id: selectedMatchId,
    };

    fetch(endpoints.update(data._id), {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    })
        .then(() => {
            clearAllInputs();
            loadMatchesEventHandler();
            selectedMatchId = null;
            enableAddBtn();
        })
        .catch(console.error);
}

async function deleteMatch(host) {
    const id = await getMatchIdByHost(host);
    fetch(endpoints.delete(id), {
        method: 'DELETE',
        headers: { 'Content-Type': 'application/json' },
    })
        .then(() => {
            clearAllSections();
            loadMatchesEventHandler();
            selectedMatchId = null;
            enableAddBtn();
        })
        .catch(console.error);
}

async function getMatchIdByHost(host) {
    const res = await fetch(BASE_URL);
    const allMatches = await res.json();
    return Object.entries(allMatches).find(e => e[1].host === host)[1]._id;
}

function clearAllSections() {
    list.innerHTML = '';
}

function clearAllInputs() {
    hostElement.value = '';
    scoreElement.value = '';
    guestElement.value = '';
}

attachEvents();
