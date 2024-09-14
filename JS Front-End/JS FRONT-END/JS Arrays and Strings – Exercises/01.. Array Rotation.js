function solve(array, n) {
    for(let i = 1; i <= n; i++) {
        let first = array.shift();
         array.push(first);
    }
    
   console.log(array.join(' '));
}

solve([2, 4, 15, 31], 5);