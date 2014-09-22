<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SQL output</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

	<sql:setDataSource driver="oracle.jdbc.OracleDriver" user="pjgallagher"
		url="jdbc:oracle:thin:@Localhost:1521:xe" password="PG123"
		var="testds" />

	<sql:query var="rs" dataSource="jdbc/myds">
 		select name, age, city from person
	</sql:query>

	<table border="3">
		<c:forEach items="${rs.rows}" var="item">
			<tr>
				<td><c:out value="${item.name }" />
				</td>
				<td><c:out value="${item.age }" />
				</td>
				<td><c:out value="${item.city }" />
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>