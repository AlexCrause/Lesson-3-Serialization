package org.example.task2;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ToDo implements Externalizable {

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
    public ToDo() {}

    public ToDo(String title) {
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

    // region Externalizable implementation
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(title);
        out.writeBoolean(isDone);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        title = (String) in.readObject();
        isDone = in.readBoolean();
    }
    // endregion
}
