<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login Registration</title>
</head>
<body>
<h2>User Login Registration</h2>
    <form action="userLogin" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="email" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <input type="submit" value="save">
    </form>
    
  
    
    <%
if(request.getAttribute("msg")!=null){
out.println(request.getAttribute("msg"));
}
%>

</body>
</html>