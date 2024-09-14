/* function solve (array) {

    let first = array[0];
    let last = array[array.length - 1];

    console.log(first + last);
} */

function solve(array) {
    let first = array.shift();
    let last = array.pop();
    console.log(first + last);
}

solve([10, 17, 22, 33]);