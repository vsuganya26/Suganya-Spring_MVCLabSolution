<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
		<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
	</head>
	
	<body>
	
		<div class="container">
			<h1>Student Management System</h1>
			<hr />
			
			<h2>
				Available list of students
				<a href="/StudentCollegeFest/students/new" class="btn btn-primary btn-sm float-end">Add a Student</a>
			</h2>
			<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Name</th>
					<th>Category</th>
					<th>Author</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${students}" var="tempStudent">
					<tr>
						<td><c:out value="${tempStudent.name}" /></td>
						<td><c:out value="${tempStudent.department}"/></td>
						<td><c:out value="${tempStudent.country}"/></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/StudentCollegeFest/students/edit?id=${tempStudent.id}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a href="/StudentCollegeFest/students/delete?id=${tempStudent.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">
								Delete </a>

						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>
		</div>
	</body>
</html>