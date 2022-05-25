package managment.interfaces;

import DTO.StudentDTO;
import courses.entity.Course;
import courses.entity.Student;
import courses.entity.Task;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @author Alex Mikhalevich
 * @version 1.0
 * @created 2022-04-27 21:57
 */
public interface StudentService {

    StudentDTO registerStudent(String name, String surname);

    void updateStudent(int id, String name, String surname);

    void deleteStudentById(int id);

    List<StudentDTO> findAllStudents();

    StudentDTO findStudentById(int id);

    void enrollStudentInCourse(StudentDTO studentDTO, Course course);

    void cancelStudentEnrollment(StudentDTO studentDTO, Course course);

}
