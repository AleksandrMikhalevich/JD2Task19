package managment.interfaces;

import DTO.CourseAdminDTO;
import courses.entity.Course;
import courses.entity.Teacher;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface AdminService {

    Course createCourse(String desc, String hours);

    void deleteCourse(int id)
            throws InvocationTargetException,
            NoSuchMethodException, IllegalAccessException;

    void updateCourse(Integer id, String desc, String hours);

    List<Course> showAllCourses();

    Course findCourse(int id);

    List<CourseAdminDTO> listOfAllCourses();

    Teacher createTeacher(String surname, String name);

    void deleteTeacher(int id);

    void updateTeacher(Integer id, String surname, String name);

    List<Teacher> showAllTeachers();

    Teacher findTeacher(int id);

    void cancelEnrollTeacher(Integer teacherId, Integer courseId);

    void enrollTeacher(Integer teacherId, Integer courseId);

    List<Teacher> showTeachersForCourse(Integer courseId);
}
