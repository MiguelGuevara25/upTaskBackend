package tech.encode.uptask.dtos;

import lombok.*;
import tech.encode.uptask.entities.Task;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    private Long id;
    private String projectName;
    private String clientName;
    private String description;
    private List<Task> tasks;
}
