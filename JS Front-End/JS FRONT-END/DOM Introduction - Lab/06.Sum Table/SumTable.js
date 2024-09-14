function sumTable() {
    const rows = document.querySelectorAll('table tbody tr');
    let total = 0;

    for (let i = 1; i < rows.length - 1; i++) {
        const costCell = rows[i].cells[1];
        total += parseFloat(costCell.textContent);
    }

    document.getElementById('sum').textContent = total.toFixed(2);
}
