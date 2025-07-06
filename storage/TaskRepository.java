package storage;

import model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private final List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public void saveTask(Task task) {
        tasks.add(task);
        nextId++;
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    public void completeTask(int taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                task.markCompleted();
                break;
            }
        }
    }

    public int getNextId() {
        return nextId;
    }
}
