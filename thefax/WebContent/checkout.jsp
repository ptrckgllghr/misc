<%@page import="com.thefax.bean.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout</title>
</head>
<body>
	<jsp:include page="banner.jsp" />
	<%
		ArrayList<ProductBean> cart = (ArrayList<ProductBean>) session
				.getAttribute("CART");
				
		String index = request.getParameter("idx");
		if (index != null) {
			cart.remove(Integer.parseInt(index));
		}
		session.setAttribute("CART",cart);
	%>
	<table align="center" border="3">
		<tr>
			<th></th>
			<th>Description</th>
			<th>Price</th>
		</tr>
		<%
			double total = 0;
			int idx = 0;
		%>
		<%
			for (ProductBean p : cart) {
		%>
		<tr>
			<td><a href="checkout.jsp?idx=<%=idx++%>"> <img src="minus.png"> </a></td>
			<td><%=p.getDescription()%></td>
			<td><%="$ " + p.getPrice()%>0</td>
		</tr>
		<%
			total += p.getPrice();
			}
		%>

		<tr>
			<td></td>
			<td>CART TOTAL</td>
			<td><%=total%>0</td>
		</tr>
		<tr>
		<td>Name:</td>
		<td></td>
		<td></td>
		<td></td>
		</tr>
		<tr>
		<td></td>
		<td></td>
		<td></td>
		</tr>
		<tr>
		<td></td>
		<td></td>
		<td><a href="payment.jsp"> <img src="checkout_icon.gif" /></a></td>
		</tr>

	</table>
</body>
</html>

</body>
</html>