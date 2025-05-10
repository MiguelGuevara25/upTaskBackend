package tech.encode.uptask.servicesinterfaces;

import tech.encode.uptask.entities.Project;

import java.util.List;

public interface IProjectService {
    public List<Project> getAllProjects();
    public void addProject(Project project);
}
