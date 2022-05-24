<%@ page import="courses.entity.Task" %>
<%@ page import="DTO.StudentDTO" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: akyna
  Date: 14.05.2022
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Информация о заданиях</title>
</head>
<body>
<%@include file="header.jsp" %>
<center>
    <% StudentDTO student = (StudentDTO) request.getAttribute("studentTasks");%>
    <h2>Студент <%=student.getName()%> <%=student.getSurname()%>
    </h2>
    <h2>Просмотр заданий</h2>
    <table border="3">

        <caption><b>Список заданий</b></caption>
        <tr>
            <th>Описание</th>
            <th>Ревью</th>
            <th>Отметка о выполнении</th>
            <th>Курс</th>
            <th>Оценка</th>
        </tr>

        <% Set<Task> taskSet = student.getTasks();
            for (Task task : taskSet) {
        %>
        <tr>
            <td><%= task.getDescription()%>
            </td>
            <td><%= task.getReview()%>
            </td>
            <td><%= task.getStatus()%>
            </td>
            <td><%= task.getCourse().getDescription()%>
            </td>
            <td><%= task.getMark()%>
            </td>
        </tr>
        <%
            }
        %>
    </table>

    <a class="gradient-button1" href="student">Назад</a>

</center>
</body>
</html>
