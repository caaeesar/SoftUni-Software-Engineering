function solve (string) {
    let words = string.split(' ')
                      .map(word => word.toUpperCase())
                      .join(', ');
                      
    console.log(words);
}

solve('Hi, how are you?');