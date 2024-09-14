function solve(number) {
    const oddNumbers = [];
    const evenNumbers = [];

    while (number > 0) {
        const currentDigit = number % 10;
        if (currentDigit % 2 === 0) {
            evenNumbers.push(currentDigit);
        } else {
            oddNumbers.push(currentDigit);
        }
        number = Math.floor(number / 10);
    }

    const sumNumbers = (numbers) => {
        let sum = 0;
        numbers.forEach(num => {
            sum += num;
        });
        return sum;
    };

    const oddSum = sumNumbers(oddNumbers);
    const evenSum = sumNumbers(evenNumbers);

    console.log(`Odd sum = ${oddSum}, Even sum = ${evenSum}`);
}

solve(3495892137259234); 
