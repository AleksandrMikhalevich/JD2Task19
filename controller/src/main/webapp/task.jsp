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
<body>
<%@include file="header.jsp" %>
<center>
    <table border="3">
        <caption><b>Список заданий на курсах</b></caption>
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
                                        href="task-form.jsp?idTask=<%=task.getId()%>&description=<%=task.getDescription()%>&status=<%=task.getStatus()%>
                                        &review=<%=task.getReview()%>&mark=<%=task.getMark()%>
                                        &idCourse=<%=tasks.getId()%>&descriptionCourse=<%=tasks.getDescription()%>&action=update"
                                >Редактировать</a></button>
                            </form>
                        </td>
                        <td>
                            <form name="delete" method="post" action="task-form.jsp">
                                <input name="idTask" type="hidden" value="<%=task.getId()%>">
                                <button class="gradient-button"><a
                                        href="task-form.jsp?idTask=<%=task.getId()%>&description=<%=task.getDescription()%>&descriptionCourse=<%=tasks.getDescription()%>&action=delete"
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

    <a class="gradient-button1" href="teacher">Назад</a>

</center>

</body>
</html>
