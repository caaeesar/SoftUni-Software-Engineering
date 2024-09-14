function solve(num1, num2) {
    function factorial(num) {
        let result = 1;
        for (let f = 1; f <= num; f++) {
            result *= f;
        }
        return result;
    }

    console.log((factorial(num1) / factorial(num2)).toFixed(2));
}

solve(6, 2);
