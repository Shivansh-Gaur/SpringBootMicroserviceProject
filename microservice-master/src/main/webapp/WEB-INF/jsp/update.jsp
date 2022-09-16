<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Details</title>
<script>
	function showAlert() {
		alert("Details Updated Successfully");
	}
</script>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet"></link>
</head>
<body>
	<pre>${edit}</pre>
	<div class="container">

		<form method="post">
			<c:set value="${updates}" var="updates"></c:set>
			

			<table class="table table-bordered " style="background-color: #96D4D4;">
				<tr>
					<td>FirstName:</td>
					<td><input type="text" name="firstname" required="required"
						value="${updates.firstname}"></input></td>
				</tr>
				<tr>
					<td>LastName:</td>
					<td><input type="text" name="lastname" required="required"
						value="${updates.lastname}"></input></td>

				</tr>
				<tr>
					<td>UserName:</td>
					<td><input type="text" name="username" required="required" value="${updates.username}"></input></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" required="required"></input></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><input type="text" name="address" required="required" value="${updates.address}"></input>
					</td>
				</tr>
				<tr>
					<td>Contact Details:</td>
					<td><input type="text" name="contactdetails"
						required="required" value="${updates.contactdetails}"></input></td>
				</tr>
				<tr>
					<td><input type="submit" class="btn btn-success"
						onclick="showAlert()"></input></td>
				</tr>


			</table>
		</form>

	</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>
