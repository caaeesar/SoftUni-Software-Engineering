package StreamsFilesDirectories.lab;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class NestedFolders {
    public static void main(String[] arguments) {

        // обхождане на дървовидна стуктура:
        File root = new File("src/StreamsFilesDirectories/resources_lab/Files-and-Streams");
        Deque<File> directories = new ArrayDeque<>();
        directories.offer(root);
        System.out.println(root.getName());

        int count = 1;

        while (!directories.isEmpty()) {

            File current = directories.poll();
            System.out.println(current.getName());
            File[] files = current.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    count++;
                    directories.offer(file);
                }
            }
        }
        System.out.print(count);
    }
}

/**
 * Files-and-Streams
 * Files-and-Streams
 * Serialization
 * Streams-and-Files
 * Serialization
 * Streams-and-Files
 * Files-and-Streams
 * Streams-and-Files
 * Files-and-Streams
 * Serialization
 * Serialization
 * Streams-and-Files
 * Serialization
 * Streams-and-Files
 * Files-and-Streams
 * Streams-and-Files
 * Serialization
 * Streams-and-Files
 * 18 folders
 */
