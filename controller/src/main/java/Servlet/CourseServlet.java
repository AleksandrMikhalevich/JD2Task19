package Servlet;

import courses.dao.EntityDaoImplAdmin;
import courses.dao.EntityDaoImplCourse;
import courses.entity.Course;
import managment.implementation.AdminServiceImpl;
import managment.implementation.CourseServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static constants.Const.*;

@WebServlet(name = "CourseServlet", value = "/course")
public class CourseServlet extends HttpServlet {


    private final AdminServiceImpl adminService = new AdminServiceImpl(new EntityDaoImplAdmin());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Course> courseList = adminService.showAllCourses();
        req.setAttribute("courses", courseList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(COURSE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String action = req.getParameter(ACTION);
        switch (action) {
            case "delete":
                deleteCourse(req, resp);
                break;
            case "add":
                saveCourse(req, resp);
                break;
            case "update":
                updateCourse(req, resp);
                break;
            default:
                resp.sendRedirect(COURSE_SERVLET);
        }
    }

    private void deleteCourse(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int idCourse = Integer.parseInt(req.getParameter(ID_COURSE));
        adminService.deleteCourse(idCourse);
        resp.sendRedirect(COURSE_SERVLET);
    }

    private void saveCourse(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String description = req.getParameter(DESCRIPTION);
        String hours = req.getParameter(HOURS);
        adminService.createCourse(description, hours);
        resp.sendRedirect(COURSE_SERVLET);
    }

    private void updateCourse(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        Integer idCourse = Integer.parseInt(req.getParameter(ID_COURSE));
        String description = req.getParameter(DESCRIPTION);
        String hours = req.getParameter(HOURS);
        adminService.updateCourse(idCourse, description, hours);
        resp.sendRedirect(COURSE_SERVLET);
    }
}
