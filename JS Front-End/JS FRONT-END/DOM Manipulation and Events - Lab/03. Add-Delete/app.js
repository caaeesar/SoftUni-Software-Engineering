function addItem() {
    let itemsElement = document.getElementById('items');
    let newItemElement = document.getElementById('newItemText');

    let liElement = document.createElement('li');
    liElement.textContent = newItemElement.value;

    let deletedButton = document.createElement('a');
    deletedButton.textContent = '[Delete]';
    deletedButton.setAttribute('href', '#');
    //deletedButton.href = '#';

    deletedButton.addEventListener('click', (e) => {
        e.currentTarget.parentElement.remove();
    });

    liElement.append(deletedButton);
    itemsElement.appendChild(liElement);

    newItemElement.value = '';
}
