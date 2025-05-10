package tech.encode.uptask.servicesinterfaces;

import tech.encode.uptask.entities.Task;

import java.util.List;

public interface ITaskService {
    public List<Task> getAllTasks();

    public void addTask(Task task);

    public Task getTaskById(Long id);

    public void updateTask(Task task);

    public void deleteTask(Long id);
}
