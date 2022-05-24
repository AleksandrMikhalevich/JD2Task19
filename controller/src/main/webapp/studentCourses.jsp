<%@ page import="courses.entity.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="courses.entity.Student" %>
<%@ page import="DTO.StudentDTO" %>
<%@ page import="java.util.Objects" %>
<%@ page import="courses.entity.Task" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: Alex Mikhalevich
  Date: 17.05.2022
  Time: 11:46  
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Страница курсов</title>
<body>
<%@include file="header.jsp" %>
<center>
    <% StudentDTO student = (StudentDTO) request.getAttribute("studentToEnroll");%>

    <h2>Студент <%=student.getName()%> <%=student.getSurname()%></h2>
    <h2>Управление записью на курсы</h2>
    <table border="3">

        <caption><b>Список курсов</b></caption>
        <tr>
            <th>Описание</th>
            <th>Часы</th>
            <th>Действия</th>
        </tr>

        <% List<Course> courseList = (List<Course>) request.getAttribute("courses");
            for (Course course : courseList) {
        %>
        <tr>
            <td><%= course.getDescription()%>
            </td>
            <td><%= course.getHours()%>
            </td>
            <td>
                <form name="toEnroll" method="post" action="student">
                    <% if (!student.getCourses().contains(course)) { %>
                    <input name="id" type="hidden" value="<%=student.getId()%>">
                    <input name="idCourse" type="hidden" value="<%=course.getId()%>">
                    <% Set<Task> taskSet = course.getTasks();
                        for (Task task : taskSet) {
                    %>
                    <input name="idTask" type="hidden" value="<%=task.getId()%>">
                    <% } %>
                    <input name="action" type="hidden" value="coursesToEnroll">
                    <button class="gradient-button">Записаться на курс</button>
                    <% } else { %>
                </form>
                <form name="cancelEnroll" method="post" action="student">
                    <input name="id" type="hidden" value="<%=student.getId()%>">
                    <input name="idCourse" type="hidden" value="<%=course.getId()%>">
                    <input name="action" type="hidden" value="coursesToCancelEnroll">
                    <button class="gradient-button">Отменить запись на курс</button>
                    <% } %>
                </form>
                <% } %>
            </td>
        </tr>
    </table>

    <a class="gradient-button1" href="student">Назад</a>

</center>
</body>
</html>
