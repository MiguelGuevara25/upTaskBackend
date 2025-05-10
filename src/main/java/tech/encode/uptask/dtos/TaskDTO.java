package tech.encode.uptask.dtos;

import lombok.*;
import tech.encode.uptask.entities.Project;
import tech.encode.uptask.enums.TaskStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private Long id;
    private String name;
    private String description;
    private TaskStatus status;
    private Project project;
}
