package org.example.task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.task2.ToDoListApp.*;

public class Program {
    public static void main(String[] args) {

        List<ToDo> tasks;

        File f = new File(FILE_JSON);
        if (f.exists() && !f.isDirectory())
            tasks = loadTasksFromFile(FILE_JSON);
        else
            tasks = prepareTasks();
        ToDoListApp.saveTasksToFile(FILE_JSON, tasks);
        ToDoListApp.saveTasksToFile(FILE_BIN, tasks);
        ToDoListApp.saveTasksToFile(FILE_XML, tasks);

        displayTasks(tasks);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bыбеpитe действие:");
            System.out.println("1. Добавить новую задачу");
            System.out.println("2. Oтметить задачу как выполненную");
            System.out.println("3. Выйти");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    ToDoListApp.addNewTask(scanner, tasks);
                    break;
                case "2":
                    ToDoListApp.markTaskAsDone (scanner, tasks);
                    break;
                case "3":
                    ToDoListApp.saveTasksToFile(FILE_JSON, tasks);
                    ToDoListApp.saveTasksToFile(FILE_BIN, tasks);
                    ToDoListApp.saveTasksToFile(FILE_XML, tasks);
                    System.out.println("Список задач сохранен.");
                    scanner.close();
                    System.exit(8);
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова. ");
                    break;
            }
            displayTasks(tasks);
        }
    }


    static List<ToDo> prepareTasks() {

        ArrayList<ToDo> list = new ArrayList<>();
        list.add(new ToDo("Сходить в магазин за продуктами"));
        list.add(new ToDo("Погулять с собакой"));
        list.add(new ToDo("Заменить лампочку"));
        return list;
    }

}