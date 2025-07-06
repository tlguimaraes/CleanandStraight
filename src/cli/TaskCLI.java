package cli;

import service.TaskService;

import java.util.Scanner;

public class TaskCLI {
    private final TaskService service;
    private final Scanner scanner = new Scanner(System.in);

    public TaskCLI(TaskService service) {
        this.service = service;
    }

    public void run() {
        while (true) {
            System.out.println("\n1. Add Task  2. List Tasks  3. Complete Task  0. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt(); scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    service.addTask(title);
                }
                case 2 -> {
                    service.getAllTasks().forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("Enter task ID to complete: ");
                    int id = scanner.nextInt();
                    service.markTaskCompleted(id);
                }
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
