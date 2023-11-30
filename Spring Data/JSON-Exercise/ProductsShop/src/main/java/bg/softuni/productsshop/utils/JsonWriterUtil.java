package bg.softuni.productsshop.utils;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;


@Component
public class JsonWriterUtil {

    public static void writeToJson(List<String> jsonContent, Path path) throws IOException {
       Files.write(path, jsonContent);
    }


}
