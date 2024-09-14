function solve(n, numbers) {
    let array = numbers
    .slice(0,n)
    .reverse()
    .join(' ');

    console.log(array);
}

solve(3, [10, 20, 30, 40, 50]);