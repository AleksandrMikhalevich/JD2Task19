<%@ page import="courses.entity.Course" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: akyna
  Date: 14.05.2022
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Страница курсов</title>
<body>
<%@include file="header.jsp" %>
<center>
    <h2>Управление курсами</h2>
    <table border="3" width="50%">

        <caption><b>Список курсов</b></caption>
        <tr>
            <th>№</th>
            <th>Название</th>
            <th>Часы</th>
            <th colspan="2">Действия</th>
        </tr>

        <% List<Course> courseList = (List<Course>) request.getAttribute("courses");
            int i = 1;
            for (Course course : courseList) {
        %>
        <tr>
            <td>
                <%= i++%>
            </td>
            <td>
                <%= course.getDescription()%>
            </td>
            <td>
                <%= course.getHours()%>
            </td>
            <td>
                <form name="edit" method="post" action="course-form.jsp">
                    <input name="idCourse" type="hidden" value="<%=course.getId()%>">
                    <button class="gradient-button"><a
                            href="course-form.jsp?idCourse=<%=course.getId()%>&description=<%=course.getDescription()%>&hours=<%=course.getHours()%>&action=update"
                    >Редактировать</a></button>
                </form>
                <form name="delete" method="post" action="course-form.jsp">
                    <input name="idCourse" type="hidden" value="<%=course.getId()%>">
                    <button class="gradient-button"><a
                            href="course-form.jsp?idCourse=<%=course.getId()%>&description=<%=course.getDescription()%>&hours=<%=course.getHours()%>&action=delete"
                    >Удалить</a></button>
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <a class="gradient-button1" href="course-form.jsp">Добавить курс</a>

    <a class="gradient-button1" href="admin">Назад</a>

</center>
</body>
</html>
