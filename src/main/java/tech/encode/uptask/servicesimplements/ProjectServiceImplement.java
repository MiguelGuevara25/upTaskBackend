package tech.encode.uptask.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.encode.uptask.entities.Project;
import tech.encode.uptask.repositories.IProjectRepository;
import tech.encode.uptask.servicesinterfaces.IProjectService;

import java.util.List;

@Service
public class ProjectServiceImplement implements IProjectService {
    @Autowired
    private IProjectRepository pR;

    @Override
    public List<Project> getAllProjects() {
        return pR.findAll();
    }

    @Override
    public void addProject(Project project) {
        pR.save(project);
    }

    @Override
    public Project getProjectById(Long id) {
        return pR.findById(id).orElse(new Project());
    }

    @Override
    public void updateProject(Project project) {
        pR.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        pR.deleteById(id);
    }
}
