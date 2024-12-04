package org.example.task1;

import java.io.*;

/**
 *
 /**
 + Задача 1
 *
    <p>
 * Создайте класс UserData с полями String name, int age, transient String password
 * Поле password должно быть отмечено ключевым словом transient
 * Реализуйте интерфейс Serializaple в вашем классе.
 * В методе moin создайте змземпляр класса UserData и инициализируйте его данными.
 + Сериализуйте этот объект в файл используя ObjectOutputStream в сочетании с FileOutputStream
 * <p>
 *
 + Задача 2
 *
 * <p>
 * Десериализуйте объект из ранее созданного файла обратно в объект Java,
 * используя ObjectInputStream в сочетании с FileInputStream.
 * Выведите данные десериализованного объекта UserData
 * Сравните данные до сериализации и после десериализации, особенно обратите внимание на поле, помеченное как transient.
 * Обсудите, почему это поле не было сохранено после десериализации.
 */
public class Program {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        UserData user = new UserData("Ivan", 20, "123");

        try (FileOutputStream fileOutputStream = new FileOutputStream("UserData.bin")){
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(user);
            System.out.println("Object UserData was serialized");
        }

        try (FileInputStream fileInputStream = new FileInputStream("UserData.bin")){
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            user = (UserData) objectInputStream.readObject();
            System.out.println("Object UserData was deserialized");
            System.out.println(user);
        }

        System.out.println("Object UserData was deserialized");
        System.out.println("Имя: " + user.getName());
        System.out.println("Возраст: " + user.getAge());
        System.out.println("Пароль (должен быть null так как transient): " + user.getPassword());
    }
}
