package org.example.home_work;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;

public class SerialJSON {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void saveToFile(Object object, String fileName) {
        try {
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File(fileName), object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object loadFromFile(String fileName) {
        try {
            return objectMapper.readValue(new File(fileName), Object.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
