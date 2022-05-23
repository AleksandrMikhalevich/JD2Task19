<%@ page import="java.util.List" %>
<%@ page import="DTO.CourseDTO" %>
<%@ page import="java.util.Objects" %>
<%@ page import="DTO.TeacherDTO" %><%--
  Created by IntelliJ IDEA.
  User: Lidia
  Date: 19.05.2022
  Time: 02:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teacher Page</title>
    <link href="css/button-small.css" rel="stylesheet">
    <link href="css/button.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/top.css" rel="stylesheet">
    <link href="css/table.css" rel="stylesheet">
</head>
<body>
<div class="topnav">
    <a class="active" href="index.jsp">Главная страница</a>

    <a href="admin">Сервис администратора</a>

    <a href="student">Сервис студентов</a>

    <a href="teacher">Сервис учителей</a>
</div>
<center>
    <h2>Инфо учителя</h2>
    <table border="3" width="500">
        <caption><h3>Информация об учителе</h3></caption>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Курс</th>

        <tr>
            <td><%= request.getParameter("name")%>
            </td>
            <td><%= request.getParameter("surname")%>
            </td>
            <td><%=request.getParameter("course")%>
            </td>
        </tr>
    </table>
    <form name="back" action="teacher">
        <button class="gradient-button1">Назад</button>
    </form>
</center>
</body>
</html>
