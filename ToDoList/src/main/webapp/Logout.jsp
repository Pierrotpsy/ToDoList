<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<META HTTP-EQUIV = "Pragma" CONTENT="no-cache">
	<title>Logout Page </title>
	
	<body>
		<h2>Sample Form Logout</h2>
		<FORM METHOD=POST ACTION="LogoutServlet" NAME="logout">
			<p>
				<BR>
				<BR>
				<font size="2"><strong> Click this button to log out: </strong></font>
				<input type="submit" name="logout" value="Log out">
			</p>
		</form>
	</body>
</html>