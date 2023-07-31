package softuni.exam.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;

public class XmlParserImpl implements XmlParser {
    private JAXBContext jaxbContext;

    @Override
    @SuppressWarnings("unchecked")
    public <T> T deserialize(Class<T> tClass, File file) throws JAXBException, FileNotFoundException {
        this.jaxbContext = JAXBContext.newInstance(tClass);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        T object = (T) unmarshaller.unmarshal(file);
        return object;
    }

}
