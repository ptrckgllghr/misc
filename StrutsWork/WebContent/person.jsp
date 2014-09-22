<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Personal Form</title>
</head>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<body>
	<h2>Personal Form</h2>
	<hr>
	<html:errors/>
	<html:form action="person.do">
		<table>
			<tr>
				<td><bean:message key="pers.name" />
				</td>
				<td><html:text property="name" size="3" /></td>
			</tr>
			<tr>
				<td><bean:message key="pers.age" />
				</td>
				<td><html:text property="age" size="3" /></td>
			</tr>

			<tr>
				<td><bean:message key="pers.city" />
				</td>
				<td><html:text property="city" /></td>
			</tr>
			<tr>
				<th colspan="2"><html:submit>
						<bean:message key="pers.save" />
					</html:submit>
				</th>
			</tr>
		</table>
	</html:form>
</body>
</html>