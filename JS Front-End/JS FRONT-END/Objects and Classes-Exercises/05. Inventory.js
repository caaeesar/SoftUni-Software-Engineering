function solve(input) {

    class Hero {
        constructor(name, level, items) {
            this.name = name;
            this.level = parseInt(level);
            this.items = items;
        }
        displey() {
            console.log(`Hero: ${this.name}\nlevel => ${this.level}\nitems => ${this.items}`);
        }
    }
 

    let heroes = [];

    for(let entry of input) {
        let [name, level, items] = entry.split(' / ');
        heroes.push(new Hero(name, level, items));
    }

    
    heroes.sort((a, b) => a.level - b.level).forEach(h => h.displey());

}


solve([
    'Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara'
    ]);
