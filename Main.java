import cli.TaskCLI;
import service.TaskService;
import storage.TaskRepository;

public class Main {
    public static void main(String[] args) {
        TaskRepository repo = new TaskRepository();
        TaskService service = new TaskService(repo);
        TaskCLI cli = new TaskCLI(service);
        cli.run();
    }
}
