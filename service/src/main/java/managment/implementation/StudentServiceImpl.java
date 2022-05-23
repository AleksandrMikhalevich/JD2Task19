package managment.implementation;

import DTO.StudentDTO;
import courses.dao.EntityDaoImplAdmin;
import courses.dao.EntityDaoImplCourse;
import courses.dao.EntityDaoImplStudent;
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
    private final EntityDaoImplCourse courseDao = new EntityDaoImplCourse();

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
        Student student = Student.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .build();
        studentDao.update(student);
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
    public void enrollStudentInCourse(StudentDTO studentDTO, Integer idCourse) {
        Course course = courseDao.getEntity(idCourse);
        Set<Course> listOfCourse = studentDTO.getCourses();
        listOfCourse.add(course);
        Set<Task> listOfTask = course.getTasks();
        listOfTask.addAll(studentDTO.getTasks());
        Student student = Student.builder()
                .id(studentDTO.getId())
                .name(studentDTO.getName())
                .surname(studentDTO.getSurname())
                .courses(listOfCourse)
                .tasks(listOfTask)
                .build();
        studentDao.update(student);
    }

    @Override
    public void cancelStudentEnrollment(Integer idStudent, Integer idCourse) {
        Student student = studentDao.getEntity(idStudent);
        Course course = courseDao.getEntity(idCourse);
        Set<Course> listOfCourse = student.getCourses();
        listOfCourse.remove(course);
        Set<Task> listOfTask = course.getTasks();
        listOfTask.removeAll(student.getTasks());
        student.setTasks(listOfTask);
        student.setCourses(listOfCourse);
        studentDao.update(student);
    }
}
