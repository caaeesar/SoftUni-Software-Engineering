package ObjectsAndClasses.lab.songs;

public class Song {
    private String typeList;
    private String songName;
    private String time;

    Song(String typeList, String songName, String time) {
        this.typeList = typeList;
        this.songName = songName;
        this.time = time;
    }

    public String getTypeList() {
        return this.typeList;
    }

    @Override
    public String toString() {
        return this.songName;
    }
}
