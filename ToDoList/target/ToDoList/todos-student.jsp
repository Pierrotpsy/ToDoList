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
			<a href=LogoutServlet style="color:white;float:right">Logout</a>
			<h2>To do List - ${sessionScope.username}</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>Description</th>
				</tr>
				<c:forEach var="tempTodo" items="${TODO_LIST }">
					<tr>
						<td>${tempTodo.description}</td>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
