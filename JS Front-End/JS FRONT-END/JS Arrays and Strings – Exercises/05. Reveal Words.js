function solve(array, text) {
    let keyWords = array.split(', ');
    for (let index = 0; index < keyWords.length; index++) {
        let keyWord = keyWords[index];
        text = text.replace('*'.repeat(keyWord.length),keyWord)
    } 
    console.log(text);
}

solve('great, learning',
'softuni is ***** place for ******** new programming languages');