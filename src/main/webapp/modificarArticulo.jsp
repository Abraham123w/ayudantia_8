<<%@ page import="java.util.List" %>
<%@ page import="com.example.ayudantia8.ModificarArticulosServlet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Modificar Articulo</title>
  <link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body>
<h1>Modificar Articulos</h1>
<form action="ModificarArticulosServlet" method="POST">
  <label for="nombre">Nombre:</label>
  <select name="nombre" id="nombre">
    <%-- Iterar sobre la lista de nombres de artículos obtenida desde ModificarArticulosServlet --%>
    <%
      List<String> nombres = ModificarArticulosServlet.obtenerArticulos();
      for (String nombre : nombres) {
    %>
    <option value="<%= nombre %>"><%= nombre %></option>
    <%-- Fin del bucle --%>
    <% } %>
  </select><br>

  <label for="precio">Precio:</label>
  <input type="text" name="precio" id="precio"><br>

  <label for="peso">Peso:</label>
  <input type="text" name="peso" id="peso"><br>

  <label for="tipo">Tipo:</label>
  <input type="text" name="tipo" id="tipo"><br>

  <input type="submit" value="Modificar">
</form>
</body>
</html>
