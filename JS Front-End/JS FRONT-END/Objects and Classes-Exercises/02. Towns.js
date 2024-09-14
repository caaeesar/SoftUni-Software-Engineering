function solve(input) {

    // class Town {
    //     constructor(town, latitude, longitude) {
    //         this.town = town;
    //         this.latitude = Number(latitude).toFixed(2);
    //         this.longitude = Number(longitude).toFixed(2);
    //     }

    //     displayObject() {
    //         console.log(`{ town: '${this.town}', latitude: '${this.latitude}', longitude: '${this.longitude}' }`);
    //     }

    // }

    // const towns = [];

    // for(let entry of input) {
    //     let [town, latitude, longitude] = entry.split(' | ');
    //     towns.push(new Town(town, latitude, longitude));
    // }

    // towns.forEach(town => town.displayObject());

    const towns = input.reduce((acc, entry) => {
        let [town, latitude, longitude] = entry.split(' | ');
          acc.push(
            {
                town,
                latitude: Number(latitude).toFixed(2),
                longitude: Number(longitude).toFixed(2)
            }
        );
        return acc;
    }, [])


   towns.forEach(town => {
       console.log(town);
    });

}

solve(['Sofia | 42.696552 | 23.32601',
    'Beijing | 39.913818 | 116.363625']);
