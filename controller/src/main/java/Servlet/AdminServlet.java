package Servlet;

import DTO.CourseAdminDTO;
import courses.dao.EntityDaoImplAdmin;
import courses.entity.Course;
import courses.entity.Teacher;
import managment.implementation.AdminServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static constants.Const.*;

@WebServlet(name = "AdminServlet", value = "/admin")
public class AdminServlet extends HttpServlet {

    private final AdminServiceImpl adminService = new AdminServiceImpl(new EntityDaoImplAdmin());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CourseAdminDTO> listOfCourses = adminService.listOfAllCourses();
        req.setAttribute(LIST_OF_COURSES, listOfCourses);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(ADMIN_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Teacher> teacherList = adminService.showAllTeachers();
        req.setAttribute(LIST_TEACHERS, teacherList);
        String action = req.getParameter(ACTION);
        switch (action) {
            case "enroll":
                enrollCourse(req, resp);
                break;
            case "teacherToEnroll":
                chooseTeacherToEnroll(req, resp);
                break;
            case "cancelToEnroll":
                cancelTeacherEnroll(req, resp);
                break;
            default:
                resp.sendRedirect(ADMIN_SERVLET);
        }
    }

    private void enrollCourse(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int idCourse = Integer.parseInt(req.getParameter(ID_COURSE));
        Course course = adminService.findCourse(idCourse);
        RequestDispatcher dispatcher = req.getRequestDispatcher("teacherToEnroll.jsp");
        req.setAttribute("courseEnroll", course);
        dispatcher.forward(req, resp);
    }

    private void chooseTeacherToEnroll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idCourse = Integer.parseInt(req.getParameter(ID_COURSE));
        int idTeacher = Integer.parseInt(req.getParameter(ID_TEACHER));
        adminService.enrollTeacher(idTeacher, idCourse);
        resp.sendRedirect(ADMIN_SERVLET);
    }

    private void cancelTeacherEnroll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idCourse = Integer.parseInt(req.getParameter(ID_COURSE));
        int idTeacher = Integer.parseInt(req.getParameter(ID_TEACHER));
        adminService.cancelEnrollTeacher(idTeacher, idCourse);
        resp.sendRedirect(ADMIN_SERVLET);
    }
}
