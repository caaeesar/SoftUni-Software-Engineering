function solve(sentence) {

    let wordsCount = sentence.split(' ').reduce((acc, word) => {

        let key = word.toLowerCase();
        if(!acc.hasOwnProperty(key)) {
            acc[key] = 0;
        }
        acc[key] += 1;
        return acc;
    },{});

    console.log(Object.keys(wordsCount).filter(word => wordsCount[word] % 2 !== 0).join(' '));
}

solve('Java C# Php PHP Java PhP 3 C# 3 1 5 C#');
