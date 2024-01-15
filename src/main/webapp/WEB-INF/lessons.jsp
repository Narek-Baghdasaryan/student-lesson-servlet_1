<%@ page import="java.util.List" %>
<%@ page import="com.example.studentlessonservlet_1.model.Lesson" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lessons</title>

</head>
<body>
<%
  List<Lesson> lessons = (List<Lesson>) request.getAttribute("lessons");
%>

Lessons | <a href="/addLesson">Add Lesson</a>

<table border="1px">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Duration</th>
        <th>lecturerName</th>
        <th>Price</th>
        <th>Delete</th>
    </tr>

    <%
    if (!lessons.isEmpty()){
        for (Lesson lesson : lessons) { %>
    <tr>
        <td><%=lesson.getId()%></td>
        <td><%=lesson.getName()%></td>
        <td><%=lesson.getDuration()%></td>
        <td><%=lesson.getLecturerName()%></td>
        <td><%=lesson.getPrice()%></td>
        <td><a href="/deleteLesson?id=<%=lesson.getId()%>">delete</a> </td>
    </tr>
        <%}
    }
    %>

</table>
</body>
</html>
