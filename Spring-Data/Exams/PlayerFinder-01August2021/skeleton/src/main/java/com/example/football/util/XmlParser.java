package com.example.football.util;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;

public interface XmlParser {
    <T> T deserialize (Class<T> tClass, File filePath) throws JAXBException, FileNotFoundException;
}
