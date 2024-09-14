function solve(input) {
    let addressBook = {};

    for(let entry of input) {
        let [name, address] = entry.split(':');
        addressBook[name] = address; 
    }

    Object.keys(addressBook)
           .sort((a, b) => a.localeCompare(b))
           .forEach(key => console.log(`${key} -> ${addressBook[key]}`));
}


solve(['Bob:Huxley Rd',
    'John:Milwaukee Crossing',
    'Peter:Fordem Ave',
    'Bob:Redwing Ave',
    'George:Mesta Crossing',
    'Ted:Gateway Way',
    'Bill:Gateway Way',
    'John:Grover Rd',
    'Peter:Huxley Rd',
    'Jeff:Gateway Way',
    'Jeff:Huxley Rd']
);
