<%@ page import="DTO.TaskStudentDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="DTO.CourseTaskDTO" %>
<%@ page import="courses.entity.Task" %>
<%@ page import="java.util.Set" %><%--
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
    <a class="gradient-button1" href="index.jsp">Главная Страница</a>
    <table border="3" width="50%">
        <caption><b>Список заданий</b></caption>
        <tr>
            <th>№</th>
            <th>Курс</th>
            <th>Описание</th>
            <th>Действия</th>
        </tr>
        <%
            List<CourseTaskDTO> courseAndTasks = (List<CourseTaskDTO>) request.getAttribute("listOfCourseAndTasks");
            int i = 1;
            for (CourseTaskDTO tasks : courseAndTasks) { %>
        <tr>
            <td>
                <%= i++%>
            </td>
            <td>
                <%= tasks.getDescription()%>
            </td>
            <td>
                <table>
                    <% Set<Task> listOfTask = tasks.getListOfTask();
                        for (Task task : listOfTask) {
                    %>
                    <tr>
                        <td>
                            <%= task.getDescription()%>
                        </td>
                        <td>
                            <form name="edit" method="post" action="task-form.jsp">
                                <input name="idTask" type="hidden" value="<%=task.getId()%>">
                                <button class="gradient-button"><a
                                        href="task-form.jsp?idTask=<%=task.getId()%>&descriptionCourse=<%=tasks.getDescription()%>&description=<%=task.getDescription()%>&action=update"
                                >Редактировать</a></button>
                            </form>
                        </td>
                        <td>
                            <form name="delete" method="post" action="task-form.jsp">
                                <input name="idTask" type="hidden" value="<%=task.getId()%>">
                                <button class="gradient-button"><a
                                        href="task-form.jsp?idTask=<%=task.getId()%>&descriptionCourse=<%=tasks.getDescription()%>&description=<%=task.getDescription()%>&action=delete"
                                >Удалить</a></button>
                            </form>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </table>
            </td>
            <td>
                <form name="enroll" method="post" action="task-form.jsp">
                    <input name="idCourse" type="hidden" value="<%=tasks.getId()%>">
                    <button class="gradient-button"><a
                            href="task-form.jsp?idCourse=<%=tasks.getId()%>&description=<%=tasks.getDescription()%>&action=add"
                    >Добавить</a></button>
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</center>

</center>


</body>
</html>
