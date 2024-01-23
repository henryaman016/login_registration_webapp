<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
</head>
<body>
<h2>All Student Details</h2>

<table>
<tr>
<th>Name:</th>
<th>Email:</th>
<th>Date:</th>
<th>Inquiry Table:</th>
<th>Inquiry Descriptions:</th>
<th>Action:</th>
</tr>

<%
ResultSet result=(ResultSet)request.getAttribute("result");
while(result.next()){
%>
<tr>
<td><%=result.getString(1) %></td>
<th><%=result.getString(2) %></th>
<th><%=result.getString(3) %></th>
<th><%=result.getString(4) %></th>
<th><%=result.getString(5) %></th>
<th>
<a href="delete?email=<%=result.getString(2) %>">delete</a> 
<a href="update?email=<%=result.getString(2)%>&name=<%=result.getString(1)%>">update</a>

</th>
</tr>


<%
}
%>
</table>
<a href="pages/create_userLogin.jsp">Back to User Login Registration</a>

</body>
</html>