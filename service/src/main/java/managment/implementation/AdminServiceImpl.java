package managment.implementation;

import DTO.CourseAdminDTO;
import courses.dao.EntityDaoImplAdmin;
import courses.dao.EntityDaoImplCourse;
import courses.dao.EntityDaoImplTeacher;
import courses.entity.Course;
import courses.entity.Teacher;
import managment.interfaces.AdminService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AdminServiceImpl implements AdminService {

    private final EntityDaoImplAdmin daoImplAdmin;

    private final EntityDaoImplCourse daoImplCourse
            = new EntityDaoImplCourse();

    private final EntityDaoImplTeacher daoImplTeacher
            = new EntityDaoImplTeacher();

    public AdminServiceImpl(EntityDaoImplAdmin daoImplAdmin) {
        this.daoImplAdmin = daoImplAdmin;
    }

    @Override
    public Course createCourse(String desc, String hours) {
        Course course = Course.builder()
                .description(desc)
                .hours(hours)
                .build();
        daoImplCourse.insert(course);
        return course;
    }

    @Override
    public void deleteCourse(int id) {
        daoImplCourse.deleteById(id);
    }

    @Override
    public void updateCourse(Integer id, String desc, String hours) {
        Course course = daoImplCourse.getEntity(id);
        course.setDescription(desc);
        course.setHours(hours);
        daoImplCourse.update(course);
    }

    @Override
    public List<Course> showAllCourses() {
        return daoImplCourse.select();
    }

    public Course findCourse(int id) {
        return daoImplCourse.getEntity(id);
    }

    @Override
    public Teacher createTeacher(String surname, String name) {
        Teacher teacher = Teacher.builder()
                .name(name)
                .surname(surname)
                .build();
        daoImplTeacher.insert(teacher);
        return teacher;
    }

    @Override
    public void deleteTeacher(int id) {
        daoImplTeacher.deleteById(id);
    }

    @Override
    public void updateTeacher(Integer id, String name, String surname) {
        Teacher teacher = daoImplTeacher.getEntity(id);
        teacher.setName(name);
        teacher.setSurname(surname);
        daoImplTeacher.update(teacher);
    }

    @Override
    public List<Teacher> showAllTeachers() {
        return daoImplTeacher.select();
    }

    public Teacher findTeacher(int id) {
        return daoImplTeacher.getEntity(id);
    }

    @Override
    public void enrollTeacher(Integer teacherId, Integer courseId) {
        Course course = daoImplCourse.getEntity(courseId);
        Teacher teacher = daoImplTeacher.getEntity(teacherId);
        Set<Course> courses = teacher.getCourses();
        courses.add(course);
        teacher.setCourses(courses);
        daoImplTeacher.update(teacher);
    }

    @Override
    public void cancelEnrollTeacher(Integer teacherId, Integer courseId) {
        Course course = daoImplCourse.getEntity(courseId);
        Teacher teacher = daoImplTeacher.getEntity(teacherId);
        Set<Course> courses = teacher.getCourses();
        courses.remove(course);
        teacher.setCourses(courses);
        daoImplTeacher.update(teacher);
    }

    @Override
    public List<Teacher> showTeachersForCourse(Integer courseId) {
        return daoImplCourse.showTeachersForCourse(courseId);
    }

    @Override
    public List<CourseAdminDTO> listOfAllCourses() {
        List<Course> courses = daoImplCourse.select();
        return courses.stream().map(course -> CourseAdminDTO.builder()
                        .id(course.getId())
                        .description(course.getDescription())
                        .listOfTeachers(course.getTeachers())
                        .build())
                .collect(Collectors.toList());
    }
}
