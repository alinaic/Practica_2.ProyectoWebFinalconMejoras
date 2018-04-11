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
		
		<br><br>
		<div>
 			<form action="ServletListadoZapatos">
				Buscar:<input type="text" name="campoBusqueda"/>
				<input type="submit" value="BUSCAR"/>
			</form>
		</div>
		
		<div>Resultados:${zapatosTotales}</div>
		
		<br>
		<c:if test="${desdeAnterior >= 0}">
			<a href="ServletListadoZapatos?desde=${desdeAnterior}&cuantos=2">Anterior</a>
		</c:if>
		<c:if test="${desdeSiguiente < zapatosTotales}">
			<a href="ServletListadoZapatos?desde=${desdeSiguiente}&cuantos=2">Siguiente</a>
		</c:if>
		<br><br />
		<c:if test="${zapatosTotales > 0}">
		
			<table id="TablaZapatos">
				<tr>
					<th>Categoria</th>
					<th>Temporada</th>
					<th>Talla</th>
					<th>Material</th>
					<th>Tipo</th>
					<th>Color</th>
					<th>Marcas</th>
					<th></th>
					<th></th>
				</tr>
			
				<c:forEach items="${zapatos}" var="zapatos">
					<tr>
						<td>${zapatos.categoria}</td>
						<td>${zapatos.temporada}</td>
						<td>${zapatos.talla}</td>
						<td>${zapatos.material}</td>
						<td>${zapatos.tipo}</td>
						<td>${zapatos.color}</td>
						<td>${zapatos.marcas}</td>
						<td><a href="ServletEditarZapatos?id=${zapatos.id}">EDITAR</a></td>
						<td><a href="ServletBorrarZapatos?id=${zapatos.id}">BORRAR</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</body>
</html>