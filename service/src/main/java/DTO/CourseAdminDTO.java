package DTO;

import courses.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseAdminDTO {
    private Integer id;
    private String description;
    private List<Teacher> listOfTeachers;
}
