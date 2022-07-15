<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>User Details</title>
</head>
<body>
	<div class="container">
		<form action="UserSession" method="POST">

			<table style="width:50%" border="1" >
			<thead>
			</thead>
				<tr>
					<td> <label> User Name : </label> </td>
					<td><input type="text" name="userName"  required style="width:100%"></td>
				</tr>
				<tr>
					<td> <label>Password : </label> </td>
					<td><input type="password" name="passWord"  required style="width:100%"></td>
				</tr>
			</table>

			<input type="submit" value="Login">

		</form>
	</div>
</body>
</html>

