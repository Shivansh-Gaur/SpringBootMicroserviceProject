<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet"></link>

</head>
<body>
	<div class="container">
		<pre>${error}</pre>
		<form method="post">
			<table class="table table-bordered "
				style="background-color: #96D4D4; ">
				<tr>
					<td colspan=3 align="center"
						style="font-weight: bold; font-size: 20pt;" align="center">User
						Login</td>

				</tr>

				<tr>
					<td style="font-size: 14pt;" align="center">UserName:</td>
					<td><input type="text" style="display:block; margin:auto; text-align:center" name="username" required="required"></input></td>
				</tr>
				<tr></tr>
				<tr>
					<td style="font-size: 14pt;" align="center">Password:</td>
					<td><input type="password" style="display:block; margin:auto; text-align:center" name="password" required="required"></input></td>
				</tr>
				<tr></tr>
				<tr>
				<td colspan="2">	<input type="submit" style="display:block; margin:auto" class="btn btn-success"></input></td>
				</tr>

			</table>
		</form>


	</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>
