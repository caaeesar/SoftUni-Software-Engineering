/*function solve(text, word) {
    let result = text.replaceAll(word, '*'.repeat(word.length));
    console.log(result);
} */

function solve(text, word) {
    while (text.includes(word)) {
        text = text.replace(word, '*'.repeat(word.length));
    }
    console.log(text);
}

solve('A small sentence with some words', 'small');