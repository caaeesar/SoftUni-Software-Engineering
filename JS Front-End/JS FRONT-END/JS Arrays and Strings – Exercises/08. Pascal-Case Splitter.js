function solve(str) {
    const patter = new RegExp('[A-Z]([a-z]*)', 'g');
    let matches = str.matchAll(patter);
    let output = [];
    for(let match of matches) {
        output.push(match[0]);
    }
    console.log(output.join(', '));
}

solve('SplitMeIfYouCanHaHaYouCantOrYouCan');