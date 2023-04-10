package StreamsFilesDirectories.lab.SerializeCustomObject;

import java.io.*;

public class Main {
    public static void main(String[] arguments) {
        Cube cube = new Cube("green", 15.3,12.4,3.0);

        String path = "src/StreamsFilesDirectories/resources/savedObject.ser";

        try (
                ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path));
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))
                ){

            outputStream.writeObject(cube);
            Cube objectFromFile = (Cube)inputStream.readObject();

        } catch (IOException ignored) {

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
