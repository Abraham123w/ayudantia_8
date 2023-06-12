<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Menu Tienda</title>                       <!-- Título de la página -->
    <link rel="stylesheet" type="text/css" href="estilos.css">   <!-- Enlace al archivo de estilos -->
</head>
<body>
<h1>Bienvenido(a) al Menu Tienda</h1>              <!-- Encabezado de bienvenida -->

<div class="botones">                             <!-- Contenedor de botones -->
    <button onclick="location.href='agregarArticulo.jsp'">Agregar Artículo</button>                  <!-- Botón para agregar un artículo -->
    <button onclick="location.href='actualizarInformacionArticulo.jsp'">Actualizar Información de Artículo</button>   <!-- Botón para actualizar la información de un artículo -->
    <button onclick="location.href='agregarCliente.jsp'">Agregar Cliente</button>                    <!-- Botón para agregar un cliente -->
    <button onclick="location.href='buscarArticulo.jsp'">Buscar Artículo</button>                    <!-- Botón para buscar un artículo -->
</div>
</body>
</html>

