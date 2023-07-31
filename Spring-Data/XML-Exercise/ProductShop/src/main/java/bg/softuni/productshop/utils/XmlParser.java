package bg.softuni.productshop.utils;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XmlParser {

    <T> void serialize (T entity, String filePath) throws JAXBException;

    <T> T deserialize (Class<T> tClass,String filePath) throws JAXBException, FileNotFoundException;

}
