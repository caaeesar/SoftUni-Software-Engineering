package softuni.exam.util;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;

public interface XmlParser {
    //<T> void serialize (T entity, String filePath) throws JAXBException;
    <T> T deserialize (Class<T> tClass, File file) throws JAXBException, FileNotFoundException;
}
