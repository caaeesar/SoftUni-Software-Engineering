function solve(array, step) {
    let output = [];
    for (let index = 0; index < array.length; index++) {
        if (index % step == 0) {
        output.push(array[index]);
        }
    }
    return output;
}

solve(['dsa',
    'asd', 
    'test', 
    'tset'], 
    2);