function solve(product, quantuty) {
    let price = 0;

    switch(product) {
        case 'coffee':
            price = 1.50;
            break
        case 'water':
            price = 1.00;
            break
        case 'coke':
            price = 1.40;
            break
        case 'snacks':
            price = 2.00;
            break
    }
    console.log((price * quantuty).toFixed(2));
}

solve("coffee", 2);
