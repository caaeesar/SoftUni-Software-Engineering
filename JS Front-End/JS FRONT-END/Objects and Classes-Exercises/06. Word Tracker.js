function solve(input) {

    let [keyWords, ...words] = input;

    let wordsCount = keyWords.split(' ').reduce((acc, word) => {
        acc[word] = 0;
        return acc;
    },{});

    words.forEach(word => {
        if(wordsCount.hasOwnProperty(word)) {
            wordsCount[word] += 1;
        }
    });

    Object.keys(wordsCount)
    .sort((a,b) => wordsCount[b] - wordsCount[a])
    .forEach(word => console.log(`${word} - ${wordsCount[word]}`));
}

solve([
    'this sentence', 
    'In', 'this', 'sentence', 'you', 'have', 'to', 'count', 'the', 'occurrences', 'of', 'the', 'words', 'this', 'and', 'sentence', 'because', 'this', 'is', 'your', 'task'
    ]);
