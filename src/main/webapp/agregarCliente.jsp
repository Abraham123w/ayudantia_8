<html>
<head>
    <meta charset="UTF-8">
    <title>Obtener Parámetros</title>
    <link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body>
<h1>Obtener Parámetros</h1>
<form action="AgregarClienteServlet" method="POST">
    <label for="nombre">Nombre:</label>
    <input type="text" name="nombre" id="nombre"><br>

    <label for="rut">RUT:</label>
    <input type="text" name="rut" id="rut"><br>

    <label for="correo">Correo:</label>
    <input type="text" name="correo" id="correo"><br>

    <input type="submit" value="Enviar">
</form>
</body>
</html>