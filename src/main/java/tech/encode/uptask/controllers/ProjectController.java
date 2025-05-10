package tech.encode.uptask.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.encode.uptask.dtos.ProjectDTO;
import tech.encode.uptask.entities.Project;
import tech.encode.uptask.servicesinterfaces.IProjectService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private IProjectService pS;

    @GetMapping
    public List<ProjectDTO> getAllProjects() {
        return pS.getAllProjects()
                .stream()
                .map(x -> {
                    ModelMapper m = new ModelMapper();
                    return m.map(x, ProjectDTO.class);
                }).collect(Collectors.toList());
    }

    @PostMapping
    public void addProject(@RequestBody ProjectDTO projectDTO) {
        ModelMapper m = new ModelMapper();
        Project p = m.map(projectDTO, Project.class);
        pS.addProject(p);
    }

    @GetMapping("/{id}")
    public ProjectDTO getProjectById(@PathVariable Long id) {
        ModelMapper m = new ModelMapper();
        return m.map(pS.getProjectById(id), ProjectDTO.class);
    }

    @PutMapping()
    public void updateProject(@RequestBody ProjectDTO projectDTO) {
        ModelMapper m = new ModelMapper();
        Project p = m.map(projectDTO,Project.class);
        pS.updateProject(p);
    }
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        pS.deleteProject(id);
    }
}
