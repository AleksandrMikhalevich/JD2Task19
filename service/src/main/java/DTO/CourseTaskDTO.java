package DTO;


import courses.entity.Student;
import courses.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseTaskDTO {
    private Integer id;
    private String description;
    private Set<Task> listOfTask;
}

