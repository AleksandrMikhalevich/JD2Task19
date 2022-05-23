package mappers;

import DTO.StudentDTO;
import courses.entity.Course;
import courses.entity.Student;
import courses.entity.Task;
import managment.implementation.UtilsForTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

import static managment.implementation.ConstantsForTest.STUDENT_NAME;
import static managment.implementation.ConstantsForTest.STUDENT_SURNAME;

/**
 * @author Alex Mikhalevich
 * @created 2022-05-21 21:05
 */
public class StudentMapperTest {

    @Test
    public void testMappingStudentToStudentDTO() {

        Course course = UtilsForTest.getCourse1();
        Task task = UtilsForTest.getTask();
        Student student = Student.builder()
                .name(STUDENT_NAME)
                .surname(STUDENT_SURNAME)
                .courses(Set.of(course))
                .tasks(Set.of(task))
                .build();
        StudentDTO studentDTO = StudentMapper.INSTANCE.mapStudentToDTO(student);
        Assert.assertNotNull(studentDTO);
        Assert.assertEquals(studentDTO.getName(), student.getName());
        Assert.assertEquals(studentDTO.getSurname(), student.getSurname());
        Assert.assertEquals(studentDTO.getCourses(), student.getCourses());
        Assert.assertEquals(studentDTO.getTasks(), student.getTasks());
    }

}