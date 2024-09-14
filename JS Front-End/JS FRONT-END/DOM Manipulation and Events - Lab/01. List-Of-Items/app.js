function addItem() {
    let itemsElement = document.getElementById('items');
    let inputElement = document.getElementById('newItemText');

    let itemText = inputElement.value;

    let newLiElement = document.createElement('li');
    
    newLiElement.textContent = itemText;

    itemsElement.appendChild(newLiElement);

    inputElement.value = '';
}
