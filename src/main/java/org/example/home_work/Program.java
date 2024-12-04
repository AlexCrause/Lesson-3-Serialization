package org.example.home_work;
/**
 * Задание 1:
 * Разработайте класс Student с полями String name, int age7 transient double GPA (средний балл).
 * Обеспечьте поддержку сериализации для этого класса.
 * Создайте объект класса Student и инициализируйте его данными.
 * Сериализируйте этот объект в файл.
 * Десериализируйте объект обратно в программу из файла.
 * Выведите все поля объекта, включая GPA, и обсудите почему значение GPA не было сохранено/восстановлено.
 *
 * Задание 2 (не обязательно):
 * ** Выполнить задачу 1 используя другие типы сериализаторов (в xml и json документов).
 */
public class Program {
    public static void main(String[] args) {

        Student student = new Student("Ivan", 20, 4.0);

        SerialBIN.saveToFile(student, "student.bin");
        SerialBIN.loadFromFile("student.bin");


        SerialJSON.saveToFile(student, "student.json");
        SerialJSON.loadFromFile("student.json");


        SerialXML.saveToFile(student, "student.xml");
        SerialXML.loadFromFile("student.xml");

        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("GPA: " + student.getGPA());
    }
}
