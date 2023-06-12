package com.example.ayudantia8;

import data.ClientesDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;

import java.io.IOException;

public class ClienteServlet extends HttpServlet {

    private ClientesDAO clientesDAO;

    public void init() throws ServletException {
        // Inicializar el DAO (por ejemplo, establecer la conexión a la base de datos)
        clientesDAO = new ClientesDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los parámetros del formulario

        String archivoClientes="C:/Users/abrah/OneDrive/Escritorio/UNIVERSIAS 2023/OneDrive/TAREAS DE PRAGRAMACION/Ayudantia8/clientes.txt";
        String nombre = request.getParameter("nombre");
        String rut = request.getParameter("rut");
        String correo = request.getParameter("correo");

        // Crear un objeto Cliente con los datos recibidos
        Cliente cliente = new Cliente(nombre, rut, correo);

        // Lógica para agregar el cliente utilizando el DAO
        boolean exito = clientesDAO.agregarCliente(cliente,archivoClientes );

        if (exito) {
            response.sendRedirect(request.getContextPath() + "/agregarClienteExitoso.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/agregarClienteErroneo.jsp");
        }
    }


}
