package org.example.task2;

import java.io.Serializable;

public class ToDoV1 implements Serializable {

    // region Fields
    /**
     * Наименование задачи
     */
    private String title;

    /**
     * Статус задачи
     */
    private boolean isDone;
    // endregion

    // region Constructors
    public ToDoV1() {}

    public ToDoV1(String title) {
        this.title = title;
        isDone = false;
    }
    // endregion

    // region Methods

    /**
     * Получить наименование задачи
     * @return наименование задачи
     */
    public String getTitle() {
        return title;
    }

    /**
     * Установить наименование задачи
     * @param title наименование задачи
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Получить статус задачи
     * @return статус задачи
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Установить статус задачи
     * @param done статус задачи
     */
    public void setDone(boolean done) {
        isDone = done;
    }
    // endregion
}
