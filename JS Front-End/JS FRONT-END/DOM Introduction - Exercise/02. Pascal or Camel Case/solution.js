function solve() {
  let input = document.getElementById('text').value;
  let currentCase = document.getElementById('naming-convention').value;
  let result = document.getElementById('result');
debugger;
  let resultString = '';
  let splitted = input.split(' ');

  if(currentCase === 'Camel Case') {
    //first word
    resultString += splitted[0][0].toLowerCase() // first letter
    + splitted[0].slice(1, splitted[0].length).toLowerCase(); // the rest letter

    // the rest words
  for (let i = 1; i < splitted.length; i++) {
    resultString += splitted[i][0].toUpperCase() +
      splitted[i].slice(1, splitted[i].length).toLowerCase();
  }
  result.textContent = resultString;

  } else if (currentCase === 'Pascal Case') {
    for (let i = 0; i < splitted.length; i++) {
      resultString += splitted[i][0].toUpperCase() +
        splitted[i].slice(1, splitted[i].length).toLowerCase();
    }
   
    result.textContent = resultString;
  } else {
    result.textContent = 'Error!';
  }

}
