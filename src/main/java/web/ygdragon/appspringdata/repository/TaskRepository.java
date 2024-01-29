package web.ygdragon.appspringdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.ygdragon.appspringdata.model.Task;
import web.ygdragon.appspringdata.model.TaskStatus;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> getTaskByStatus(TaskStatus status);

}
