package tech.encode.uptask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.encode.uptask.entities.Project;

public interface IProjectRepository extends JpaRepository<Project, Long> {
}
