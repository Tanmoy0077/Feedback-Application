<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.firstapp.model.Department"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Results</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<style>
h1 {
	margin-top: 20px;
	margin-bottom: 20px;
}

/* body{
      background-color: #CCD3CA;
    } */
/* tr{
      background-color: #F5E8DD;
    } */
table {
	text-align: center;
	box-shadow: 5px 5px 15px 5px #888888;
}
</style>
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="/">College</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="/">Home</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/feedback">Feedback</a>
				</li>
				<li class="nav-item active"><a class="nav-link"
					href="/records">Records</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>
	<div class="d-flex justify-content-center">
		<h1>Feedbacks</h1>
	</div>
	<%
	List<Department> details = (List)request.getAttribute("data");
	%>
	<div class="w-75 container data">
		<table class="table table-bordered table-hover">
			<thead class="thead-dark">
				<tr>
					<th>Department</th>
					<th>Remarks</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Department d : details) {
				%>
				<tr>
					<td><%=d.dept%></td>
					<td><%=d.remk%></td>
					<td><a href="/editId?id=<%=d.id%>"><img src="icons/edit.svg" alt="edit" width="30"
						height="30"></a></td>
					<td><a href="/deleteID?id=<%=d.id%>"><img src="icons/delete.svg" alt="delete" width="30"
						height="30"></a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"></script>
</body>

</html>