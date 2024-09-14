function solve (input) {

    class Movie {
        constructor(name, director, date) {
            this.name = name;
            this.director = director;
            this.date = date;
        }
    }

    let movies = [];

    for(let entry of input) {

       if(entry.includes('addMovie')) {

        let [_,name] = entry.split('addMovie ');
        movies.push(new Movie(name, null, null));

       } else if (entry.includes('directedBy')) {

        let [name,director] = entry.split(' directedBy ');
        let currentMovie = movies.find(m => m.name === name);

        if (currentMovie !== undefined) {
            currentMovie.director = director;
        }

       } else if (entry.includes('onDate')) {

        let [name, date] = entry.split(' onDate '); 
        let currentMovie = movies.find(m => m.name === name);

        if (currentMovie !== undefined) {
            currentMovie.date = date;
        }
       }
    }

    movies.forEach(m => m.director != null && m.name != null && m.date != null ? 
                                                 console.log(JSON.stringify(m)) 
                                                 : null);

}

// solve([
//     'addMovie Fast and Furious',
//     'addMovie Godfather',
//     'Inception directedBy Christopher Nolan',
//     'Godfather directedBy Francis Ford Coppola',
//     'Godfather onDate 29.07.2018',
//     'Fast and Furious onDate 30.07.2018',
//     'Batman onDate 01.08.2018',
//     'Fast and Furious directedBy Rob Cohen'
//     ]);

solve(
    [
        'addMovie The Avengers',
        'addMovie Superman',
        'The Avengers directedBy Anthony Russo',
        'The Avengers onDate 30.07.2010',
        'Captain America onDate 30.07.2010',
        'Captain America directedBy Joe Russo'
        ]
);
