package tech.encode.uptask.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.encode.uptask.dtos.ProjectDTO;
import tech.encode.uptask.entities.Project;
import tech.encode.uptask.servicesinterfaces.IProjectService;

import java.net.URI;
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
    public ResponseEntity<String> addProject(@RequestBody ProjectDTO projectDTO) {
        ModelMapper m = new ModelMapper();
        Project p = m.map(projectDTO, Project.class);
        pS.addProject(p);

        String msg = "Application successfully registered";
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
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
    public ResponseEntity<String> deleteProject(@PathVariable Long id) {
        pS.deleteProject(id);

        String msg = "Application successfully deleted";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
