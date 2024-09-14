function solve(input) {
    let parkingLot = {};

    for (let entry of input) {
        let [direction, carNumber] = entry.split(', ');

        if (direction === 'IN') {
            parkingLot[carNumber] = true;
        } else if (direction === 'OUT') {
            delete parkingLot[carNumber];
        }
    }

    let carNumbers = Object.keys(parkingLot);

    if (carNumbers.length === 0) {
        console.log("Parking Lot is Empty");
    } else {
        carNumbers
            .sort((a, b) => a.localeCompare(b))
            .forEach(carNumber => console.log(carNumber));
    }
}

solve(['IN, CA2844AA',
    'IN, CA1234TA',
    'OUT, CA2844AA',
    'IN, CA9999TT',
    'IN, CA2866HI',
    'OUT, CA1234TA',
    'IN, CA2844AA',
    'OUT, CA2866HI',
    'IN, CA9876HH',
    'IN, CA2822UU']);
