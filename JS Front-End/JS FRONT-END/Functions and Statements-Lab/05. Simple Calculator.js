function solve(numOne, numTwo, operation) {
    let calculate = null;

    switch (operation) {
        case 'multiply':
            calculate = (a, b) => a * b;
            break;
        case 'divide':
            calculate = (a, b) => a / b;
            break;
        case 'add':
            calculate = (a, b) => a + b;
            break
        case 'subtract':
            calculate = (a, b) => a - b;
            break;
    }

    let result = calculate(numOne, numTwo);
    console.log(result);
}

solve(50,
    13,
    'subtract');
