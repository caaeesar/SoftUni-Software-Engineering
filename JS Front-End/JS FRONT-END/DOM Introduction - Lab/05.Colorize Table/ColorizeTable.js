function colorize() {
    let evenTableRowElements = document.querySelectorAll('table tbody tr:nth-child(even)');
    for (let trElement of evenTableRowElements) {
               trElement.style.backgroundColor = 'teal';
    }
}

