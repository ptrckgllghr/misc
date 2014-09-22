<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>thefax.com Registration</title>
</head>
<body>
	<h1 align="center">Register</h1>
	<form action="user.fax">
		<table align="center">

			<tr>
				<td>Name</td>
				<td><input name="name"></td>
			</tr>

			<tr>
				<td>User ID</td>
				<td><input name="userid"></td>
			</tr>

			<tr>
				<td>Age</td>
				<td><select name="age">
						<%
							for (int a = 10; a < 100; a++) {
						%>
						<option value="<%=a%>">
							<%=a%></option>
						<%
							}
						%>
				</select></td>
			</tr>

			<tr>
				<td>City</td>
				<td><select name="city">
						<%
							String[] ct = { "Fairfax", "Miami", "Chicago", "New York",
									"Boston", "Vienna" };
							for (int i = 0; i < ct.length; i++) {
						%>
						<option value="<%=ct[i]%>"><%=ct[i]%></option>
						<%
							}
						%>
				</select></td>
			</tr>

			<tr>
				<td>Phone</td>
				<td><input name="phone"></td>
			</tr>

			<tr>
				<td>Email</td>
				<td><input name="email"></td>
			</tr>
			
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Create New Account">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>