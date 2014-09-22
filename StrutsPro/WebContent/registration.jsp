<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<body>
	<h2>Register</h2>
	<html:errors />
	<html:form action="registration.do">

		<table>
			<tr>
				<td><bean:message key="reg.userid" /></td>
				<td><html:text property="userid" /></td>
			</tr>
			<tr>
				<td><bean:message key="reg.name" /></td>
				<td><html:text property="name" /></td>
			</tr>
			<tr>
				<td><bean:message key="reg.age" /></td>
				<td><html:text property="age" /></td>
			</tr>
			<tr>
				<td><bean:message key="reg.city" /></td>
				<td><html:text property="city" /></td>
			</tr>
			<tr>
				<td><bean:message key="reg.email" /></td>
				<td><html:text property="email" /></td>
			</tr>
			<tr>
				<td><bean:message key="reg.phone" /></td>
				<td><html:text property="phone" /></td>
			</tr>
			<tr>
				<td><bean:message key="reg.password" /></td>
				<td><html:password property="password" /></td>
			</tr>
			<tr>
				<th colspan="2"><html:submit>
						<bean:message key="reg.save" />
					</html:submit>
				</th>
			</tr>
		</table>
	</html:form>

	<hr>

	<a href="registration.jsp?lang=en">English</a> |
	<a href="registration.jsp?lang=es">Spanish</a>

</body>
</html>