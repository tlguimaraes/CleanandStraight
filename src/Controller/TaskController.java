@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getTasks() { return taskService.getAllTasks(); }

    @PostMapping
    public void addTask(@RequestBody Task task) { taskService.addTask(task.getTitle()); }

    @PutMapping("/{id}/complete")
    public void completeTask(@PathVariable int id) { taskService.markTaskCompleted(id); }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id) { taskService.deleteTask(id); }
}
