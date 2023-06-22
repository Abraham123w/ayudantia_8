package com.example.ayudantia8;

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

import static com.example.ayudantia8.ModificarArticulosServlet.generarTablaLibros;

@WebServlet(name = "BuscarArticuloServlet", value = "/BuscarArticuloServlet")
public class BuscarArticuloServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Obtener los parámetros enviados desde el formulario
        String nombre = request.getParameter("nombre").trim();
        String tipo = request.getParameter("tipo").trim();
        String peso = request.getParameter("peso").trim();
        String precio = request.getParameter("precio").trim();

        RequestDispatcher respuesta1 = request.getRequestDispatcher("/articuloEncontrado.jsp");
        RequestDispatcher respuesta2 = request.getRequestDispatcher("/errorBuscarArticulo.jsp");
        RequestDispatcher respuesta3 = request.getRequestDispatcher("/errorBuscarArticuloNumerico.jsp");

        //VALIDAR PRECIO Y PESO QUE SEAN VALORES POSITIVOS Y NUMÉRICOS
        // Declaración de variables para almacenar el valor numérico del peso y el precio
        double pesoValor;
        double precioValor;

        try {
            // Intentar convertir las cadenas de peso y precio a valores numéricos de tipo double
            pesoValor = Double.parseDouble(peso);
            precioValor = Double.parseDouble(precio);

            if (pesoValor <= 0 || precioValor <= 0) {
                // Si el peso o el precio no son valores positivos, mostrar mensaje de error
                PrintWriter out = response.getWriter();
                out.println("Error al agregar el artículo: peso y precio deben ser valores numéricos positivos.");

                // Redirigir a la página de error correspondiente y finalizar el método
                respuesta3.forward(request, response);
                return;
            }
        } catch (NumberFormatException e) {
            // Si ocurre una excepción, significa que el peso y el precio no son valores numéricos
            // Imprimir un mensaje de error en la respuesta
            PrintWriter out = response.getWriter();
            out.println("Error al agregar el artículo: peso y precio deben ser valores numéricos.");

            // Redirigir a la página de error correspondiente y finalizar el método
            respuesta3.forward(request, response);
            return;
        }

        // Crear instancia de la categoría
        Articulo articulo = new Articulo(nombre, peso, precio, tipo);

        // Lógica para agregar
        ArticuloDAO articuloDAO = new ArticuloDAO();
        boolean exito = articuloDAO.agregarArticulo(articulo);
       List<Articulo> articulosEncontrados = articuloDAO.buscarArticulos(nombre,precio,tipo,peso);
      /*  List<Articulo> articulosEncontrados = new ArrayList<>();
        articulosEncontrados.add(articulo);*/

        if (exito) {
            String tablaArticulos = generarTablaLibros(articulosEncontrados);
            request.setAttribute("tablaArticulos", tablaArticulos);
            respuesta1.forward(request, response);
        } else {
            respuesta2.forward(request, response);
        }
    }


}
