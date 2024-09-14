function solve(input) {
    let n = parseInt(input.shift());
    let superheroes = {};

    for (let i = 0; i < n; i++) {
        let [name, powerList, energy] = input[i].split('-');
        let powers = powerList.split(',');
        superheroes[name] = { powers: powers, energy: parseInt(energy) };
    }

     for (let i = 0; i < input.length; i++) {
        let command = input[i];

        if (command === "Evil Defeated!") {
            break;
        }

        let parts = command.split(" * ");
        let action = parts[0];
        let name = parts[1];

        switch (action) {
            case "Use Power":
                let power = parts[2];
                let energyRequired = parseInt(parts[3]);

                if (superheroes[name].powers.includes(power) && superheroes[name].energy >= energyRequired) {
                    superheroes[name].energy -= energyRequired;
                    console.log(`${name} has used ${power} and now has ${superheroes[name].energy} energy!`);
                } else {
                    console.log(`${name} is unable to use ${power} or lacks energy!`);
                }
                break;

            case "Train":
                let trainingEnergy = parseInt(parts[2]);
                let currentEnergy = superheroes[name].energy;

                if (currentEnergy === 100) {
                    console.log(`${name} is already at full energy!`);
                } else {
                    let gainedEnergy = Math.min(100 - currentEnergy, trainingEnergy);
                    superheroes[name].energy += gainedEnergy;
                    console.log(`${name} has trained and gained ${gainedEnergy} energy!`);
                }
                break;

            case "Learn":
                let newPower = parts[2];

                if (superheroes[name].powers.includes(newPower)) {
                    console.log(`${name} already knows ${newPower}.`);
                } else {
                    superheroes[name].powers.push(newPower);
                    console.log(`${name} has learned ${newPower}!`);
                }
                break;

        }
    }

    for (let [name, details] of Object.entries(superheroes)) {
        let powers = details.powers.join(', ');
        let energy = details.energy;
        console.log(`Superhero: ${name}\n - Superpowers: ${powers}\n - Energy: ${energy}`);
    }
}

// solve( ([
//      "3",
//      "Iron Man-Repulsor Beams,Flight-80",
//      "Thor-Lightning Strike,Hammer Throw-10",
//      "Hulk-Super Strength-60",
//      "Use Power * Iron Man * Flight * 30",
//      "Train * Thor * 20",
//      "Train * Hulk * 50",
//      "Learn * Hulk * Thunderclap",
//      "Use Power * Hulk * Thunderclap * 70",
//      "Evil Defeated!"
//     ]));

// solve( ([
//     "2",
//      "Iron Man-Repulsor Beams,Flight-20",
//      "Thor-Lightning Strike,Hammer Throw-100",
//      "Train * Thor * 20",
//      "Use Power * Iron Man * Repulsor Beams * 30",
//     "Evil Defeated!"
//     ]));

solve( ([
     "2",
     "Iron Man-Repulsor Beams,Flight-100",
    "Thor-Lightning Strike,Hammer Throw-50",
     "Train * Thor * 20",
     "Learn * Thor * Hammer Throw",
    "Use Power * Iron Man * Repulsor Beams * 30",
    "Evil Defeated!"
    ]));
