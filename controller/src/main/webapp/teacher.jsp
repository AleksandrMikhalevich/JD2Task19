<%@ page import="courses.entity.Teacher" %>
<%@ page import="java.util.List" %><%--
Created by IntelliJ IDEA.
User: akyna
Date: 17.05.2022
Time: 19:15
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Страница учителей</title>
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
    <h2>Управление учителями</h2>

    <a class="gradient-button1" href="teacher-form.jsp">Добавить учителя</a>

    <a class="gradient-button1" href="index.jsp">Главная страница</a>

    <a class="gradient-button1" href="admin">Страница администратoра</a>
    <br><br>
    <table border="3" width="50%">
        <caption><b>Список учителей</b></caption>
        <tr>
            <th>№</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th colspan="2">Действия</th>
        </tr>
        <%
            List<Teacher> teacherList = (List<Teacher>) request.getAttribute("teacher");
            int i = 1;
            for (Teacher teacher : teacherList
            ) {
        %>
        <tr>
            <td><%= i++ %>
            </td>
            <td><%=teacher.getName()%>
            </td>
            <td><%=teacher.getSurname()%>
            </td>
            <td>
                <form name="edit" method="post" action="teacher">
                    <input name="idTeacher" type="hidden" value="<%=teacher.getId()%>">
                    <button class="gradient-button"><a
                            href="teacher-form.jsp?idTeacher=<%=teacher.getId()%>&surname=<%=teacher.getSurname()%>&name=<%=teacher.getName()%>&action=update"
                    >Редактировать</a></button>
                </form>
            </td>
            <td>
                <form name="delete" method="post" action="teacher">
                    <input name="idTeacher" type="hidden" value="<%=teacher.getId()%>">
                    <button class="gradient-button"><a
                            href="teacher-form.jsp?idTeacher=<%=teacher.getId()%>&surname=<%=teacher.getSurname()%>&name=<%=teacher.getName()%>&action=delete"
                    >Удалить</a></button>
                </form>
            </td>
            <%--                <form name="assignTask" action="task">--%>
            <%--                    <input name="action" type="hidden" value="task.jsp">--%>
            <%--                    <button class="gradient-button">Управление заданиями</button>--%>
            <%--                </form>--%>
        </tr>
        <%
            }
        %>
    </table>
</center>
</body>
</html>
