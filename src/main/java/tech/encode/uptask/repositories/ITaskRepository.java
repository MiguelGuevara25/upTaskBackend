package tech.encode.uptask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.encode.uptask.entities.Task;

public interface ITaskRepository extends JpaRepository<Task, Long> {
}
