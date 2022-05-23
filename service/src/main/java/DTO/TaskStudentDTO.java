package DTO;

import courses.entity.Course;
import courses.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskStudentDTO {
    private Integer id;
    private String description;
    private Course course;
    private Student student;
    private String review;
    private String done;
    private Integer mark;
}
