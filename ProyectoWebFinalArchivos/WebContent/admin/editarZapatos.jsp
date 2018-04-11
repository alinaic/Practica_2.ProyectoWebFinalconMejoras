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
		
		<br>
		<div style="color:red">${mensaje} </div>
		<br>
		<form action="ServletGuardarCambioZapatos" method="post">
			<div style="margin:18px">
			
			<b>Categoria:</b>
				<select name="campoCategoria"> 
					<option value="" selected="selected"></option>
					<option value="Hombre">Hombre</option>
					<option value="Mujer">Mujer</option>
					<option value="Niños">Niños</option>
					<option value="Niñas">Niñas</option>
				</select><br />
			<b>Temporada:</b><input type="text" name="campoTemporada" value="${zapatosAeditar.temporada}"><br />
			<b>Talla:</b><input type="text" name="campoTalla" value="${zapatosAeditar.talla}"><br /> 
			<b>Material:</b><input type="text" name="campoMaterial" value="${zapatosAeditar.material}"><br /> 
			<b>Tipo:</b><input type="text" name="campoTipo" value="${zapatosAeditar.tipo}"><br /> 
			<b>Color:</b>
				<input type="checkbox" id="cboxnegro" name="CampoColor" value="Negro" checked>Negro
				<input type="checkbox" id="cboxblanco" name="CampoColor" value="Blanco">Blanco
				<input type="checkbox" id="cboxgris" name="CampoColor" value="Gris">Gris
			<br>
			<b>Marcas:</b><input type="text" name="campoMarcas" value="${zapatosAeditar.marcas}"><br />
			<b>Imagen:</b><input type="file" name="campoImagen" /><br />
			<input type="hidden" name="campoId" value="${zapatosAeditar.id}" />
			</div>
			<div style="margin:16px">
			<br /> <input type="submit" value="GUARDAR CAMBIOS" />
			</div>
		</form>	
	</body>
</html>