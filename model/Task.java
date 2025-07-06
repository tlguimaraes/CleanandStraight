package model;

public class Task {
    private int id;
    private String title;
    private boolean completed;

    public Task(int id, String title) {
        this.id = id;
        this.title = title;
        this.completed = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public boolean isCompleted() { return completed; }

    public void markCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return id + ". " + title + (completed ? " [Done]" : "");
    }
}
