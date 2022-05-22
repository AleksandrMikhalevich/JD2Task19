<%@ page import="courses.entity.Task" %>
<%@ page import="managment.implementation.StudentServiceImpl" %>
<%@ page import="java.util.Objects" %>
<%@ page import="DTO.StudentDTO" %>
<%@ page import="courses.entity.Course" %>
<%@ page import="DTO.TaskDTO" %>
<%@ page import="java.util.List" %>
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
<link href="css/button-small.css" rel="stylesheet">
<link href="css/button.css" rel="stylesheet">
<style>

    h2 {
        font-size: xxx-large;
        font-family: Arial;
    }

    caption {
        font-family: Arial;
        font-size: xx-large;
    }

    td {
        font-size: xx-large;
        font-family: Arial;
    }

    tr {
        font-size: xx-large;
        font-family: Arial;
    }

    body {
        background: linear-gradient(to top left, powderblue, cornflowerblue);
        color: darkblue;
        background-size: cover;
    }

    table {
        border: darkblue;

    }

</style>

<body>
<center>
    <% StudentDTO student = (StudentDTO) request.getAttribute("studentTasks");%>
    <h2>Студент <%=student.getName()%> <%=student.getSurname()%></h2>
    <h2>Просмотр заданий</h2>
    <table border="3" width="50%">

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
    <a class="gradient-button1" href="index.jsp">Главная страница</a>

    <a class="gradient-button1" href="student">Назад</a>

</center>
</body>
</html>
