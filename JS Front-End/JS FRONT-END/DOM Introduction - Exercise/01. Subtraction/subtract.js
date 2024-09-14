function subtract() {
    let firstNumber = document.getElementById('firstNumber').value;
    let secondNumber = document.getElementById('secondNumber').value;

    let result = document.getElementById('result').textContent = firstNumber - secondNumber;
    console.log(result);
}
