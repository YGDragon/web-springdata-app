package web.ygdragon.appspringdata.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import web.ygdragon.appspringdata.model.Task;
import web.ygdragon.appspringdata.model.TaskStatus;
import web.ygdragon.appspringdata.service.TaskService;
import web.ygdragon.appspringdata.view.MessageView;

import java.util.List;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/tasks")
public class TaskRestController {
    private TaskService taskService;
    private MessageView messageView;

    /**
     * Adding a new task
     *
     * @param task Task from request
     * @return New task
     */
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        taskService.addTask(task);
        // Getting list of all tasks
        List<Task> tasksList = taskService.getAllTask();
        // Getting last task in list
        Task addTask = tasksList.get(tasksList.size() - 1);
        // Displaying a message about the operation being completed
        messageView.displayInfo(">> New task /" + addTask.getDescription() + "/ has been added.");
        return task;
    }

    /**
     * The operation of getting a list of all tasks
     *
     * @return List of all task
     */
    @GetMapping
    public List<Task> getAllTasks() {
        // Displaying a message about the operation being completed
        messageView.displayInfo(">> All tasks has been gets.");
        return taskService.getAllTask();
    }

    /**
     * The operation of getting a list of tasks by status
     *
     * @param status Task status - filtration criterion
     * @return List of filtered tasks
     */
    @GetMapping("/status/{status}")
    public List<Task> getTaskByStatus(@PathVariable TaskStatus status) {
        // Displaying a message about the operation being completed
        messageView.displayInfo(">> Tasks by status /" + status.getStatus() + "/ has been gets.");
        return taskService.getTasksByStatus(status);
    }

    /**
     * Update task status operation
     *
     * @param id   Task ID
     * @param task Task from request
     * @return Task with updated status
     */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        Task updateTask = taskService.updateTaskStatus(id, task);
        // Displaying a message about the operation being completed
        messageView.displayInfo(">> Status of task /" + updateTask.getDescription() + "/ has been update.");
        return updateTask;
    }

    /**
     * Delete task operation
     *
     * @param id Task ID
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        Task requreTask = taskService.getTaskById(id);
        taskService.deleteTaskById(id);
        // Displaying a message about the operation being completed
        messageView.displayInfo(">> The task /" + requreTask.getDescription() + "/ has been delete.");
    }

}
