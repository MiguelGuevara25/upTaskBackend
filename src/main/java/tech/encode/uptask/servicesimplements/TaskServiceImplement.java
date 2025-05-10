package tech.encode.uptask.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.encode.uptask.entities.Task;
import tech.encode.uptask.repositories.ITaskRepository;
import tech.encode.uptask.servicesinterfaces.ITaskService;

import java.util.List;

@Service
public class TaskServiceImplement implements ITaskService {
    @Autowired
    private ITaskRepository tR;

    @Override
    public List<Task> getAllTasks() {
        return tR.findAll();
    }

    @Override
    public void addTask(Task task) {
        tR.save(task);
    }

    @Override
    public Task getTaskById(Long id) {
        return tR.findById(id).orElse(new Task());
    }

    @Override
    public void updateTask(Task task) {
        tR.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        tR.deleteById(id);
    }
}
