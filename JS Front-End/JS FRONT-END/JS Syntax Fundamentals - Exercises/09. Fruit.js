function solve (fruit, kg, price) {
    let money = price * (kg / 1000);
    console.log(`I need $${money.toFixed(2)} to buy ${(kg / 1000).toFixed(2)} kilograms ${fruit}.`);
}

solve('apple', 1563, 2.35);