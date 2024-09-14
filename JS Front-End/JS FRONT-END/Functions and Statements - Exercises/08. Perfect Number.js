function solve(number) {
    const isPositive = number => number > 0;
    const divisors = [];
    for(let divisor = 1; divisor <= number / 2; divisor++) {
        if(number % divisor !== 0) {
            continue;
        }
        divisors.push(divisor);
    }

    const sumOfDivisors = divisors.reduce((a, b) => a + b, 0);

    if(isPositive && sumOfDivisors === number) {
        console.log('We have a perfect number!');
    } else {
        console.log('It\'s not so perfect.');
    }
}

solve(1236498);
