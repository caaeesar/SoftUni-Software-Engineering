window.addEventListener("load", solve);

function solve() {
  let nameInput = document.getElementById('name');
  let timeInput = document.getElementById('time');
  let descriptionInput = document.getElementById('description');
  let addBtn = document.getElementById('add-btn');

  let previewList = document.getElementById('preview-list');
  let archiveList = document.getElementById('archive-list');
  
  function addEvent() {
    let name = nameInput.value.trim();
    let time = timeInput.value.trim();
    let description = descriptionInput.value.trim();
    
    if (name === '' || time === '' || description === '') {
      return;
    }
    
    let li = document.createElement('li');

    
    let article = document.createElement('article');
    
    
    let nameElement = document.createElement('p');
    nameElement.textContent = name;
    let timeElement = document.createElement('p');
    timeElement.textContent = time;
    let descriptionElement = document.createElement('p');
    descriptionElement.textContent = description;

    article.appendChild(nameElement);
    article.appendChild(timeElement);
    article.appendChild(descriptionElement);
    
    li.appendChild(article);

    
    let editBtn = document.createElement('button');
    editBtn.textContent = 'Edit';
    editBtn.className = 'edit-btn'; 
    editBtn.addEventListener('click', () => editEvent(li));
    
    let nextBtn = document.createElement('button');
    nextBtn.textContent = 'Next';
    nextBtn.className = 'next-btn'; 
    nextBtn.addEventListener('click', () => moveToArchive(li));
    
    li.appendChild(editBtn);
    li.appendChild(nextBtn);
    
    previewList.appendChild(li);
    
    nameInput.value = '';
    timeInput.value = '';
    descriptionInput.value = '';
    
    addBtn.disabled = true;
  }

  function editEvent(li) {
    let article = li.querySelector('article');
    let [name, time, description] = Array.from(article.querySelectorAll('p')).map(p => p.textContent);

    nameInput.value = name;
    timeInput.value = time;
    descriptionInput.value = description;
    
    addBtn.disabled = false;
    
    previewList.removeChild(li);
  }
  
  function moveToArchive(li) {
    previewList.removeChild(li);
    
    let archiveBtn = document.createElement('button');
    archiveBtn.textContent = 'Archive';
    archiveBtn.addEventListener('click', () => {
      archiveList.removeChild(li);
      addBtn.disabled = false;
    });
    
    li.appendChild(archiveBtn);
    li.querySelectorAll('button').forEach(button => {
      if (button.textContent !== 'Archive') {
        button.remove();
      }
    });
    
    archiveList.appendChild(li);
    li.querySelector('article').style.cursor = 'default';
  }
  
  addBtn.addEventListener('click', (event) => {
    event.preventDefault();
    addEvent();
  });
  
  [nameInput, timeInput, descriptionInput].forEach(input => {
    input.addEventListener('input', () => {
      addBtn.disabled = !(
        nameInput.value.trim() &&
        timeInput.value.trim() &&
        descriptionInput.value.trim()
      );
    });
  });
}

