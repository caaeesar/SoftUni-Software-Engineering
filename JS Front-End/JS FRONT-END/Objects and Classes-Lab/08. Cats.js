function solve(input) {

    class Cat {
        constructor(name, age) {
            this.name = name;
            this.age = age;
        }

        meow() {
            console.log(`${this.name}, age ${this.age} says Meow`);
        }
    }

    let cats = [];

    for(let entry of input) {
        let [name, age] = entry.split(' ');
        cats.push(new Cat(name, age));
    }

    cats.forEach(c => c.meow());
}

solve(['Mellow 2', 'Tom 5']);
