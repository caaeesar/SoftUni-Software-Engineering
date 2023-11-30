// 1. Sort Array:
function sortingArray(array, sorting) {

    if(sorting === "asc") {
       return array.sort((a,b) => a - b);
    }
    return array.sort((a,b) => b - a);
}

 console.log(sortingArray([14, 7, 17, 6, 8], 'asc'));
 console.log(sortingArray([14, 7, 17, 6, 8], 'desc'));

// 2. Argument Info:
function argumentInfo() {

    let map = new Map();
    
    for (let arg of arguments) {
        let type = typeof arg;
    

    if(!map.has(type)) {
        map.set(type, 0);
    }

    map.set(type, map.get(type) + 1);
    console.log(`${type}: ${arg}`);
    }

    [...map.entries()].sort((a,b) => b[1] - a[1]).forEach(pairs => console.log(`${pairs[0]} = ${pairs[1]}`));
}

argumentInfo('cat', 42, function () { console.log('Hello world!'); });

// 3. Personal BMI:

function personalBMI(name, age, weight, height) {

    let bmi = Math.round(weight / (height / 100 * height / 100));

    let status = () => {

        if (bmi < 18.5) {
            return "underweight";
        }
        if (bmi < 25) {
            return "normal";
        }

        if (bmi < 30) {
            return "overweight";
        }
            return "obese"; 
    }

      let result = { name: name,
                     personalInfo: {
                    age: age,
                    weight: weight,
                    height: height
                    },
                    BMI: bmi,
                    status: status() }

        if(status() === "obese") {
            result.recommendation = "admission required";
        }

    return result;
}

console.log(personalBMI("Peter", 29, 75, 182));
console.log(personalBMI("Honey Boo Boo", 9, 57, 137));