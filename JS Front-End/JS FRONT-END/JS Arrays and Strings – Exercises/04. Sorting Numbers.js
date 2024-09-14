function solve(numbers) {
    const newArr = [];
    numbers.sort((a,b) => a - b).forEach(element => {
        newArr.push(element);
    });
    
    const output = [];
    while(newArr.length > 0) {
        output.push(newArr.shift());
        output.push(newArr.pop());
    }
    //console.log(output);
    return output;
}

solve([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]);