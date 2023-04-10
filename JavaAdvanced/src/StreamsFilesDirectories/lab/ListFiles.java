package StreamsFilesDirectories.lab;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListFiles {
    public static void main(String[] arguments) {

        String folderPath = "src/StreamsFilesDirectories/resources/Files-and-Streams";

        File folder = new File(folderPath);

        File[] files = folder.listFiles();

        for (File file : files) {

            if (!file.isDirectory()) {
                System.out.printf("%s: [%d]\n", file.getName(), file.length());
            }

        }
    }
}
