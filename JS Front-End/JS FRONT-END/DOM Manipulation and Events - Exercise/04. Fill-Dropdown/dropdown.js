function addItem() {
   let [textInputElement, valueInputElement] = document.querySelectorAll('input[type="text"]');

   function createOptionElement (text, value) {
       let option = document.createElement('option');
       option.textContent = text;
       option.value = value;

       return option;
   }

   document.getElementById('menu')
           .appendChild(createOptionElement(textInputElement.value, valueInputElement.value));

   textInputElement.value = '';
   valueInputElement.value = '';

}

