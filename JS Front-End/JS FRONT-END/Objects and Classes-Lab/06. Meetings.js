function solve(input) {
    let meetings = {};

    for(let entry of input) {
       let [weekday, name] = entry.split(' ');

       if(!meetings[weekday]) {
            meetings[weekday] = name;
            console.log(`Scheduled for ${weekday}`);
       } else {
        console.log(`Conflict on ${weekday}!`);
       }
    }

    for(let key in meetings) {
        console.log(`${key} -> ${meetings[key]}`);
    }
}

solve(['Monday Peter',
    'Wednesday Bill',
    'Monday Tim',
    'Friday Tim']
);
