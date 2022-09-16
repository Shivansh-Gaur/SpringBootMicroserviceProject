<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script>
function showAlert(){
	alert("Deletion Successfull");
}

</script>
<title>Admin Page</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet"></link>
</head>
<body>
<div class="container">
		<pre>${delete}</pre>
	<h1>All Users Data:</h1>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Id</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>UserName</th>
				<th>Password</th>
				<th>Address</th>
				<th>ContactDetails</th>
				<th> </th>
				<th> </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${show}" var="show">
				<tr>
					<td>${show.id}</td>
					<td>${show.firstname}</td>
					<td>${show.lastname}</td>
					<td>${show.username}</td>
					<td>${show.password}</td>
					<td>${show.address}</td>
					<td>${show.contactdetails}</td>
					<td><a href="/update/${show.id}" class="btn btn-warning" >Update</a></td>
					<td><a href="/delete/${show.id}" class="btn btn-danger" onclick="showAlert()">Delete</a></td>
									</tr>
			</c:forEach> 
		</tbody>
	</table>
	<a href="main" class="btn btn-success">Main Menu</a>
	</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>
