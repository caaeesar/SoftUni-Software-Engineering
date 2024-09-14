function solve() {
  let inputElement = document.getElementById('input');
  let outputElement = document.getElementById('output');

  let sentences = inputElement.value.split('.').filter(Boolean).map((x) => x.trim());

  function createParagraph (text) {
    let pElement = document.createElement('p');
    pElement.textContent = text;
    return pElement;
  }

  for(let i = 0; i < sentences.length; i+=3) {
    let currentText = sentences.slice(i, i + 3).join('. ') + '.';
    let currentParagraph = createParagraph(currentText);
    outputElement.appendChild(currentParagraph);
  }
}
