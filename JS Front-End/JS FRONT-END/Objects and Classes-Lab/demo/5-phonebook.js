function fancySolve(input) {
    let result = input
        .map(entry => entry.split(' '))
        .reduce((phonebook, [name, phone]) => {
            phonebook[name] = phone;

            return phonebook;
        }, {});

    for (const name in result) {
        console.log(`${name} -> ${result[name]}`);
    }
}

fancySolve(['Tim 0834212554',
    'Peter 0877547887',
    'Bill 0896543112',
    'Tim 0876566344']
);