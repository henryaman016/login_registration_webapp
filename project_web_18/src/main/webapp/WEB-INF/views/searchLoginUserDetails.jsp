<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login Details</title>
</head>
<body>
<h2>All User Login Details</h2>

<table>
<tr>
<th>Username:</th>
<th>Password:</th>
</tr>

<%
ResultSet result=(ResultSet)request.getAttribute("result");
while(result.next()){
%>

<tr>
<td><%=result.getString(1) %></td>
<th><%=result.getString(2) %></th>
</tr>
<%
}
%>
</table>
</body>
</html>