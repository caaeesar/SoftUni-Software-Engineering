function deleteByEmail() {
    let inputElement = document.querySelector('input[type=text][name=email]');
    let resultElement = document.getElementById('result');
    let customerTableElement = document.getElementById('customers');

    let searchEmail = inputElement.value;

    let emailCells = customerTableElement.querySelectorAll('#customers tbody tr td:nth-child(2)');

    let foundEmail = Array.from(emailCells).find(e => e.textContent === searchEmail);

    if(foundEmail) {
        foundEmail.parentElement.remove();
        resultElement.textContent = 'Deleted.'
    } else {
        resultElement.textContent = 'Not found.';
    }
}
