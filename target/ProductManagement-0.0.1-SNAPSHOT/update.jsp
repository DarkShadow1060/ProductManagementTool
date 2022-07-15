<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.io.PrintWriter"%>
<%@page import="org.hibernate.Session" %>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="java.util.List" %>
<%@page import="org.hibernate.Transaction" %>
<%@page import="com.nagarro.productmanagement.entity.ProductEntity" %>
<%@page import="javax.servlet.jsp.jstl.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
	<%
	HttpSession httpSesssion = request.getSession();
	Session hibernateSession = (Session) httpSesssion.getAttribute("HIBERNATE_SESSION");
	int productID = Integer.parseInt(request.getParameter("product_id").trim());
	httpSesssion.setAttribute("PRODUCT_ID",productID);
	ProductEntity object = hibernateSession.get(ProductEntity.class, productID);
	%>

	<h1>Update the Details</h1>
	<hr>
	<br>
	<form action="UpdateToList" method="POST">
		<br>
		<div class="inputArea">

			<div>
				<label> Product Name : </label>
			</div>
			<div>
				<input id="Pname" type="text" name="ProductName" required value=<%= object.getTitle() %> >
			</div>
		</div>
		<br>
		<div class="inputArea">

			<div>
				<label> Size : </label>
			</div>
			<div>
				<input id="size" type="text" name="ProductSize" required value=<%= object.getSize() %>>
			</div>
		</div>
		<br>
		<div class="inputArea">

			<div>
				<label> Quantity : </label>
			</div>
			<div>
				<input id="quantity" type="number" name="ProductQuantity" required value=<%= object.getQuantity() %>>
			</div>
		</div>
		<br>
		<div class="inputArea">
			<div>
				<label>Image : </label>
			</div>
			<div>
				<input type="file" id="image" name="ProductImage" value=<%= object.getImgname() %>required>
			</div>
		</div>
		<hr>
		<br> <input type="submit" value="Update Item">
		<a href="userLoginAccount.jsp"> <input type="button" value="Cancel"> </a>
	</form>
	<br>
	<hr>
</body>
</html>