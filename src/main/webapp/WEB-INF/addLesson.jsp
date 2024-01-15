<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15.01.2024
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Lesson</title>
</head>
<body>
<form method="post" action="/addLesson">
Lesson Name: <input type="text" name="name"><br>
Lesson Duration: <input type="date" name="duration"><br>
LecturerName: <input type="text" name="lecturerName"><br>
Lesson Price: <input type="number" name="price"><br>
<input type="submit" value="Add">
</form>
</body>
</html>
