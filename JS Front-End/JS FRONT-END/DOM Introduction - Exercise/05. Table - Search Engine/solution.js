function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {
       let searchElement = document.getElementById('searchField');
       let searchText = searchElement.value;
       let rowElements = Array.from(document.querySelectorAll('.container tbody tr'));

       rowElements.forEach(row => {
           row.className = '';
       });


       rowElements.filter(row => {
           let values = Array.from(row.children);

           if (values.some(td => td.textContent.includes(searchText))) {
               row.className = 'select';
           }
       });

       searchElement.value = '';
   }
}
