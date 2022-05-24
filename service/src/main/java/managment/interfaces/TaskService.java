package managment.interfaces;

import DTO.StudentDTO;
import courses.entity.Course;
import courses.entity.Mark;
import courses.entity.Task;

public interface TaskService {

    Task addTask(String description, Course course);

    void updateTask(int idTask, Course course, String description, String status, String review, String mark);

    void deleteTaskById(int id);

    Task findTaskById(int id);

    void assignToCourse(Task task, Course course);

    void cancelAssignmentToCourse(Task task, Course course);

    void assignToStudent(Task task, StudentDTO student);

    void cancelAssignmentToStudent(Task task, StudentDTO student);

}
