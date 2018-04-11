<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
		<br><div style="color:red">${mensaje} </div><br>
		<form action="ServletGuardarCambioClientes" method="post">
			<div style="margin:8px">

			<b>Nombre:</b><input type="text" name="campoNombre" value="${clientesAeditar.nombre}"><br /> 
			<b>Calle:</b><input type="text" name="campoCalle" value="${clientesAeditar.calle}"><br />
			<b>Número de calle:</b><input type="text" name="campoNumero_calle" value="${clientesAeditar.numero_calle}"><br /> 
			<b>Código Postal:</b><input type="text" name="campoCodigo_postal" value="${clientesAeditar.codigo_postal}"><br /> 
			<b>Teléfono:</b><input type="text" name="campoTelefono" value="${clientesAeditar.telefono}"><br /> 
			<b>E-mail:</b><input type="text" name="campoEmail" value="${clientesAeditar.email}"><br />
			<b>Particular o empresa:</b>
				<input type="radio" name="campoTipo" value="Particular" checked>Particular
				<input type="radio" name="campoTipo" value="Empresa">Empresa<br /> 
			<input type="hidden" name="campoId" value="${clientesAeditar.id}"><br />
			</div>
			<div style="margin:16px">
			<input type="submit" value="GUARDAR CAMBIOS"/>
			</div>
		</form>
	</body>
</html>