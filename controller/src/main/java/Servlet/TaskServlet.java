package Servlet;

import DTO.CourseTaskDTO;
import DTO.StudentDTO;
import courses.dao.EntityDaoImplAdmin;
import courses.dao.EntityDaoImplTeacher;
import courses.entity.Course;
import courses.entity.Task;
import managment.implementation.AdminServiceImpl;
import managment.implementation.StudentServiceImpl;
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

@WebServlet(name = "TaskServlet", value = "/task")
public class TaskServlet extends HttpServlet {

    public static final String DESCRIPTION = "description";
    public static final String REVIEW = "review";
    public static final String DESCRIPTION_OF_TASK = "description";
    public static final String TASK_SERVLET = "task";

    private final TeacherServiceImpl teacherService = new TeacherServiceImpl(new EntityDaoImplTeacher());
    private final TaskServiceImpl taskService = new TaskServiceImpl();

    private final AdminService adminService = new AdminServiceImpl(new EntityDaoImplAdmin());

    private final StudentServiceImpl studentService = new StudentServiceImpl();

    public static final String ID_TASK = "idTask";

    public static final String ID_COURSE = "idCourse";

    public static final String ID_STUDENT = "idStudent";

    public static final String ACTION = "action";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CourseTaskDTO> taskDTOS = teacherService.listOfCourseAndTasks();
        req.setAttribute("listOfCourseAndTasks", taskDTOS);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/task.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Course> courseList = adminService.showAllCourses();
//        req.setAttribute("courses", courseList);
//        List<StudentDTO> studentList = studentService.findAllStudents();
//        req.setAttribute("students", studentList);
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
            case "assignToCourse":
                assignTaskToCourse(req, resp);
                break;
            case "assignToStudent":
                assignTaskToStudent(req, resp);
                break;
            case "addTaskToCourse":
                addTaskToCourse(req, resp);
                break;
            case "addTaskToStudent":
                addTaskToStudent(req, resp);
                break;
            case "cancelTaskToCourse":
                removeTaskFromCourse(req, resp);
                break;
            case "cancelTaskToStudent":
                removeTaskFromStudent(req, resp);
                break;
            default:
                resp.sendRedirect(TASK_SERVLET);
        }
    }

    private void assignTaskToStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter(ID_TASK));
        Task task = teacherService.getTask(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("tasksToStudent.jsp");
        req.setAttribute("taskToAssign", task);
        dispatcher.forward(req, resp);
    }

    private void addTaskToStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter(ID_TASK));
        Task task = teacherService.getTask(id);
        int idStudent = Integer.parseInt(req.getParameter(ID_STUDENT));
        StudentDTO student = studentService.findStudentById(idStudent);
        taskService.assignToStudent(task, student);
        resp.sendRedirect("teacher");

    }

    private void removeTaskFromStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter(ID_TASK));
        Task task = taskService.findTaskById(id);
        int idStudent = Integer.parseInt(req.getParameter(ID_STUDENT));
        StudentDTO  student = studentService.findStudentById(idStudent);
        taskService.cancelAssignmentToStudent(task, student);
        resp.sendRedirect("teacher");
    }

    private void assignTaskToCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter(ID_TASK));
        Task task = taskService.findTaskById(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("tasksToCourse.jsp");
        req.setAttribute("taskToAssign", task);
        dispatcher.forward(req, resp);
    }

    private void addTaskToCourse(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int id = Integer.parseInt(req.getParameter(ID_TASK));
        Task task = taskService.findTaskById(id);
        int idCourse = Integer.parseInt(req.getParameter(ID_COURSE));
        Course course = adminService.findCourse(idCourse);
        taskService.assignToCourse(task, course);
        resp.sendRedirect("teacher");
    }

    private void removeTaskFromCourse(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter(ID_TASK));
        Task task = taskService.findTaskById(id);
        int idCourse = Integer.parseInt(req.getParameter(ID_COURSE));
        Course course = adminService.findCourse(idCourse);
        taskService.cancelAssignmentToCourse(task, course);
        resp.sendRedirect("teacher");
    }

    private void updateTask(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idTask = Integer.parseInt(req.getParameter(ID_TASK));
        String description = req.getParameter(DESCRIPTION_OF_TASK);
        teacherService.update(idTask, description);
        resp.sendRedirect(TASK_SERVLET);
    }


    private void deleteTask(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter(ID_TASK));
        taskService.deleteById(id);
        resp.sendRedirect(TASK_SERVLET);
    }

    private void saveTask(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer idCourse = Integer.parseInt(req.getParameter(ID_COURSE));
        String description = req.getParameter(DESCRIPTION_OF_TASK);
        teacherService.addTask(idCourse, description);
        resp.sendRedirect(TASK_SERVLET);
    }
}
