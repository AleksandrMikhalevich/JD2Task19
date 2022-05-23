package managment.implementation;

import DTO.StudentDTO;
import courses.entity.Course;
import courses.entity.Student;
import managment.interfaces.StudentService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static managment.implementation.ConstantsForTest.*;

/**
 * @author Alex Mikhalevich
 * @created 2022-05-21 19:58
 */
public class StudentServiceImplTest {

    @Test
    public void testRegisterStudent() {
        StudentService studentService = new StudentServiceImpl();
        StudentDTO student = studentService.registerStudent(STUDENT_NAME, STUDENT_SURNAME);
        StudentDTO studentFromDB = studentService.findStudentById(student.getId());
        Assert.assertEquals(student, studentFromDB);
    }

    @Test
    public void testUpdateStudent() {
        StudentService studentService = new StudentServiceImpl();
        StudentDTO student = studentService.registerStudent(STUDENT_NAME, STUDENT_SURNAME);
        studentService.updateStudent(student.getId(), STUDENT_NAME, STUDENT_UPDATE_SURNAME);
        StudentDTO studentFromDB = studentService.findStudentById(student.getId());
        Assert.assertNotEquals(student, studentFromDB);
    }

    @Test
    public void testDeleteStudentById() {
        StudentService studentService = new StudentServiceImpl();
        StudentDTO student = studentService.registerStudent(STUDENT_NAME, STUDENT_SURNAME);
        studentService.deleteStudentById(student.getId());
        StudentDTO studentFromDB = studentService.findStudentById(student.getId());
        Assert.assertNull(studentFromDB);
    }

    @Test
    public void testFindAllStudents() {
        StudentService studentService = new StudentServiceImpl();
        StudentDTO student1 = studentService.registerStudent(STUDENT_NAME, STUDENT_SURNAME);
        StudentDTO student2 = studentService.registerStudent(STUDENT_NAME, STUDENT_UPDATE_SURNAME);
        List<StudentDTO> studentList = studentService.findAllStudents();
        Assert.assertTrue(studentList.contains(student1));
        Assert.assertTrue(studentList.contains(student2));
    }

    @Test
    public void testFindStudentById() {
        StudentService studentService = new StudentServiceImpl();
        StudentDTO student = studentService.registerStudent(STUDENT_NAME, STUDENT_SURNAME);
        StudentDTO studentFromDB = studentService.findStudentById(student.getId());
        Assert.assertEquals(student, studentFromDB);
    }

    @Test
    public void testEnrollStudentInCourse() {
        StudentService studentService = new StudentServiceImpl();
        StudentDTO student = studentService.registerStudent(STUDENT_NAME, STUDENT_SURNAME);
        Course course = UtilsForTest.getCourse2();
        studentService.enrollStudentInCourse(student, course);
        StudentDTO studentFromDB = studentService.findStudentById(student.getId());
        Assert.assertTrue(studentFromDB.getCourses().contains(course));
    }

    @Test
    public void testCancelStudentEnrollment() {
        StudentService studentService = new StudentServiceImpl();
        StudentDTO student = studentService.registerStudent(STUDENT_NAME, STUDENT_SURNAME);
        Course course = UtilsForTest.getCourse2();
        studentService.enrollStudentInCourse(student, course);
        StudentDTO studentFromDB = studentService.findStudentById(student.getId());
        Assert.assertTrue(studentFromDB.getCourses().contains(course));
        studentService.cancelStudentEnrollment(student, course);
        StudentDTO studentFromDB2 = studentService.findStudentById(student.getId());
        Assert.assertFalse(studentFromDB2.getCourses().contains(course));
    }
}