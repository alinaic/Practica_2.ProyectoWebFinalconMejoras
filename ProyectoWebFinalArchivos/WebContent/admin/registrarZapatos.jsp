<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Gestión WEB</title>
		<script type="text/javascript" src="js/validacionRegistrarZapatos.js"></script>
	</head>

	<body>

		<jsp:include page="menu.jsp"></jsp:include>
		<br>
		<div style="color:red">${mensaje} </div>
		
		<br> <b>Registra zapatos:</b>
		<br><br>
		<form action="ServletRegistroZapatos" method="post">
			<b>Categoria</b>
			<select name="campoCategoria"> 
				<option value="" selected="selected"></option>
				<option value="Hombre">Hombre</option>
				<option value="Mujer">Mujer</option>
				<option value="Niños">Niños</option>
				<option value="Niñas">Niñas</option>
			</select><br />
			<b>Temporada:</b><input type="text" name="campoTemporada"><br />
			<b>Talla:</b><input type="text" name="campoTalla"><br /> 
			<b>Material:</b><input type="text" name="campoMaterial"><br /> 
			<b>Tipo:</b><input type="text" name="campoTipo"><br /> 
			<b>Color:</b>
				<input type="checkbox" id="cboxnegro" name="CampoColor" value="Negro">Negro
				<input type="checkbox" id="cboxblanco" name="CampoColor" value="Blanco">Blanco
				<input type="checkbox" id="cboxgris" name="CampoColor" value="Gris">Gris
			<br /> 
			<b>Marcas:</b><input type="text" name="campoMarcas"><br />
			<b>Imagen:</b><input type="file" name="campoImagen" /><br />
			<br /> <input type="submit" value="REGISTRAR" /><br />
		</form>
	</body>
</html>