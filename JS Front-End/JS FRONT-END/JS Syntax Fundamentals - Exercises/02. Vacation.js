function solve (people, group, day) {
    let price;
    let discount;
    let totalPrice;

    if (group == 'Students') {
        switch (day) {
            case 'Friday':
            price = 8.45;
            break
            case 'Saturday':
            price = 9.80;
            break
            case 'Sunday':
            price = 10.46;
            break
        }

        totalPrice = people * price;

        if (people >= 30) {
            discount = 15 / 100;
            totalPrice -= (totalPrice * discount);
        }

    } else if (group == 'Business') {
        switch (day) {
            case 'Friday':
            price = 10.90;
            break
            case 'Saturday':
            price = 15.60;
            break
            case 'Sunday':
            price = 16;
            break
        }

        if (people >= 100) {
            people -= 10;
        }

        totalPrice = people * price;

    } else if (group == 'Regular') {
        switch (day) {
            case 'Friday':
            price = 15;
            break
            case 'Saturday':
            price = 20;
            break
            case 'Sunday':
            price = 22.50;
            break
        }

        totalPrice = people * price;

        if (people >= 10 && people <= 20) {
            discount = 5 / 100;
            totalPrice -= (totalPrice * discount);
        }
    }

    console.log('Total price: ' + totalPrice.toFixed(2));
}

//solve(30, "Students", "Sunday");
solve(40, "Regular", "Saturday")