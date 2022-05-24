<%@ page import="java.util.List" %>
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
<body>
<%@include file="header.jsp" %>
<center>
    <h2>Инфо учителя</h2>
    <table border="3">
        <caption><h3>Информация об учителе</h3></caption>
        <tr>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Курс</th>
        </tr>
        <tr>
            <td><%= request.getParameter("name")%>
            </td>
            <td><%= request.getParameter("surname")%>
            </td>
            <td><%=request.getParameter("course")%>
            </td>
        </tr>
    </table>

    <a class="gradient-button1" href="teacher">Назад</a>

</center>
</body>
</html>
