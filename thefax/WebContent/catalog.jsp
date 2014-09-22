<%@page import="com.thefax.bean.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catalog</title>
</head>
<%
	if (session.getAttribute("USER") == null) {
		response.sendRedirect("home.jsp");
	}
%>

<body>
	<jsp:include page="banner.jsp" />
	<%
		ArrayList<ProductBean> catalog = (ArrayList<ProductBean>) request
				.getAttribute("CATALOG");
	%>
	<table align="center" border="3">
		<tr>
			<th>Select</th>
			<th>Description</th>
			<th>Price</th>
		</tr>

		<%
			for (ProductBean p : catalog) {
		%>
		<tr>
			<td><a href="shopping.fax?code=<%=p.getCode()%>"> <img
					src="shopping-cart.png"> </a>
			</td>
			<td><%=p.getDescription()%></td>
			<td><%="$ " + p.getPrice()%>0</td>
		</tr>
		<%
			}
		%>

	</table>
</body>
</html>