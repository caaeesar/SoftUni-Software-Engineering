function solve(input) {

    class Song {
        constructor(type, name, time) {
            this.type = type;
            this.name = name;
            this.time = time;
        }

        print() {
            console.log(this.name);
        }
    }

    let numberOfSong = input.shift();
    let typeSong = input.pop();

    let songs = [];

    for(let i = 0; i < numberOfSong; i++) {
       let [type, name, time] = input[i].split('_');
       let currentSong = new Song(type, name, time);
       songs.push(currentSong);
    }

    if(typeSong === 'all') {
        songs.forEach(s => s.print());
    } else {
      songs.filter(s => s.type === typeSong)
           .forEach(s => s.print());
    }
}

solve([4,
    'ban_hey_3:48',
    'programming_ban_3:42',
    'ban_hello_3:29',
    'like_like_3:05',
    'all']
);
