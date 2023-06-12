package com.example.ayudantia8;

import data.ArticulosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ArticuloServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los parámetros del formulario
        String nombreArchivo = "C:/Users/abrah/OneDrive/Escritorio/UNIVERSIAS 2023/OneDrive/TAREAS DE PRAGRAMACION/Ayudantia8/articulos.txt";
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String peso = request.getParameter("peso");
        Double precio = Double.valueOf(request.getParameter("precio"));
        String tipo = request.getParameter("tipo");

        // Lógica para modificar el artículo por ID
        ArticulosDAO articuloDAO = new ArticulosDAO(); // Supongamos que tienes una clase ArticuloDAO para manejar la interacción con la base de datos o la lista de artículos
        boolean exito = articuloDAO.modificarArticuloPorId(nombreArchivo, id, nombre, peso, precio, tipo);

        if (exito) {
            response.sendRedirect(request.getContextPath() + "/modificacionExitosaArticulo.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/modificacionErroneaArticulo.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nombreArchivo = "C:/Users/abrah/OneDrive/Escritorio/UNIVERSIAS 2023/OneDrive/TAREAS DE PRAGRAMACION/Ayudantia8/articulos.txt";
        String action = request.getParameter("action");

        if (action.equals("agregarArticulo")) {
            // Obtener los parámetros del formulario
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            double peso = Double.parseDouble(request.getParameter("peso"));
            double precio = Double.parseDouble(request.getParameter("precio"));
            String tipo = request.getParameter("tipo");

            // Lógica para agregar el artículo

            ArticulosDAO articuloDAO = new ArticulosDAO();
            boolean exito = articuloDAO.agregarProducto(nombreArchivo, id, nombre, peso, precio, tipo);

            if (exito) {
                response.sendRedirect(request.getContextPath() + "/agregarProductoExitoso.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/agregarProductoErroneo.jsp");
            }
        } else if (action.equals("buscarArticulo")) {
            String idBusqueda = request.getParameter("id");
            ArticulosDAO articuloDAO = new ArticulosDAO();
            String articuloEncontrado = String.valueOf(articuloDAO.buscarArticuloPorId(idBusqueda, nombreArchivo));

            if (articuloEncontrado != null) {
                response.getWriter().write("Artículo encontrado: " + articuloEncontrado);
            } else {
                response.getWriter().write("El artículo no se encontró.");
            }
        }
    }
}
