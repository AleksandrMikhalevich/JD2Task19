package mappers;

import DTO.StudentDTO;
import courses.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Alex Mikhalevich
 * @created 2022-05-21 17:35
 */
@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "courses", target = "courses")
    @Mapping(source = "tasks", target = "tasks")
    StudentDTO mapStudentToDTO(Student student);

}
