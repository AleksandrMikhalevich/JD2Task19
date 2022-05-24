<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: lidia
  Date: 5/23/22
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
    <h2>Задания</h2>
    <a class="gradient-button1" href="index.jsp">Главная страница</a>

    <a class="gradient-button1" href="task">Задания и Курсы</a>

    <% if (Objects.equals(request.getParameter("action"), "add")) { %>
    <h2>Добавить задание</h2>
    <form name="add" method="post" action="task">
        <input name="idCourse" type="hidden" value="<%=Integer.parseInt(request.getParameter("idCourse"))%>">
        <div class="main">
            <div class="field">
                <label for="n">Название Курса:</label>
                <input name="description" type="text" id="n" disabled value="<%=request.getParameter("description")%>">
            </div>
            <div class="field">
                <label for="nn">Название Задания:</label>
                <input name="description" type="text" id="nn" required placeholder="Описание">
            </div>
            <input name="action" type="hidden" value="add">
            <button class="gradient-button1">Сохранить</button>
        </div>
    </form>

    <% } else if (Objects.equals(request.getParameter("action"), "update")) {%>
    <h2>Редактирование данных курса</h2>
    <form name="toUpdate" method="post" action="task">
        <input name="idTask" type="hidden" value="<%=Integer.parseInt(request.getParameter("idTask"))%>">
        <div class="main">
            <div class="field">
                <label for="n1">Название Курса:</label>
                <input name="description" type="text" id="n1" disabled value="<%=request.getParameter("descriptionCourse")%>">
            </div>
            <div class="field">
                <label for="nn1">Название Задания:</label>
                <input name="description" type="text" id="nn1" value="<%=request.getParameter("description")%>">
            </div>
                <input name="action" type="hidden" value="update">
            <button class="gradient-button1">Сохранить</button>
        </div>
    </form>
    <% }
        if (Objects.equals(request.getParameter("action"), "delete")) {%>
    <h2>Удаление курса</h2>
    <form name="toDelete" method="post" action="task">
        <input name="idTask" type="hidden" value="<%=Integer.parseInt(request.getParameter("idTask"))%>">
        <div class="main">
            <div class="field">
                <label for="n2">Название Курса:</label>
                <input name="description" type="text" id="n2" disabled value="<%=request.getParameter("descriptionCourse")%>">
            </div>
            <div class="field"><label for="nn2">Название Задания:</label>
                <input name="description" type="text" id="nn2" value="<%=request.getParameter("description")%>">
                <input name="action" type="hidden" value="delete">
            </div>
            <button class="gradient-button1">Удалить</button>
        </div>
    </form>
    <% } %>
</center>

</body>
</html>

