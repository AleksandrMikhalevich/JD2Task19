<%@ page import="courses.entity.Teacher" %>
<%@ page import="java.util.List" %>
<%@ page import="DTO.TeacherDTO" %><%--
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
<link href="css/top.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/table.css" rel="stylesheet">
<body>
<style>
    a:link {
        text-decoration: none;
    }
</style>
<center>
    <div class="topnav">
        <a class="active" href="index.jsp">Главная страница</a>


        <a href="admin">Сервис администратора</a>


        <a href="student">Сервис студентов</a>


        <a href="teacher">Сервис учителей</a>
    </div>
    <h2>Сервис учителей</h2>
    <table border="3">

        <caption><b>Список учителей</b></caption>
        <tr>
            <th>№</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th colspan="2">Действия</th>
        </tr>
        <%

            List<TeacherDTO> teacherList = (List<TeacherDTO>) request.getAttribute("teachers");
            for (TeacherDTO teacher : teacherList
            ) {
        %>
        <tr>
            <td><%=teacher.getTeacherName()%>

            </td>
            <td><%=teacher.getTeacherSurname()%>
            </td>
            <td>

                <form name="delete" method="post" action="teacher">
                    <input name="id" type="hidden" value="<%=teacher.getId()%>">
                    <button class="gradient-button"><a
                            href="teacher-form.jsp?id=<%=teacher.getId()%>&surname=<%=teacher.getTeacherSurname()%>&name=<%=teacher.getTeacherName()%>&action=delete"
                    >Удалить</a></button>
                </form>


                <form name="edit" method="post" action="teacher">
                    <input name="idTeacher" type="hidden" value="<%=teacher.getId()%>">
                    <button class="gradient-button"><a

                            href="teacher-form.jsp?id=<%=teacher.getId()%>&surname=<%=teacher.getTeacherSurname()%>&name=<%=teacher.getTeacherName()%>&action=update"

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


                <form name="info" method="post" action="teacher">
                    <input name="id" type="hidden" value="<%=teacher.getId()%>">
                    <button class="gradient-button"><a
                            href="teacherInfo.jsp?id=<%=teacher.getId()%>&surname=<%=teacher.getTeacherSurname()%>
                            &name=<%=teacher.getTeacherName()%>&course=<%=teacher.getCourseName()%>">
                        Инфо учителя</a></button>
                </form>
            </td>

        </tr>
        <%
            }
        %>
    </table>

    <a class="gradient-button1" href="teacher-form.jsp">Добавить учителя</a>

</center>
</body>
</html>
