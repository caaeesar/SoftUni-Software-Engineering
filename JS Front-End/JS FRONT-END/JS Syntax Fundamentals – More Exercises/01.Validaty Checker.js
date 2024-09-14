function isIntegerDistance(x1, y1, x2, y2) {
    const distance = Math.sqrt((x2 - x1) ** 2 + (y2 - y1) ** 2);
    return Number.isInteger(distance);
}

function checkDistances(x1, y1, x2, y2) {

    if (isIntegerDistance(x1, y1, 0, 0)) {
        console.log(`(${x1}, ${y1}) до (0, 0) is valid`);
    } else {
        console.log(`(${x1}, ${y1}) до (0, 0) is invalid`);
    }

    if (isIntegerDistance(x2, y2, 0, 0)) {
        console.log(`(${x2}, ${y2}) до (0, 0) is valid`);
    } else {
        console.log(`(${x2}, ${y2}) до (0, 0) is invalid`);
    }

    if (isIntegerDistance(x1, y1, x2, y2)) {
        console.log(`(${x1}, ${y1}) до (${x2}, ${y2}) is valid`);
    }
}

checkDistances(3, 0 , 0 ,4);
