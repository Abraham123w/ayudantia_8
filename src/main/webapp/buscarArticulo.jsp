<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Obtener Parámetros</title>
    <link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body>
<h1>BuscarArticulos</h1>
<form action="BuscarArticuloServlet" method="POST">
    <label for="nombre">Nombre:</label>
    <input type="text" name="nombre" id="nombre"><br>

    <label for="tipo">Tipo de artículo:</label>
    <input type="text" name="tipo" id="tipo"><br>

    <label for="peso">Peso:</label>
    <input type="text" name="peso" id="peso"><br>

    <label for="precio">Precio:</label>
    <input type="text" name="precio" id="precio"><br>

    <input type="submit" value="Enviar">
</form>
</body>
</html>