<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
		<link type="text/css" rel="stylesheet" href="css/style.css">
		<title>Add a to do</title>
	</head>
	
	<body>
		<div id="wrapper">
		<div id="header">
			<a href="LogoutServlet" style="color: white; float: right">Logout</a>
			<h2>Welcome ${sessionScope.username}</h2>
		</div>
		<div id="header">
			<center>
				<h2>Add a To Do</h2>
			</center>
		</div>
	</div>
		<div id="container">
			<form action="AddToDoServlet" method="post">
				<table>
					<tbody>
						<tr>
							<td><label>Description : </label></td>
							<td><input type="text" name="description" value="" /></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" /></td>
						</tr>
					</tbody>
				</table>
			</form>
			<div style="clear: both;"></div>
			<a href="/ToDoList">Back to List</a>
		</div>
	</body>
</html>

