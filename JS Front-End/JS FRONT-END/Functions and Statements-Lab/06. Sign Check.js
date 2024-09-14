function solve(numOne, numTwo, numThree) {
    const multiply = (a, b) => a * b;
    let result = multiply(numOne, multiply(numTwo, numThree));

    if(result <= 0) {
        console.log('Negative');
    } else {
        console.log('Positive');
    }
}

solve(-6,
    -12,
     14);
