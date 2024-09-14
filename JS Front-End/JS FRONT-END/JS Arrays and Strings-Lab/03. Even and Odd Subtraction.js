function solve(numbers) {
    let oddSum = 0;
    let evenSum = 0;

    numbers.filter(number => number % 2 == 0)
            .forEach(number => {
                  evenSum += number;
            });

    numbers.filter(number => number % 2 != 0)
            .forEach(number => {
                oddSum += number;
            });

    console.log(evenSum - oddSum);

}

//solve([1,2,3,4,5,6]);
solve([3,5,7,9]);