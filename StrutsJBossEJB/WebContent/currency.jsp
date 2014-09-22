<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Currency Converter</title>
</head>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<body>
	<html:form action="login.do">
		<table>
			<tr>
				<td>Enter Dollar Amount</td>
				<td><html:text property="dollar" />
				<td>
				<td><html:errors property="userid" />
				</td>
			</tr>

			<tr>
				<th colspan="2"><html:submit value="Convert" /></th>
			</tr>
		</table>
	</html:form>
</body>
</html>