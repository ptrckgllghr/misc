<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<font size="6" color="tomato"><i>thefax.com</i></font>
<i>Your online shopping destination</i><br>
<% String user = (String) session.getAttribute("USER");
	if(user == null) 
		user = "Guest";
 %>
<font>Hello <%= user %></font>
<a href="home.jsp?Logout=yes">Logout</a>
</body>
</html>