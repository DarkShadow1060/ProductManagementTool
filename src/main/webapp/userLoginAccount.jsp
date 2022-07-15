<%@page import="org.hibernate.Transaction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.io.PrintWriter"%>
<%@page import="org.hibernate.Session" %>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="org.hibernate.Query" %>
<%@page import="java.util.List" %>
<%@page import="com.nagarro.productmanagement.entity.ProductEntity" %>
<%@page import="javax.servlet.jsp.jstl.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

response.setHeader("Expires", "0");
%>
<!DOCTYPE html>
<%
//============================================================================================================
PrintWriter dis = response.getWriter();
if (session.getAttribute("UserName") == null) {
	response.sendRedirect("login.jsp");
} else {
	dis.print(" Hello " + " " + session.getAttribute("UserName"));
}
//===============================================================================================================
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<style type="text/css">
tr {
	border: 1px;
	order-style: double;
}

td {
	border: 1px;
	border-style: double;
	text-align: center;
}
</style>
</head>
<body>
	<div class="Header">
		<form action="Logout" method="POST">
			<h1 style="width: 90%; display: inline-block;">Product
				Management Tool</h1>
			<input type="submit" value="Logout">
		</form>
	</div>
	<hr>
	<br>
	<div class="mainBody">
		<form action="AddToList" method="POST">
			<br>
			<div class="inputArea">

				<div>
					<label> Product Name : </label>
				</div>
				<div>
					<input id="Pname" type="text" name="ProductName" required>
				</div>
			</div>
			<br>
			<div class="inputArea">

				<div>
					<label> Size : </label>
				</div>
				<div>
					<input id="size" type="text" name="ProductSize" required>
				</div>
			</div>
			<br>
			<div class="inputArea">

				<div>
					<label> Quantity : </label>
				</div>
				<div>
					<input id="quantity" type="number" name="ProductQuantity" required>
				</div>
			</div>
			<br>
			<div class="inputArea">
				<div>
					<label>Image : </label>
				</div>
				<div>
					<input type="file" id="image" name="ProductImage" required>
				</div>
			</div>
			<br> <input type="submit" value="Add Item">
		</form>

	</div>
	<hr>
	
		<%
			Session hibernateSession = (Session)session.getAttribute("HIBERNATE_SESSION");
			String queryString = "from ProductEntity where userName = '"  + session.getAttribute("UserName") + "'";
			Query query = hibernateSession.createQuery(queryString);
			List<ProductEntity> result = (List<ProductEntity>)query.list();
		%>
	

	<hr>
	<div>

		<table style="width: 90%; border: 1px solid black;">
			<thead style="border: 1px solid black">
				<tr>
					<th style="width: 5%">Sl No.</th>
					<th style="width: 30%">Product Name</th>
					<th style="width: 10%">Quantity</th>
					<th style="width: 10%">Size</th>
					<th style="width: 30%">Image</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<%
					for(ProductEntity product : result){
				%>
					<tr>
						<td style="width: 5%"><% out.print(product.getId());%> </td>
						<td style="width: 30%"> <% out.print(product.getTitle());%> </td>
						<td style="width: 10%"> <% out.print(product.getQuantity());%> </td>
						<td style="width: 10%"> <% out.print(product.getSize());%> </td>
						<td style="width: 30%"> <img alt="ErroR Loading" src="data:image/jpg;base64,<%= product.getBase64Image() %>" width="100px" height="100px" />  </td>
						<!-- image tag -->
						<td>
						<a href="update.jsp?product_id=<%= product.getId() %>" ><button >Update</button></a>
						<a href="Delete?product_id=<%= product.getId() %>"> <button >Remove</button></a>	    
						</td>
					</tr>
				<%
					}
				
				%>
			</tbody>
		</table>

	</div>

</body>
</html>