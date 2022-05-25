<%@ page import="java.util.List" %>
<%@ page import="courses.entity.Teacher" %>
<%@ page import="courses.entity.Course" %><%--
  Created by IntelliJ IDEA.
  User: akyna
  Date: 19.05.2022
  Time: 00:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Управление учителями</title>
</head>
<body>
<%@include file="header.jsp" %>
<center>
    <h2>Сервис Администратора</h2>
    <table border="3">

        <caption><b>Список учителей</b></caption>
        <tr>
            <th>Название</th>
            <th>Часы</th>
            <th>Действия</th>
        </tr>

        <% List<Teacher> teacherList = (List<Teacher>) request.getAttribute("listTeachers");
            for (Teacher teacher : teacherList) {
        %>
        <tr>
            <td><%= teacher.getName()%>
            </td>
            <td><%= teacher.getSurname()%>
            </td>
            <td><% Course course = (Course) request.getAttribute("courseEnroll");%>
                <form name="toEnroll" method="post" action="admin">
                    <input name="idCourse" type="hidden" value="<%=course.getId()%>">
                    <input name="idTeacher" type="hidden" value="<%=teacher.getId()%>">
                    <input name="action" type="hidden" value="teacherToEnroll">
                    <button class="gradient-button">Выбрать</button>
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>

    <a class="gradient-button1" href="admin">Назад</a>

</center>
</body>
</html>
