<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USER LOGIN</title>
</head>
<body>
	<form action="LoginType" method="POST">
	
	<div>
		<div>
			<label>Existing User</label>
			<input type="radio" name="UsrType" value="Existing User" checked="checked">
		</div>
		<div>
			<label>New User</label>
			<input type="radio" name="UsrType" value="New User">
		</div>
		<div>
			<input type="submit">
		</div>
	</div>
	
	</form>
</body>
</html>