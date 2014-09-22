<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>thefax.com</title>
</head>

<%
	if (request.getParameter("logout") != null) {
		session.invalidate();
	}
%>
<body>
	<jsp:include page="banner.jsp" />
	<%
		if (request.getParameter("invalid") != null) {
	%>
	<font color="red">Invalid User ID/Password</font>
	<%
		}
	%>
	<form action="user.fax">
		<table align="right">
			<tr>
				<th>Login Here</th>
			</tr>
			<tr>
				<td><input type="text" name="userid"></td>
				<td>User ID</td>
			</tr>
			<tr>
				<td><input type="password" name="password"></td>
				<td>Password</td>
			</tr>
			<tr>
				<td><input type="submit" value="SIGN IN" name="loginbutton">
				</td>
				<td><a href="registration.jsp">Join</a>
				</td>

			</tr>
		</table>
	</form>





</body>
</html>