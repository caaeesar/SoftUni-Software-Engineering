function solve(char1, char2) {
    const getAsciiCode = c => c.charCodeAt(0);
    const findStartChar = (c1, c2) => Math.min(getAsciiCode(c1), getAsciiCode(c2));
    const findEndChar = (c1, c2) => Math.max(getAsciiCode(c1), getAsciiCode(c2));
    const characterInRange = (start, end) => {
        const characters = [];
        for(let ascii = start + 1; ascii < end; ascii++) {
            const currentChar = String.fromCharCode(ascii);
            characters.push(currentChar);
        }
     return characters;
    }

    const output = characterInRange(findStartChar(char1, char2), findEndChar(char1, char2));
    console.log(output.join(' '));
}

solve('C',
'#');
