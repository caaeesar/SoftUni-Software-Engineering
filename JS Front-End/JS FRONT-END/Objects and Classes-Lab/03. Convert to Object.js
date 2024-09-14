function solve(jsonStr) {
    let person = JSON.parse(jsonStr);

    Object.keys(person)
          .forEach(key => console.log(`${key}: ${object[key]}`));
}

solve('{"name": "George", "age": 40, "town": "Sofia"}');
