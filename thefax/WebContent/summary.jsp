<%@page import="com.thefax.bean.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purchase Summary</title>
</head>
<body>
	<jsp:include page="banner.jsp" />

	<%
		ProductBean product = (ProductBean) request
				.getAttribute("PRODUCTS");
	%>
	<table align="center" border="3">
		<tr>
			<th>Items</th>
		</tr>
		<tr>
			<td>Product: <%=product.getDescription()%><br> Price: <%=product.getPrice()%>0</td>
		</tr>
		<tr>
			<td><a href="shopping.fax">Add More</a>
			</td>
		</tr>
		<tr>
			<td><a href="checkout.jsp">Checkout</a>
			</td>
		</tr>

	</table>
</body>
</html>