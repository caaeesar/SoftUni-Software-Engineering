function solve(n) {
    const getNCols = (n, separator = ' ') => {
        return `${n}${separator}`.repeat(n).trim();
    }
    for(let row = 1; row <= n; row++) {
       console.log(getNCols(n));
    } 
}

solve(3);
