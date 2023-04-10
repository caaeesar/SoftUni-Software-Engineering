package ObjectsAndClasses.lab.songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] arguments) {

        Scanner scanner = new Scanner(System.in);

        List<Song> songsList = new ArrayList<>();
        int lines = Integer.parseInt(scanner.nextLine());
        for (int currentLine = 1; currentLine <= lines; currentLine++) {

            String[] songInfo = scanner.nextLine().split("_");
            Song currentSong = new Song(songInfo[0], songInfo[1], songInfo[2]);
            songsList.add(currentSong);
        }
        final String searchTypeList = scanner.nextLine();
        if (searchTypeList.equals("all")) {
            songsList.forEach(System.out::println);
        } else {
            songsList.stream().filter(song -> song.getTypeList().equals(searchTypeList)).forEach(System.out::println);
        }
    }
}