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

<body>
<%@include file="header.jsp" %>
<center>
    <h2>Задания</h2>
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
    <h2>Редактирование задание <%=request.getParameter("description")%></h2>
    <form name="toUpdate" method="post" action="task">
        <input name="idTask" type="hidden" value="<%=Integer.parseInt(request.getParameter("idTask"))%>">
        <input name="idCourse" type="hidden" value="<%=Integer.parseInt(request.getParameter("idCourse"))%>">
        <div class="main">
            <div class="field">
                <label for="n1">Название Курса:</label>
                <input name="description" type="text" id="n1" disabled value="<%=request.getParameter("descriptionCourse")%>">
            </div>
            <div class="field">
                <label for="nn1">Название задания:</label>
                <input name="description" type="text" id="nn1" value="<%=request.getParameter("description")%>">
            </div>
            <div class="field">
                <label>Статус выполнения:</label>
                <label>
                    <input name="status" type="text" value="<%=request.getParameter("status")%>">
                </label>
            </div>
            <div class="field">
                <label>Ревью:</label>
                <label>
                    <input name="review" type="text" value="<%=request.getParameter("review")%>">
                </label>
            </div>
            <div class="field">
                <label>Оценка:</label>
                <label>
                    <input name="mark" type="text" value="<%=request.getParameter("mark")%>">
                </label>
            </div>
                <input name="action" type="hidden" value="update">
            <button class="gradient-button1">Сохранить</button>
        </div>
    </form>
    <% }
        if (Objects.equals(request.getParameter("action"), "delete")) {%>
    <h2>Удаление задания <%=request.getParameter("description")%></h2>
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


    <a class="gradient-button1" href="task">Назад</a>

</center>

</body>
</html>

