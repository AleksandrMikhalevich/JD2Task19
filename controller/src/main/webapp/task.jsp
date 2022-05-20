<%@ page import="DTO.TaskDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: akyna
  Date: 19.05.2022
  Time: 03:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Страница заданий</title>
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
    <table border="3" width="50%">
        <caption><b>Список заданий</b></caption>
        <th>Описание</th>
        <th>Ревью</th>
        <th>Курс</th>
        <th>Действия</th>
        <%
            List<TaskDTO> taskList = (List<TaskDTO>) request.getAttribute("tasks");
            for (TaskDTO task : taskList
            ) { %>
        <tr>
            <td><%=task.getDescription()%>
            </td>
            <td><%=task.getReview()%>
            </td>
            <td><%=task.getCourse()%>
            </td>
            <td>
                <form name="assignToCourse" method="post" action="task">
                    <input name="id" type="hidden" value="<%=task.getId()%>">
                    <input name="action" type="hidden" value="assignToCourse">
                    <button class="gradient-button">Добавление/удаление задания на курс</button>
                </form>
                <form name="assignToStudent" method="post" action="task">
                    <input name="id" type="hidden" value="<%=task.getId()%>">
                    <input name="action" type="hidden" value="assignToStudent">
                    <button class="gradient-button">Добавление/удаление задания студенту</button>
                </form>
            </td>
        </tr>
        <%
            }
        %>

    </table>

    <a class="gradient-button1" href="index.jsp">Main Page</a>

    <a class="gradient-button1" href="teacher">Назад</a>

</center>


</body>
</html>
