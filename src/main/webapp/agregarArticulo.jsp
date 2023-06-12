<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Agregar Artículo</title>
    <link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body>
<h1>Agregar Artículo</h1>

<form action="AgregarArticuloServlet" method="post">
    <label for="id">ID del Artículo:</label>
    <input type="text" name="id" id="id" required><br><br>

    <label for="nombre">Nombre:</label>
    <input type="text" name="nombre" id="nombre"><br><br>

    <label for="peso">Peso:</label>
    <input type="text" name="peso" id="peso"><br><br>

    <label for="precio">Precio:</label>
    <input type="text" name="precio" id="precio"><br><br>

    <label for="tipo">Tipo:</label>
    <input type="text" name="tipo" id="tipo"><br><br>

    <input type="submit" value="Agregar">
</form>

</body>
</html>
