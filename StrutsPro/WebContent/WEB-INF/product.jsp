<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Product</title>
</head>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<body>
	<h2>Register</h2>
	<html:errors />
	<html:form action="product.do">
		<table>
			<tr>
				<td><bean:message key="reg.userid" />
				</td>
				<td><html:text property="userid" />
				</td>
			</tr>
			<tr>
				<td><bean:message key="reg.name" />
				</td>
				<td><html:text property="name" />
				</td>
			</tr>
		</table>
	</html:form>
</body>
</html>