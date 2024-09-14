function solve (from, to) {
    let sum = 0;
    let array = [];

    for (let i = from; i <= to; i++) {
        sum += i;
        array.push(i);
    }
    console.log(array.join(' '));
    console.log('Sum: ' + sum);
}

solve(50, 60);