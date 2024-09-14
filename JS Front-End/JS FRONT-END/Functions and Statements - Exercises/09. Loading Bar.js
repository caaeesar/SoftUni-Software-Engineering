function solve(number) {
    const maxSymbols = 10;
    let persentages = '%'.repeat(number / 10);
    let dots = '.'.repeat(maxSymbols - (number / 10));
    if (number === 100) {
        console.log(`${number}% Complete!`);
        console.log(`[${persentages}]`);
    } else {
        console.log(`${number}% [${persentages}${dots}]`);
        console.log(`Still loading...`);
    }
}

solve(50);
