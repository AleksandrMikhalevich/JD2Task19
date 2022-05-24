<%@ page import="java.util.List" %>
<%@ page import="DTO.StudentDTO" %>
<%--
  Created by IntelliJ IDEA.
  User: akyna
  Date: 14.05.2022
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Страница студентов</title>
</head>
<body>
<%@include file="header.jsp" %>
<center>
    <h2>Сервис студентов</h2>
    <table border="3">

        <caption><b>Список Студентов</b></caption>
        <tr>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Профиль</th>
            <th>Курсы</th>
            <th>Задания</th>
        </tr>
        <% List<StudentDTO> studentList = (List<StudentDTO>) request.getAttribute("students");
            for (StudentDTO student : studentList) {
        %>
        <tr>
            <td><%= student.getName()%>
            </td>
            <td><%= student.getSurname()%>
            </td>
            <td>
                <form name="delete" method="post" action="student">
                    <input name="id" type="hidden" value="<%=student.getId()%>">
                    <button class="gradient-button"><a
                            href="student-form.jsp?id=<%=student.getId()%>&surname=<%=student.getSurname()%>&name=<%=student.getName()%>&action=delete"
                    >Удалить</a></button>
                </form>
                <form name="edit" method="post" action="student">
                    <input name="id" type="hidden" value="<%=student.getId()%>">
                    <button class="gradient-button"><a
                            href="student-form.jsp?id=<%=student.getId()%>&surname=<%=student.getSurname()%>&name=<%=student.getName()%>&action=update"
                    >Редактировать</a></button>
                </form>
            </td>
            <td>
                <form name="courses" method="post" action="student">
                    <input name="id" type="hidden" value="<%=student.getId()%>">
                    <input name="action" type="hidden" value="enroll">
                    <button class="gradient-button">Запись/удаление записи на курс</button>
                </form>
            </td>
            <td>
                <form name="tasks" method="post" action="student">
                    <input name="id" type="hidden" value="<%=student.getId()%>">
                    <input name="action" type="hidden" value="search">
                    <button class="gradient-button">Информация о заданиях</button>
                </form>
            </td>
            <%
                }
            %>
        </tr>

    </table>

    <a class="gradient-button1" href="student-form.jsp">Добавить студента</a>

</center>

</body>
</html>
