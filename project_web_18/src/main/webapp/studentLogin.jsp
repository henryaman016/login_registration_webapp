<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Login Here</title>
</head>
<body>
<h2>Student Login</h2>
    <form action="studentLogin" method="post">
        <label for="username">Email:</label>
        <input type="text" id="username" name="email" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <input type="submit" value="Login">
    </form>
    <a href="loginjsp.jsp">Admin Login</a>
    
    <%
    if (request.getAttribute("error") != null) {
        out.println(request.getAttribute("error"));
    }
    %>

</body>
</html>