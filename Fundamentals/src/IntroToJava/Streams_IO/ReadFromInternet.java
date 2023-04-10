package IntroToJava.Streams_IO;

import java.io.*;
import java.net.URL;

public class ReadFromInternet {

    public static void main(String[] arguments) throws IOException {

      URL url = new URL("https://www.gutenberg.org/cache/epub/100/pg100.txt");
      BufferedReader fileReader = new BufferedReader(new InputStreamReader(url.openStream()));

      String line = fileReader.readLine();
      while (line != null) {
          System.out.println(line);
          line = fileReader.readLine();
      }
    }
}
