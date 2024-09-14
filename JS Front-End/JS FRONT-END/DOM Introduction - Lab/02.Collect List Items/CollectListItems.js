function extractText() {
    let ulElement = document.getElementById('items');
    let resultElement = document.getElementById('result');

    resultElement.textContent = ulElement.innerText;
}
