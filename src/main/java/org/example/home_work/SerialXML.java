package org.example.home_work;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;

public class SerialXML {

    private static final XmlMapper xmlMapper = new XmlMapper();

    public static void saveToFile(Object object, String fileName) {
        try {
            xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            xmlMapper.writeValue(new File(fileName), object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object loadFromFile(String fileName) {
        try {
            return xmlMapper.readValue(new File(fileName), Object.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
