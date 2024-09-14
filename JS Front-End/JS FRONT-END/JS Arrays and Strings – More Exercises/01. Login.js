function solve(array) {
    const username = array.shift();
    const password = username.split('').reverse().join('');


    let attempts = 0;
    let i = 0;
    while (i < array.length) {
    
        if(password === array[i]) {
            console.log(`User ${username} logged in.`);
        } else {
            attempts++;
            if(attempts == 4) {
                console.log(`User ${username} blocked!`);
                break;
            } else {
                console.log('Incorrect password. Try again.');
            }

        }
        i++;
    }
}

solve(['sunny','rainy','cloudy','sunny','not sunny']);
