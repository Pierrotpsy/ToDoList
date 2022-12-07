<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%> 
<html>
<head>
	<title>To do List</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
	<!-- ${TODO_LIST}-->
	<div id="wrapper">
		<div id="header">
			<a href="LogoutServlet" style="color: white; float: right">Logout</a>
			<h2>Welcome ${sessionScope.username}</h2>
		</div>
		<div id="header">
			<center>
				<h2>To Do List</h2>
			</center>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<form class="addtodo-form" action="AddToDoServlet" method="get">
				<input type="submit" value="Add todo" name="todo_add" />
			</form>
			<table>
				<tr>
					<th>Description</th>
					<th>Action</th>
				</tr>
				<c:forEach var="tempTodo" items="${TODO_LIST}">
					<c:url var="EditLink" value="EditToDoServlet">
						<c:param name="id" value="${tempTodo.id}" />
						<c:param name="description" value="${tempTodo.description}" />
					</c:url>
					<c:url var="DeleteLink" value="DeleteToDoServlet">
						<c:param name="id" value="${tempTodo.id}" />
						<c:param name="description" value="${tempTodo.description}" />
					</c:url>
					<tr>
						<td>${tempTodo.description}</td>
						<td><a href="${EditLink}">Edit</a> <a> | </a> <a
							href="${DeleteLink}" title="delete" class="delete"
							onclick="return confirm('Are you sure you want to delete this todo?')">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
