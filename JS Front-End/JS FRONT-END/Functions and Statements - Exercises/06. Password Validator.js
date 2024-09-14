function solve(password) {
    function isValidLength(str) {
      return  str.length >= 6 && str.length <= 10;
    }

    function haveLettersAndDigits  (str) {
        const regex = new RegExp('^[A-Za-z0-9]+$', 'gm');
        return regex.test(str);
    }

    function hasAtLeastTwoDigits (str) {
        const regex = new RegExp('[0-9]{2,}', 'gm');
        return str.match(regex);
    }

    const isValidPassword = password => {
        return isValidLength(password) && haveLettersAndDigits(password) && hasAtLeastTwoDigits(password);
    }

    if(isValidPassword(password)) {
        console.log('Password is valid');
    } else {
        if(!isValidLength(password)) {
            console.log('Password must be between 6 and 10 characters');
        } 
        if(!haveLettersAndDigits(password)) {
            console.log('Password must consist only of letters and digits');
        } 
        if(!hasAtLeastTwoDigits(password)) {
            console.log('Password must have at least 2 digits');
        }
    }
}

solve('logIn');
