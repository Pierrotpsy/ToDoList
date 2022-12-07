<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%> 
<!DOCTYPE html>
<HTML>
	<HEAD>
		<TITLE> JAAS Authentication </TITLE>
	</HEAD>
	
	<body>
		<div align="center">
			<h1>Please log in</h1>
		</div>
		<form method="POST" action="j_security_check">
			<table align="center">
				<tr>
					<td>Username :</td>
					<td><input type="text" name="j_username" value=${username}></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="j_password" value=""></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit"></td>
					<td><input type="reset" value="Cancel"></td>
				</tr>
			</table>
		</form>
	</body>
</HTML>