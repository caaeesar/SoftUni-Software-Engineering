package StreamsFilesDirectories.exercises;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class GetFolderSize {
    public static void main(String[] arguments) {

        // обхождане на дървовидна стуктура:
        File root = new File("src/StreamsFilesDirectories/resources_ex/Exercises Resources");
        Deque<File> directories = new ArrayDeque<>();
        directories.offer(root);

        int sumOfBytes = 0;

        while (!directories.isEmpty()) {

            File current = directories.poll();
            File[] files = current.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    directories.offer(file);
                } else {
                    sumOfBytes += file.length();
                }
            }
        }
        System.out.println("Folder size: " + sumOfBytes);
    }
}
