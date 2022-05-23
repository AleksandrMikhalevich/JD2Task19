package Servlet;

import DTO.StudentDTO;
import courses.dao.EntityDaoImplAdmin;
import courses.entity.Course;
import enums.ActionEnum;
import managment.implementation.AdminServiceImpl;
import managment.implementation.StudentServiceImpl;
import managment.interfaces.AdminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static constants.StudentConstants.*;
import static enums.ActionEnum.ADD;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {

    private final StudentServiceImpl studentService = new StudentServiceImpl();
    private final AdminService adminService = new AdminServiceImpl(new EntityDaoImplAdmin());


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<StudentDTO> studentList = studentService.findAllStudents();
        req.setAttribute("students", studentList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("student.jsp");
        requestDispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Course> courseList = adminService.showAllCourses();
        req.setAttribute("courses", courseList);
        String action = req.getParameter(ACTION);
        switch (action) {
            case "add":
                saveStudent(req, resp);
                break;
            case "delete":
                deleteStudent(req, resp);
                break;
            case "update":
                updateStudent(req, resp);
                break;
            case "enroll":
                enrollStudent(req, resp);
                break;
            case "coursesToEnroll":
                chooseCoursesToEnroll(req, resp);
                break;
            case "coursesToCancelEnroll":
                chooseCoursesToCancelEnrollment(req, resp);
                break;
            case "search":
                searchInTasks(req, resp);
                break;
        }
    }

    private void searchInTasks(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter(ID_STUDENT));
        StudentDTO student = studentService.findStudentById(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("search.jsp");
        req.setAttribute("studentTasks", student);
        dispatcher.forward(req, resp);
    }

    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int id = Integer.parseInt(req.getParameter(ID_STUDENT));
        studentService.deleteStudentById(id);
        resp.sendRedirect("student");
    }

    private void saveStudent(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String name = req.getParameter(NAME);
        String surname = req.getParameter(SURNAME);
        studentService.registerStudent(name, surname);
        resp.sendRedirect("student");
    }

    private void updateStudent(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int id = Integer.parseInt(req.getParameter(ID_STUDENT));
        String name = req.getParameter(NAME);
        String surname = req.getParameter(SURNAME);
        studentService.updateStudent(id, name, surname);
        resp.sendRedirect("student");    }

    private void enrollStudent(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter(ID_STUDENT));
        StudentDTO student = studentService.findStudentById(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("studentCourses.jsp");
        req.setAttribute("studentToEnroll", student);
        dispatcher.forward(req, resp);
    }

    private void chooseCoursesToEnroll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter(ID_STUDENT));
        StudentDTO student = studentService.findStudentById(id);
        int idCourse = Integer.parseInt(req.getParameter(ID_COURSE));
        Course course = adminService.findCourse(idCourse);
        studentService.enrollStudentInCourse(student, course);
        resp.sendRedirect("student");
    }

    private void chooseCoursesToCancelEnrollment(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter(ID_STUDENT));
        StudentDTO student = studentService.findStudentById(id);
        int idCourse = Integer.parseInt(req.getParameter(ID_COURSE));
        Course course = adminService.findCourse(idCourse);
        studentService.cancelStudentEnrollment(student, course);
        resp.sendRedirect("student");
    }

}


