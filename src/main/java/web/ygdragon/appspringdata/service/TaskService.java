package web.ygdragon.appspringdata.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import web.ygdragon.appspringdata.model.Task;
import web.ygdragon.appspringdata.model.TaskStatus;
import web.ygdragon.appspringdata.repository.TaskRepository;

import java.util.List;

@Data
@AllArgsConstructor
@Service
public class TaskService {

    private TaskRepository taskRepository;

    /**
     * Adding a new task to the repository
     *
     * @param task Addable task
     */
    public void addTask(Task task) {
        taskRepository.save(task);
    }

    /**
     * Getting all tasks from the repository
     *
     * @return Status message line
     */
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    /**
     * Get a task form repository by ID
     *
     * @param id Task ID
     * @return Required task
     */
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    /**
     * Filtering and getting tasks by status
     *
     * @param status Task status
     * @return Status message line
     */
    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.getTaskByStatus(status);
    }

    /**
     * Update task status
     *
     * @param id   Task ID
     * @param task Updatable task
     * @return Task with updated status
     */
    public Task updateTaskStatus(Long id, Task task) {
        Task updateTask = getTaskById(id);
        if (updateTask != null) {
            updateTask.setStatus(task.getStatus());
            return taskRepository.save(updateTask);
        }
        return null;
    }

    /**
     * Deleting task by ID
     *
     * @param id ID of deletable task
     */
    public void deleteTaskById(Long id) {
        Task findTask = getTaskById(id);
        taskRepository.delete(findTask);
    }
}
