<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Gestión WEB</title>
	</head>
	
	<body>
		<b>Introduce tus datos de administrador:</b><br><br>
		<form action="ServletIdentificacionAdmin" method="post">
			<b>Login:</b><input type="text" name="campoLogin"><br>
			<b>Password:</b><input type="password" name="campoPass"><br><br>
			<input type="submit" value="IDENTIFICAME"/>
		</form>
	</body>
</html>