package Servlet;

import courses.dao.EntityDaoImplAdmin;
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

@WebServlet(name = "TeacherServlet", value = "/teacher")
public class TeacherServlet extends HttpServlet {

    private final AdminServiceImpl adminService = new AdminServiceImpl(new EntityDaoImplAdmin());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Teacher> teacherList = adminService.showAllTeachers();
        req.setAttribute("teacher", teacherList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(TEACHER_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getParameter(ACTION);
        switch (action) {
            case "add":
                saveTeacher(req, resp);
                break;
            case "delete":
                deleteTeacher(req, resp);
                break;
            case "update":
                updateTeacher(req, resp);
                break;
            default:
                resp.sendRedirect(TEACHER_SERVLET);
        }
    }

    private void deleteTeacher(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int idTeacher = Integer.parseInt(req.getParameter(ID_TEACHER));
        adminService.deleteTeacher(idTeacher);
        resp.sendRedirect(TEACHER_SERVLET);
    }

    private void saveTeacher(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String name = req.getParameter(TEACHER_NAME);
        String surname = req.getParameter(TEACHER_SURNAME);
        adminService.createTeacher(name, surname);
        resp.sendRedirect(TEACHER_SERVLET);
    }


    private void updateTeacher(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int idTeacher = Integer.parseInt(req.getParameter(ID_TEACHER));
        String name = req.getParameter(TEACHER_NAME);
        String surname = req.getParameter(TEACHER_SURNAME);
        adminService.updateTeacher(idTeacher, name, surname);
        resp.sendRedirect(TEACHER_SERVLET);
    }
}
