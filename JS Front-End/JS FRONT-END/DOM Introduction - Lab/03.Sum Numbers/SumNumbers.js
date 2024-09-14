function calc() {
    let num1Element = document.getElementById('num1');
    let num2Element = document.getElementById('num2');
    let sumElement = document.getElementById('sum');

    let firstNum = Number(num1Element.value);
    let secondNum = Number(num2Element.value);

    sumElement.value = firstNum + secondNum;
}
