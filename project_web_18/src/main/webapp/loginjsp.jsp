<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>
    <h2>Admin Login</h2>
    <form action="Login" method="post">
        <label for="username">Email:</label>
        <input type="text" id="username" name="email" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <input type="submit" value="Login">
    </form>
    <a href="studentLogin.jsp">Student Login</a>
    
    <%
    if (request.getAttribute("error") != null) {
        out.println(request.getAttribute("error"));
    }
    %>
</body>
</html>
