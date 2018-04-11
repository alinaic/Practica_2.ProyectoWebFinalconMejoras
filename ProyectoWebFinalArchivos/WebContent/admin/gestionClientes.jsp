
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Gestión WEB</title>
	</head>
	
	<body>
		
		<jsp:include page="menu.jsp"></jsp:include>


		<table id="TablaClientes">
			<tr>
				<th>Nombre</th>
				<th>Calle</th>
				<th>Numero de calle</th>
				<th>Codigo Postal</th>
				<th>Teléfono</th>
				<th>E-mail</th>
				<th>Particular</th>
				<th>Empresa</th>
				<th></th>
				<th></th>
			</tr>

			<c:forEach items="${clientes}" var="clientes">
				<tr>
					<td>${clientes.nombre}</td>
					<td>${clientes.calle}</td>
					<td>${clientes.numero_calle}</td>
					<td>${clientes.codigo_postal}</td>
					<td>${clientes.telefono}</td>
					<td>${clientes.email}</td>
					<td>${clientes.particular}</td>
					<td>${clientes.empresa}</td>
					<td><a href="ServletEditarClientes?id=${clientes.id}">EDITAR</a></td>
					<td><a href="ServletBorrarClientes?id=${clientes.id}">BORRAR</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>