function solve(num1, num2, num3) {
    const sumNumbers = (a, b) => a + b;
    const substractNumbers = (a, b) => (a - b); 

    const total = sumNumbers(num1, num2);
    const finalResult = substractNumbers(total, num3);

    console.log(finalResult);
}

solve(42,
    58,
    100);
