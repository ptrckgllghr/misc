<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Core Tags :: JSTL</title>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>



<h1>Core Tag Library</h1>
<c:set var="test" value="Test Value" />
<h2><c:out value="${test}" /></h2>

<c:forEach var="count" begin="1" end="10" step="1">
	<c:if test="${count%2 == 0 }">
		<h4><c:out value="${count}" /></h4>
		</c:if>
</c:forEach>

<c:set var="week" value="Sun-Mon-Tue-Wed-Thu-Fri-Sat" />
<select>
<c:forTokens items="${week }" delims="-" var="day">
	<option value="${day}">${day}</option>
</c:forTokens>
</select>
</body>
</html>