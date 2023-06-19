<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Cliente</title>
    <link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body>
<h1>Agregar Cliente</h1>

<form action="AgregarClienteServlet" method="post">
    <label for="nombre">Nombre:</label>
    <input type="text" id="nombre" name="nombre" required><br><br>

    <label for="rut">RUT:</label>
    <input type="text" id="rut" name="rut" required><br><br>

    <label for="correo">Correo Electrónico:</label>
    <input type="email" id="correo" name="correo" required><br><br>

    <input type="submit" value="Agregar Cliente">
</form>
</body>
</html>
