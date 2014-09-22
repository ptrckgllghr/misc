<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Results</title>
</head>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<body>
	<table>
		<tr>
			<td>User ID:</td>
			<td><bean:write name="serfrm" property="userid" /></td>
		</tr>
		<tr>
			<td>Name:</td>
			<td><bean:write name="serfrm" property="name" /></td>
		</tr>
		<tr>
			<td>Age:</td>
			<td><bean:write name="serfrm" property="age" /></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><bean:write name="serfrm" property="city" /></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><bean:write name="serfrm" property="email" /></td>
		</tr>
		<tr>
			<td>Phone:</td>
			<td><bean:write name="serfrm" property="phone" /></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><bean:write name="serfrm" property="password" /></td>
		</tr>
	</table>
</body>
</html>