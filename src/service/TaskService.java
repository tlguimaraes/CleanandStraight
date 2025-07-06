package service;

import model.Task;
import storage.TaskRepository;

import java.util.List;

public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public void addTask(String title) {
        Task task = new Task(repository.getNextId(), title);
        repository.saveTask(task);
    }

    public List<Task> getAllTasks() {
        return repository.getTasks();
    }

    public void markTaskCompleted(int taskId) {
        repository.completeTask(taskId);
    }
}

