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

        .field {
            clear: both;
            text-align: right;
            line-height: 25px;
        }

        label {
            float: left;
            padding-right: 10px;
        }

        .main {
            float: left;
            padding-left: 750px
        }
    </style>
<body>
<div style="text-align: center;"/>
<h2>Управление учителями</h2>
<a class="gradient-button1" href="index.jsp">Главная страница</a>

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
