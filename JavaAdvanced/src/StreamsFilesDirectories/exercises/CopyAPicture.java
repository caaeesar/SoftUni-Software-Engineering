package StreamsFilesDirectories.exercises;

import java.io.*;

public class CopyAPicture {
    public static void main(String[] arguments) throws IOException {

        InputStream inputStream = new FileInputStream("src/StreamsFilesDirectories/resources_ex/picture.jpeg");
        OutputStream outputStream = new FileOutputStream("src/StreamsFilesDirectories/resources_ex/pictureCopy.jpeg");

        byte[] buffer = new byte[1024];

        while (inputStream.read(buffer) != -1) {

            outputStream.write(buffer);
        }
        inputStream.close();
        outputStream.close();
    }
}
