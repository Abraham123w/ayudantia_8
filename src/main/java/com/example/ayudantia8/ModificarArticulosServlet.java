package com.example.ayudantia8;

import com.oracle.wls.shaded.org.apache.xpath.operations.Neg;
import data.ArticuloDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Articulo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ModificarArticulosServlet", value = "/ModificarArticulosServlet")
public class ModificarArticulosServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener parámetros de búsqueda
        String nombre = request.getParameter("nombre").trim();
        String precio = request.getParameter("precio").trim();
        String tipo = request.getParameter("tipo").trim();
        String peso = request.getParameter("peso").trim();


        RequestDispatcher respuesta1 = request.getRequestDispatcher("/exitoModificarArticulo.jsp");
        RequestDispatcher respuesta2= request.getRequestDispatcher("/errorModificarArticulo.jsp");

        boolean exito =   ArticuloDAO.modificarArticulo(nombre,precio,tipo,peso);

        if (exito) {

            respuesta1.forward(request, response);
        } else {

            respuesta2.forward(request, response);
        }
    }





    public static List<String> obtenerArticulos() {
        List<String> listaCategorias = ArticuloDAO.obtenerNombresArticulos();

        return listaCategorias;
    }

    public static String generarTablaLibros(List<Articulo> libros) {
        StringBuilder tabla = new StringBuilder();

        tabla.append("<table>");
        tabla.append("<tr>");
        tabla.append("<th>Nombre</th>");
        tabla.append("<th>Editorial</th>");
        tabla.append("<th>Año</th>");
        tabla.append("<th>Tipo</th>");
        tabla.append("<th>Categoría</th>");
        tabla.append("</tr>");

        for (Articulo libro : libros) {
            String nombre = libro.getNombre().trim();
            String precio = libro.getPrecio().trim();
            String tipo = libro.getTipo().trim();
            String peso = libro.getPeso().trim();


            tabla.append("<tr>");
            tabla.append("<td>").append(nombre).append("</td>");
            tabla.append("<td>").append(precio).append("</td>");
            tabla.append("<td>").append(tipo).append("</td>");
            tabla.append("<td>").append(peso).append("</td>");
            tabla.append("</tr>");
        }

        tabla.append("</table>");

        return tabla.toString();
    }

}
