<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Account</title>
</head>
<body>
	<div class="container">
		<form action="NewUser" method="POST">


			<div class="inputArea">

				<div>
					<label> Name : </label>
				</div>
				<div>
					<input id="usrname" type="text" name="name" required>
				</div>
			</div>

			<div class="inputArea">

				<div>
					<label>User Name : </label>
				</div>
				<div>
					<input id="uname" type="text" name="userName" required>
				</div>
			</div>

			<div class="inputArea">

				<div>
					<label> Email : </label>
				</div>
				<div>
					<input id="mailID" type="email" name="emailID" required>
				</div>
			</div>



			<div class="inputArea">
				<div>
					<label>Password : </label>
				</div>
				<div>
					<input id="passwd" type="password" name="passWord" required>
				</div>
			</div>
			
			
			<input type="submit">
		</form>
	</div>
</body>
</html>