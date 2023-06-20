package com.example.ayudantia8;

import data.ArticuloDAO;
import data.ClientesDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Articulo;
import model.Cliente;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Validadores.ValidarCorreo.validarCorreo;
import static Validadores.ValidarRut.validarRut;


@WebServlet(name = "AgregarClienteServlet", value = "/AgregarClienteServlet")
public class AgregarClienteServlet extends HttpServlet {
    private ClientesDAO clienteDAO; // Suponiendo que tienes una clase ClienteDAO implementada

    public void init() {
        // Inicializar el ClienteDAO en el método init()
        clienteDAO = new ClientesDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los parámetros enviados desde el formulario
        String nombre = request.getParameter("nombre");
        String rut = request.getParameter("rut");
        String correo = request.getParameter("correo");

        RequestDispatcher respuesta1 = request.getRequestDispatcher("/clienteAgregado.jsp");
        RequestDispatcher respuesta2 = request.getRequestDispatcher("/errorAgregarCliente.jsp");

        Cliente cliente = new Cliente(nombre, rut, correo);

        boolean correoValido = validarCorreo(correo);
       boolean rutValido = validarRut(rut);
        boolean clienteDuplicado = clienteDAO.existeCliente(nombre, rut);

      //  boolean correoValido = true;
       //boolean rutValido = true;
       // boolean clienteDuplicado = true;


        if (correoValido && rutValido && clienteDuplicado) {
            ClientesDAO.agregarCliente(cliente);
            request.setAttribute("cliente", cliente);
            respuesta1.forward(request, response);
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("Error al agregar el cliente");
            respuesta2.forward(request, response);
        }
    }






}
