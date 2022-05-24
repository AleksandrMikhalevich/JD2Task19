package managment.implementation;

import DTO.StudentDTO;
import DTO.TaskStudentDTO;
import courses.dao.EntityDaoImplTask;
import courses.entity.Course;
import courses.entity.Mark;
import courses.entity.Student;
import courses.entity.Task;
import managment.interfaces.TaskService;

import java.util.ArrayList;
import java.util.List;

public class TaskServiceImpl implements TaskService {
    private final EntityDaoImplTask taskDao = new EntityDaoImplTask();

    @Override
    public Task addTask(String description, Course course) {
        Task task = Task.builder()
                .description(description)
                .course(course)
                .build();
        taskDao.insert(task);
        return task;
    }

    @Override
    public void updateTask(int id, Course course, String description, String status, String review, String mark) {
        Task task = Task.builder()
                .id(id)
                .description(description)
                .course(course)
                .status(status)
                .review(review)
                .mark(mark)
                .build();
        taskDao.update(task);
    }

    @Override
    public void deleteTaskById(int id) {
        taskDao.deleteById(id);
    }

    @Override
    public Task findTaskById(int id) {
        return taskDao.getEntity(id);
    }

    @Override
    public void assignToCourse(Task task, Course course){
        task.setCourse(course);
        taskDao.update(task);
    }

    public void cancelAssignmentToCourse(Task task, Course course){
        task.setCourse(null);
        taskDao.update(task);
    }

    @Override
    public void assignToStudent(Task task, StudentDTO studentDTO){
        Student student = Student.builder()
                .id(studentDTO.getId())
                .name(studentDTO.getName())
                .surname(studentDTO.getSurname())
                .build();
        task.setStudent(student);
        taskDao.update(task);
    }

    public void cancelAssignmentToStudent(Task task, StudentDTO studentDTO){
        Student student = Student.builder()
                .id(studentDTO.getId())
                .name(studentDTO.getName())
                .surname(studentDTO.getSurname())
                .build();
        task.setStudent(null);
        taskDao.update(task);
    }

}
