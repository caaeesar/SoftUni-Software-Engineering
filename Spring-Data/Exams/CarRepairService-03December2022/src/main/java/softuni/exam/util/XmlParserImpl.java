package softuni.exam.util;

import org.springframework.stereotype.Component;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;


@Component
public class XmlParserImpl implements XmlParser {
    private JAXBContext jaxbContext;
/*
    @Override
    public <T> void  serialize(T entity, String toFilePath) throws JAXBException {
        jaxbContext = JAXBContext.newInstance(entity.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(entity, new File(toFilePath));
    }*/

    @Override
    @SuppressWarnings("unchecked")
    public <T> T deserialize(Class<T> tClass, File file) throws JAXBException, FileNotFoundException {
        jaxbContext = JAXBContext.newInstance(tClass);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        T object = (T) unmarshaller.unmarshal(file);
        return object;
    }
}

