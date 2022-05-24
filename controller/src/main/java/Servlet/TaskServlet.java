package Servlet;

import DTO.CourseTaskDTO;
import courses.dao.EntityDaoImplAdmin;
import courses.dao.EntityDaoImplTeacher;
import courses.entity.Course;
import managment.implementation.AdminServiceImpl;
import managment.implementation.TaskServiceImpl;
import managment.implementation.TeacherServiceImpl;
import managment.interfaces.AdminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static constants.Const.*;

@WebServlet(name = "TaskServlet", value = "/task")
public class TaskServlet extends HttpServlet {

    private final TeacherServiceImpl teacherService = new TeacherServiceImpl(new EntityDaoImplTeacher());
    private final TaskServiceImpl taskService = new TaskServiceImpl();
    private final AdminService adminService = new AdminServiceImpl(new EntityDaoImplAdmin());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CourseTaskDTO> taskDTOS = teacherService.listOfCourseAndTasks();
        req.setAttribute("listOfCourseAndTasks", taskDTOS);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/task.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getParameter(ACTION);
        switch (action) {
            case "add":
                saveTask(req, resp);
                break;
            case "delete":
                deleteTask(req, resp);
                break;
            case "update":
                updateTask(req, resp);
                break;
            default:
                resp.sendRedirect(TASK_SERVLET);
        }
    }


    private void updateTask(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idTask = Integer.parseInt(req.getParameter(ID_TASK));
        String description = req.getParameter(DESCRIPTION_OF_TASK);
        int idCourse = Integer.parseInt(req.getParameter(ID_COURSE));
        Course course = adminService.findCourse(idCourse);
        String status = req.getParameter(TASK_STATUS);
        String review = req.getParameter(TASK_REVIEW);
        String mark = req.getParameter(TASK_MARK);
        taskService.updateTask(idTask, course, description, status, review, mark);
        resp.sendRedirect(TASK_SERVLET);
    }


    private void deleteTask(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter(ID_TASK));
        taskService.deleteTaskById(id);
        resp.sendRedirect(TASK_SERVLET);
    }

    private void saveTask(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idCourse = Integer.parseInt(req.getParameter(ID_COURSE));
        Course course = adminService.findCourse(idCourse);
        String description = req.getParameter(DESCRIPTION_OF_TASK);
        taskService.addTask(description, course);
        resp.sendRedirect(TASK_SERVLET);
    }
}
