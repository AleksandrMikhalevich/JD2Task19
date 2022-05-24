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
</head>
<body>
<%@include file="header.jsp" %>
<center>
    <h2> Управление курсами</h2>
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
    <h2>Редактирование курса <%=request.getParameter("description")%></h2>
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
    <h2>Удаление курса <%=request.getParameter("description")%></h2>
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

    <a class="gradient-button1" href="course">Назад</a>

</center>
</body>
</html>
