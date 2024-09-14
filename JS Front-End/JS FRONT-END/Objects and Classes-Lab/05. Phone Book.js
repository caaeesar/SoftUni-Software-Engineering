function solve(input) {
    let phonebook = {};

    for (const entry of input) {
       let [name, phoneNumber] = entry.split(' ');

       phonebook[name] = phoneNumber;
    }

    console.log(phonebook);

    for(let key in phonebook) {
        console.log(`${key} -> ${phonebook[key]}`);
    }
}

solve(['Tim 0834212554',
    'Peter 0877547887',
    'Bill 0896543112',
    'Tim 0876566344']
);
