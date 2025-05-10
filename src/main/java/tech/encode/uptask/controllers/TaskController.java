package tech.encode.uptask.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.encode.uptask.dtos.TaskDTO;
import tech.encode.uptask.entities.Task;
import tech.encode.uptask.servicesinterfaces.ITaskService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private ITaskService tS;
    
    @GetMapping
    public List<TaskDTO> getAllTasks() {
        return tS.getAllTasks()
                .stream()
                .map(x -> {
                    ModelMapper m = new ModelMapper();
                    return m.map(x, TaskDTO.class);
                }).collect(Collectors.toList());
    }

    @PostMapping
    public void addTask(@RequestBody TaskDTO taskDTO) {
        ModelMapper m = new ModelMapper();
        Task p = m.map(taskDTO, Task.class);
        tS.addTask(p);
    }

    @GetMapping("/{id}")
    public TaskDTO getTaskById(@PathVariable Long id) {
        ModelMapper m = new ModelMapper();
        return m.map(tS.getTaskById(id), TaskDTO.class);
    }

    @PutMapping()
    public void updateTask(@RequestBody TaskDTO taskDTO) {
        ModelMapper m = new ModelMapper();
        Task p = m.map(taskDTO,Task.class);
        tS.updateTask(p);
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        tS.deleteTask(id);
    }
}
