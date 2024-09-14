function solve(availableProducts, orderedProducts) {
    const productQuantity = {};

    for(let i = 1; i < availableProducts.length; i+=2) {
        let product = availableProducts[i - 1];
        let quantity = availableProducts[i]
        productQuantity[product] = quantity;
    
    }

    for(let i = 1; i < orderedProducts.length; i+=2) {
        let product = orderedProducts[i - 1];
        let quantity = orderedProducts[i]

        let currentQuantity = productQuantity[product];

        if(productQuantity.hasOwnProperty(product)) {
            let newQuantity = Number(currentQuantity) + Number(quantity);
            productQuantity[product] =  newQuantity;
        } else {
            productQuantity[product] = quantity;
        }
    
    }

    let productKeys = Object.keys(productQuantity);

    for (const key of productKeys) {
        console.log(`${key} -> ${productQuantity[key]}`);
    }

}

solve([
    'Chips', '5', 'CocaCola', '9', 'Bananas', '14', 'Pasta', '4', 'Beer', '2'
    ],
    [
    'Flour', '44', 'Oil', '12', 'Pasta', '7', 'Tomatoes', '70', 'Bananas', '30'
    ]);
