<%@ page import="java.util.List" %>
<%@ page import="com.example.studentlessonservlet_1.model.Lesson" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15.01.2024
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Students</title>
</head>
<body>
<%List<Lesson> lessons =(List<Lesson>)request.getAttribute("lessons");%>

<form method="post" action="/addStudent" enctype="multipart/form-data">
Name: <input type="text" name="name"><br>
Surname: <input type="text" name="surname"><br>
Email: <input type="email" name="email"><br>
Age: <input type="number" name="age"><br>
    


    <select name="lessonId">
        <%
            for (Lesson lesson : lessons) { %>
        <option value="<%=lesson.getId()%>"><%=lesson.getName()%></option>
           <% } %>


    </select>
    <input type="file" name="picture">
<input type="submit" value="Add">
</form>
</body>
</html>
