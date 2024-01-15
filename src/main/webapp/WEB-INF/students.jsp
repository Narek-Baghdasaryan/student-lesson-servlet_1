<%@ page import="java.util.List" %>
<%@ page import="com.example.studentlessonservlet_1.model.Lesson" %>
<%@ page import="com.example.studentlessonservlet_1.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>

</head>
<body>
<%
  List<Student> students = (List<Student>) request.getAttribute("students");
%>

Student | <a href="/addStudent">Add Student</a>
<%
    if (!students.isEmpty()){
        for (Student student : students) { %>
<table border="1px">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
        <th>Age</th>
        <th>Lesson</th>

        <th>Delete</th>
    </tr>


    <tr>
        <td><%=student.getId()%></td>
        <td><%=student.getName()%></td>
        <td><%=student.getSurname()%></td>
        <td><%=student.getEmail()%></td>
        <td><%=student.getAge()%></td>
        <td><%=student.getLesson().getName()%></td>
        <td><a href="/deleteStudent?id=<%=student.getId()%>">delete</a> </td>
    </tr>
        <%}
    }
    %>

</table>
</body>
</html>
