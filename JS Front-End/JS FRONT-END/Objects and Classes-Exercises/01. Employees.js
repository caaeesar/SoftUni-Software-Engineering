function solve(names) {
    
    // class Employee {
    //     constructor(name, personalNum) {
    //         this.name = name;
    //         this.personalNum = personalNum;
    //     }

    //     displayInfo() {
    //         console.log(`Name: ${this.name} -- Personal Number: ${this.personalNum}`);
    //     }
    // }

    // const allEmployees = [];

    // for(let name of names) {
    //     let personalNum = name.length;
    //     allEmployees.push(new Employee(name, personalNum));
    // }

    // allEmployees.forEach(e => e.displayInfo());

    names.reduce((acc, name) => {
    acc.push(
        {
            name,
            personalNum: name.length
        }
    );
    return acc;
   }, [])
   .forEach(employee => {
    console.log(`Name: ${employee.name} -- Personal Number: ${employee.personalNum}`);
   });

}

solve([
    'Samuel Jackson',
    'Will Smith',
    'Bruce Willis',
    'Tom Holland'
    ]);
