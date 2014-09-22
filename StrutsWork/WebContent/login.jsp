<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<body>
	<h2>Login Screen</h2>
	<html:errors property="invalid"/>
	<html:form action="login.do">
		<table>
			<tr>
				<td>User ID</td>
				<td><html:text property="userid" />
				</td>
				<td><html:errors property="invalid"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><html:password property="password" redisplay="false"/>
				</td>
				<td><html:errors property="password"/></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="Login">
				</th>
			</tr>
		</table>
	</html:form>
</body>
</html>