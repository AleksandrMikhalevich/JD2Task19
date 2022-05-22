package DTO;

import courses.entity.Course;
import courses.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @author Alex Mikhalevich
 * @created 2022-05-21 17:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {

    private int id;

    private String name;

    private String surname;

    private Set<Course> courses;

    private Set<Task> tasks;

}
