<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: akyna
  Date: 14.05.2022
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Учитель</title>
    <link href="css/button-small.css" rel="stylesheet">
    <link href="css/button.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/top.css" rel="stylesheet">
<body>
<div class="topnav">

    <a class="active" href="index.jsp">Главная страница</a>

    <a href="admin">Сервис администратора</a>

    <a href="student">Сервис студентов</a>


    <a href="teacher">Сервис учителей</a>
</div>


<a class="gradient-button1" href="teacher">Список Учителей</a>
<br><br>
<% if (request.getParameter("idTeacher") == null) { %>
<h2>Добавление учителя</h2>
<form name="add" method="post" action="teacher" autocomplete="off">
    <div class="main">
        <div class="field">
            <label for="n">Имя:</label>
            <input name="name" type="text" id="n" required placeholder="Имя">
        </div>
        <div class="field">
            <label for="ln">Фамилия:</label>
            <input name="surname" type="text" id="ln" required placeholder="Фамилия">
            <input name="action" type="hidden" value="add">
        </div>
        <button class="gradient-button1">Сохранить</button>

    </div>
</form>
<% } else if (Objects.equals(request.getParameter("action"), "update")) {%>
<h2>Редактирование данных учителя</h2>
<form name="toUpdate" method="post" action="teacher" autocomplete="off">
    <input name="idTeacher" type="hidden" value="<%=Integer.parseInt(request.getParameter("idTeacher"))%>">
    <div class="main">
        <div class="field">
            <label for="n1">Имя:</label>
            <input name="name" type="text" id="n1" value="<%=request.getParameter("name")%>">
        </div>
        <div class="field">
            <label for="ln1">Фамилия:</label>
            <input name="surname" type="text" id="ln1" value="<%=request.getParameter("surname")%>">
            <input name="action" type="hidden" value="update">
        </div>
        <button class="gradient-button1">Сохранить</button>
    </div>
</form>
<% }
    if (Objects.equals(request.getParameter("action"), "delete")) {%>
<h2>Удаление учителя</h2>
<form name="toDelete" method="post" action="teacher" autocomplete="off">
    <input name="idTeacher" type="hidden" value="<%=Integer.parseInt(request.getParameter("idTeacher"))%>">
    <div class="main">
        <div class="field">
            <label for="n1">Имя:</label>
            <input name="name" type="text" id="n2" value="<%=request.getParameter("name")%>">
        </div>
        <div class="field">
            <label for="ln1">Фамилия:</label>
            <input name="surname" type="text" id="ln2" value="<%=request.getParameter("surname")%>">
            <input name="action" type="hidden" value="delete">
        </div>
        <button class="gradient-button1">Удалить</button>
    </div>
</form>
<% } %>
</body>
</html>
