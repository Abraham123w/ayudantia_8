<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Buscar Artículo</title>
    <link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body>
<h1>Buscar Artículo por ID</h1>

<form method="GET" action="BuscarArticuloServlet">
    <label for="nombre">Nombre:</label>
    <input type="text" name="nombre" id="nombre">
    <input type="submit" value="Buscar">
</form>
</body>
</html>
