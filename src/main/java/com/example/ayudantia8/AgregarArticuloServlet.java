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


@WebServlet(name = "AgregarArticuloServlet", value = "/AgregarArticuloServlet")
public class AgregarArticuloServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Obtener los parámetros enviados desde el formulario
        String nombre = request.getParameter("nombre");
        String tipo = request.getParameter("tipo");
        String peso = request.getParameter("peso");
        String precio = request.getParameter("precio");

        RequestDispatcher respuesta1 = request.getRequestDispatcher("/articuloAgregado.jsp");
        RequestDispatcher respuesta2 = request.getRequestDispatcher("/errorAgregarArticulo.jsp");
        RequestDispatcher respuesta3 = request.getRequestDispatcher("/errorAgregarArticuloNumerico.jsp");



        //VALIDAR PRECIO Y PESO QUE SEAN VALORES POSITOVOS Y NUMERICOS
        // Declaración de variables para almacenar el valor numérico del peso y el precio
        double pesoValor;
        double precioValor;

        try {
            // Intentar convertir las cadenas de peso y precio a valores numéricos de tipo double
            pesoValor = Double.parseDouble(peso);
            precioValor = Double.parseDouble(precio);
        } catch (NumberFormatException e) {
            // Si ocurre una excepción, significa que el peso y el precio no son valores numéricos
            // Imprimir un mensaje de error en la respuesta
            PrintWriter out = response.getWriter();
            out.println("Error al agregar el artículo: peso y precio deben ser valores numéricos.");

            // Redirigir a la página de error correspondiente y finalizar el método
            respuesta3.forward(request, response);
            return;
        }

// Validar si el peso y el precio son mayores que cero
        if (pesoValor <= 0 || precioValor <= 0) {
            // Si el peso o el precio son menores o iguales a cero, mostrar un mensaje de error en la respuesta
            PrintWriter out = response.getWriter();
            out.println("Error al agregar el artículo: peso y precio deben ser mayores que cero.");

            // Redirigir a la página de error correspondiente y finalizar el método
            respuesta3.forward(request, response);
            return;
        }




        // Crear instancia de la categoría
        Articulo articulo = new Articulo(nombre,peso,precio,tipo);

        // Lógica para agregar
        ArticuloDAO articuloDAO = new ArticuloDAO();
        boolean exito = articuloDAO.agregarArticulo(articulo);

        if (exito) {
            request.setAttribute("Articulo", articulo);
            respuesta1.forward(request, response);
        } else {
            PrintWriter out = response.getWriter();
            out.println("Error al agregar Articulo");
            respuesta2.forward(request, response);

        }
    }



}
