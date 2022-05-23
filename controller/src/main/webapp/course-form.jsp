<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: akyna
  Date: 14.05.2022
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Курс</title>
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


<div style="text-align: center;">
</div>
<center>
    <h2> Управление курсами</h2>
    <a class="gradient-button1" href="index.jsp">Главная страница</a>

    <a class="gradient-button1" href="course">Список курсов</a>

    <% if (request.getParameter("idCourse") == null) { %>
    <h2>Добавление курса</h2>
    <form name="add" method="post" action="course">
        <div class="main">
            <div class="field">
                <label for="n">Название Курса:</label>
                <input name="description" type="text" id="n" required placeholder="Описание">
            </div>
            <div class="field">
                <label for="ln">Количество Часов:</label>
                <input name="hours" type="text" id="ln" required placeholder="Часы">
                <input name="action" type="hidden" value="add">
            </div>
            <button class="gradient-button1">Сохранить</button>
        </div>
    </form>

    <% } else if (Objects.equals(request.getParameter("action"), "update")) {%>
    <h2>Редактирование данных курса</h2>
    <form name="toUpdate" method="post" action="course">
        <input name="idCourse" type="hidden" value="<%=Integer.parseInt(request.getParameter("idCourse"))%>">
        <div class="main">
            <div class="field">
                <label for="n1">Название Курса:</label>
                <input name="description" type="text" id="n1" value="<%=request.getParameter("description")%>">
            </div>
            <div class="field">
                <label for="ln1">Количество Часов:</label>
                <input name="hours" type="text" id="ln1" value="<%=request.getParameter("hours")%>">
                <input name="action" type="hidden" value="update">
            </div>
            <button class="gradient-button1">Сохранить</button>
        </div>
    </form>
    <% }
        if (Objects.equals(request.getParameter("action"), "delete")) {%>
    <h2>Удаление курса</h2>
    <form name="toDelete" method="post" action="course">
        <input name="idCourse" type="hidden" value="<%=Integer.parseInt(request.getParameter("idCourse"))%>">
        <div class="main">
            <div class="field">
                <label for="n2">Название Курса:</label>
                <input name="description" type="text" id="n2" value="<%=request.getParameter("description")%>">
            </div>
            <div class="field">
                <label for="ln2">Количество Часов:</label>
                <input name="hours" type="text" id="ln2" value="<%=request.getParameter("hours")%>">
                <input name="action" type="hidden" value="delete">
            </div>
            <button class="gradient-button1">Удалить</button>
        </div>
    </form>
    <% } %>
</center>

</body>
</html>
