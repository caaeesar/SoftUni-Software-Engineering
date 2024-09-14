function solve(numbers) {
    const reverseString = str => {
        return  str.split("").reverse().join("");
    }

    const checkIfIsPalindrome = number => {
        let reversedNumber = reverseString(number.toString());
        return number.toString() === reversedNumber;
    }

    for(let currentNumber of numbers) {
        let isPalindrome = checkIfIsPalindrome(currentNumber);
        console.log(isPalindrome);
    }
}

solve([32,2,232,1010]);
