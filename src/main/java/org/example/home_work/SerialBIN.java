package org.example.home_work;

import java.io.*;

public class SerialBIN {

    public static void saveToFile(Object object, String fileName) {

        try (FileOutputStream fos = new FileOutputStream(fileName)){
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)){
                oos.writeObject(object);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object loadFromFile(String fileName) {

        try (FileInputStream fis = new FileInputStream(fileName)){
            try (ObjectInputStream ois = new ObjectInputStream(fis)){
                ois.readObject();
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
