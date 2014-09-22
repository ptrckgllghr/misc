<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search for user data</title>
</head>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<body>
	<h2>Search:</h2>
	<html:form action="display.do">
		<table>
			<tr>
				<td><html:text property="userid" />
				</td>
			</tr>
			<tr>
				<th colspan="2"><html:submit value="Search" /></th>
			</tr>
		</table>
	</html:form>

</body>
</html>