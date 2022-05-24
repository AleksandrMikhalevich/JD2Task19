<%@ page import="DTO.CourseAdminDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="courses.entity.Teacher" %><%--
  Created by IntelliJ IDEA.
  User: akyna
  Date: 19.05.2022
  Time: 00:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Страница администратора</title>
</head>
<%@include file="header.jsp" %>
<body>
<center>
    <h2>Сервис администратора</h2>
        <table border="6" width="50%">
            <caption><b>Список курсов</b></caption>
            <tr>
                <th>№</th>
                <th>Курсы</th>
                <th>Учителя</th>
                <th>Добавить</th>
            </tr>
            <% List<CourseAdminDTO> listOfCourse =
                    (List<CourseAdminDTO>) request.getAttribute("listOfAllCourses");
                int i = 1;
                for (CourseAdminDTO course : listOfCourse) {
            %>
            <tr>
                <td>
                    <%= i++%>
                </td>
                <td>
                    <%= course.getDescription()%>
                </td>
                <td>
                    <table>
                        <% List<Teacher> listOfTeachers = course.getListOfTeachers();
                            for (Teacher teacher : listOfTeachers) {
                        %>
                        <tr>
                            <td>
                                <%= teacher.getSurname()%>&nbsp;<%= teacher.getName()%>
                            </td>
                            <td>
                                <form name="disconnect" method="post" action="admin">
                                    <input name="idCourse" type="hidden" value="<%=course.getId()%>">
                                    <input name="idTeacher" type="hidden" value="<%=teacher.getId()%>">
                                    <button class="gradient-button" type="submit" name="action" value="cancelToEnroll">
                                        Снять с курса
                                    </button>
                                </form>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                </td>
                <td>
                    <form name="enroll" method="post" action="admin">
                        <input name="idCourse" type="hidden" value="<%=course.getId()%>">
                        <input name="action" type="hidden" value="enroll">
                        <button class="gradient-button">Назначить на курс</button>
                    </form>
                </td>
            </tr>
            <%
                }
            %>
        </table>
            <a class="gradient-button1" href="course">Управление Курсами</a>

            <a class="gradient-button1" href="teacher">Информация об Учителях</a>
    </center>
</body>
</html>
