function create(words) {
   let mainDivElement = document.getElementById('content');

   function createNewDivElement(word) {
      let divElement = document.createElement('div');
      let pElement = document.createElement('p');
      
      pElement.textContent = word;
      pElement.style.display = 'none';
      divElement.appendChild(pElement);

      return divElement;
   }
  
     words.forEach((word) => {
      let divElement = createNewDivElement(word);

      divElement.addEventListener('click', (event) => {
         event.target.children[0].style.display = 'block';
      });

      mainDivElement.appendChild(divElement);
     });
   
}
