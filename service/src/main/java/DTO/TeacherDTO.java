package DTO;

import courses.entity.Course;
import courses.entity.Teacher;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.stream.Collectors;


@ToString
@EqualsAndHashCode
@Getter
@NoArgsConstructor
public class TeacherDTO {
    private int id;
    private String teacherName;
    private String teacherSurname;
    private String courseName;


    public TeacherDTO(Teacher teacher) {
        this.id = teacher.getId();
        this.teacherName = teacher.getName();
        this.teacherSurname = teacher.getSurname();
        this.courseName = teacher.getCourses()
                .stream()
                .map(Course::getDescription)
                .collect(Collectors.joining(","));

    }

}
