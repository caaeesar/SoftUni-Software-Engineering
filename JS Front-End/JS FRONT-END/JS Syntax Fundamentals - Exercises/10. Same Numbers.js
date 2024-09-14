function solve (number) {
    const digit = number % 10;
    let sum = 0;
    let isSame = true;
    while (number > 0) {
        let currentDigit = number % 10;
        sum += currentDigit;
        number = Math.floor(number / 10);
        
        if (digit !== currentDigit) {
            isSame = false;
        }
    }
    console.log(isSame);
    console.log(sum);
}

solve(1234);