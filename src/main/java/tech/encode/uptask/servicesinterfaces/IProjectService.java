package tech.encode.uptask.servicesinterfaces;

import tech.encode.uptask.entities.Project;

import java.util.List;

public interface IProjectService {
    public List<Project> getAllProjects();

    public void addProject(Project project);

    public Project getProjectById(Long id);

    public void updateProject(Project project);

    public void deleteProject(Long id);
}
