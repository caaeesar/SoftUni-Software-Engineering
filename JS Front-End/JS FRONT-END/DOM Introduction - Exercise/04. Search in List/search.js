function search() {
   let searchText = document.getElementById('searchText').value;

   let towns = Array.from(document.querySelectorAll('#towns li'));

   towns.forEach((e) => {
       e.style.fontWeight = "normal";
       e.style.textDecoration = "none";
   });

   let matchElements = towns.filter((x) => x.textContent.toLowerCase().includes(searchText.toLowerCase()));

   matchElements.forEach((x) => {
       x.style.fontWeight = "bold";
       x.style.textDecoration = "underline";
   });


   let resultDiv = document.getElementById('result');
   resultDiv.textContent = `${matchElements.length} matches found`;
}

