<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ include file="menu1.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Inquiry Registration page</title>
</head>
<body>
<h2>Student Inquiry Registration Here...</h2>
<form action="stuReg" method="post" >
<pre>
Name:<input type="text" name="name" />
Email:<input type="text" name="email" />
Date:<input type="date" name="date" />
Inquiry Table:<input type="text" name="inquiry_table" />
Inquiry Description:<input type="text" name="inquiry_discription" />
<input type="submit" value="save" />

</pre>
</form>

<%
if(request.getAttribute("msg")!=null){
out.println(request.getAttribute("msg"));
}
%>


</body>
</html>