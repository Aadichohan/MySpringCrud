<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored ="false" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Management Screen</title>
</head>
<body>
	<div align="center">
		<h1>Employee List</h1>

		<table border="1">

			<th>Title</th>
			<th>Email</th>
			<th>Detail</th>
			<th>Action</th>

			<c:forEach var="todo" items="${ListTodo}">
				<tr>

					<td>${todo.todoTitle}</td>
					<td>${todo.todoEmail}</td>
					<td>${todo.todoDetail}</td>
					<td><a href="editTodo?id=${todo.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteTodo?id=${todo.id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		<h4>
			New Employee Register <a href="addTodo">here</a>
		</h4>
	</div>
</body>
</html>