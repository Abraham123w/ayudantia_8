<%--
  Created by IntelliJ IDEA.
  User: abrah
  Date: 11-06-2023
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Modificar Artículo</title>
    <link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body>
<h1>Modificar Artículo</h1>
<!-- Título principal de la página -->

<form action="ModificarArticuloServlet" method="post">
    <label for="id">ID del Artículo:</label>
    <input type="text" name="id" id="id" required><br><br>
    <!-- Campo de entrada para el ID del artículo -->

    <label for="nombre">Nombre:</label>
    <input type="text" name="nombre" id="nombre"><br><br>
    <!-- Campo de entrada para el nombre del artículo -->

    <label for="peso">Peso:</label>
    <input type="text" name="peso" id="peso"><br><br>
    <!-- Campo de entrada para el peso del artículo -->

    <label for="precio">Precio:</label>
    <input type="text" name="precio" id="precio"><br><br>
    <!-- Campo de entrada para el precio del artículo -->

    <label for="tipo">Tipo:</label>
    <input type="text" name="tipo" id="tipo"><br><br>
    <!-- Campo de entrada para el tipo del artículo -->

    <input type="submit" value="Modificar">
    <!-- Botón de envío del formulario -->
</form>
</body>
</html>






