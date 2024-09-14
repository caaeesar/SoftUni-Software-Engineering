function solve(array) {
    array.sort((a,b) => a.localeCompare(b)).map((element, index) => {
            console.log(`${index + 1}.${element}`);
});
}

solve(["John", "Bob", "Christina", "Ema"]);