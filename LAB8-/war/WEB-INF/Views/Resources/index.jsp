<%@ page import="java.util.List"%>
<%@ page import="model.entity.Resource"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
<style>
p {
	color: black;
	font-family: Verdana;
}

body {
	background-color: #A9F5F2
}
</style>
<title>List Resource</title>
</head>
<body>


	<a href="/" class="navbar-brand">HOME </a>

	<a href="/recurso/insertar">INSERT</a>
	<h1 class="text-center">
		RESOURCE<span class="badge badge-secondary"></span>
	</h1>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>#</th>
				<th>ID</th>
				<th>RESOURCE</th>
				<th>DATE</th>
				<th>STATE</th>
				<th></th>

			</tr>
		</thead>

		<% List<Resource> users=(List<Resource>)request.getAttribute("resource");%>

		<%if (users.size()>0) {%>

		<% for(int i=0;i<users.size();i++) {%>
		<%Resource u=(Resource)users.get(i); %>

		<tbody>
			<tr>
				<th scope="row"><%=i+1%></th>
				<td><%=u.getId()%></td>
				<td><%=u.getUrl()%></td>
				<td><%=u.Date()%></td>
				<td><%=u.State()%></td>

				<td class='btn btn-group'><a
					href="/recurso/modificar?id=<%=u.getId()%>"
					class="btn btn-primary btn-sm">UPDATE</a> <a
					href="/recurso/eliminar?id=<%=u.getId()%>"
					class="btn btn-primary btn-sm">DELETE</a></td>
			</tr>

		</tbody>

		<%}} %>

	</table>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
		integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
		integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
		crossorigin="anonymous"></script>


</body>
</html>