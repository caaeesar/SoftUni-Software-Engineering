function solve(text) {
    const pattern = new RegExp('#[A-Za-z]+', 'g');
    const matches = text.matchAll(pattern);
    for(const match of matches) {
        console.log(match[0].substring(1));
    } 
}

solve('Nowadays everyone uses # to tag a #special word in #socialMedia');
solve('The symbol # is known #variously in English-speaking #regions as the #number sign');