<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Gestión WEB</title>
	</head>
	
	<body>

		<jsp:include page="menu.jsp"></jsp:include>
		<br>
		<div style="color:red">${mensaje} </div>
		
		<br><b>Registra clientes:</b>
		<br><br>
		<form action="ServletRegistroCliente" method="post">
			<b>Nombre:</b><input type="text" name="campoNombre"><br /> 
			<b>Calle:</b><input type="text" name="campoCalle"><br />
			<b>Número de calle:</b><input type="text" name="campoNumero_calle"><br /> 
			<b>Código Postal:</b><input type="text" name="campoCodigo_postal"><br /> 
			<b>Teléfono:</b><input type="text" name="campoTelefono"><br /> 
			<b>E-mail:</b><input type="text" name="campoEmail"><br />
			<b>Particular o empresa:</b>
				<input type="radio" name="campoTipo" value="Particular" checked>Particular
				<input type="radio" name="campoTipo" value="Empresa">Empresa
			<br /><input type="submit" value="REGISTRAR" />
		</form>
	</body>
</html>