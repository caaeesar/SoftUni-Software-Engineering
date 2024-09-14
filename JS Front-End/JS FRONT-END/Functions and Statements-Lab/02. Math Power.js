function solve (number, n) {
    let result = 1;
    for (let i = 1; i <= n; i++) {
        result *= number;
    }
    
    return result;
}

solve(3,4);
