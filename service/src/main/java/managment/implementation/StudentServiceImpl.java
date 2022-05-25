package managment.implementation;

import DTO.StudentDTO;
import courses.dao.EntityDaoImplAdmin;
import courses.dao.EntityDaoImplCourse;
import courses.dao.EntityDaoImplStudent;
import courses.dao.EntityDaoImplTask;
import courses.entity.Course;
import courses.entity.Student;
import courses.entity.Task;
import managment.interfaces.StudentService;
import mappers.StudentMapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Alex Mikhalevich
 * @version 1.0
 * @created 2022-04-27 12:39
 */
public class StudentServiceImpl implements StudentService {

    private final EntityDaoImplStudent studentDao = new EntityDaoImplStudent();
    private final EntityDaoImplTask daoImplTask = new EntityDaoImplTask();

    @Override
    public StudentDTO registerStudent(String name, String surname) {
        Student student = Student.builder()
                .name(name)
                .surname(surname)
                .build();
        studentDao.insert(student);
        return StudentMapper.INSTANCE.mapStudentToDTO(student);
    }

    @Override
    public void updateStudent(int id, String name, String surname) {
        Student student = studentDao.getEntity(id);
        Student updateStudent = Student.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .courses(student.getCourses())
                .build();
        studentDao.update(updateStudent);
    }

    @Override
    public void deleteStudentById(int id) {
        studentDao.deleteById(id);
    }

    @Override
    public List<StudentDTO> findAllStudents() {
        List<Student> studentList = studentDao.findAllStudents();
        return studentList.stream()
                .map(Student -> StudentDTO.builder()
                        .id(Student.getId())
                        .name(Student.getName())
                        .surname(Student.getSurname())
                        .courses(Student.getCourses())
                        .tasks(Student.getTasks())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO findStudentById(int id) {
        Student student = studentDao.getEntity(id);
        return StudentMapper.INSTANCE.mapStudentToDTO(student);
    }

    @Override
    public void enrollStudentInCourse(StudentDTO studentDTO, Course course) {
        studentDTO.getCourses().add(course);
        studentDTO.getTasks().addAll(course.getTasks());
        Student student = Student.builder()
                .id(studentDTO.getId())
                .name(studentDTO.getName())
                .surname(studentDTO.getSurname())
                .courses(studentDTO.getCourses())
                .tasks(studentDTO.getTasks())
                .build();
        studentDao.update(student);

    }

    @Override
    public void cancelStudentEnrollment(StudentDTO studentDTO, Course course) {
        studentDTO.getCourses().remove(course);
        studentDTO.getTasks().removeAll(course.getTasks());
        Student student = Student.builder()
                .id(studentDTO.getId())
                .name(studentDTO.getName())
                .surname(studentDTO.getSurname())
                .courses(studentDTO.getCourses())
                .tasks(studentDTO.getTasks())
                .build();
        studentDao.update(student);
    }
}
