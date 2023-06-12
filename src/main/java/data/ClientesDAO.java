package data;

import model.Cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO {
    public List<Cliente> cargarClientesDesdeArchivo(String nombreArchivo) {
        List<Cliente> listaClientes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String nombre = partes[0].trim();
                    String rut = partes[1].trim();
                    String email = partes[2].trim();

                    Cliente cliente = new Cliente(nombre,rut, email);
                    listaClientes.add(cliente);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaClientes;
    }

    public void guardarClientesEnArchivo(List<Cliente> listaClientes, String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Cliente cliente : listaClientes) {
                String linea = cliente.getNombre() + "," + cliente.getRut() + "," + cliente.getCorreo();
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarContenidoArchivoClientes(String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            bw.write("");
            System.out.println("Contenido del archivo eliminado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean agregarCliente(Cliente cliente,String  archivoClientes ) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivoClientes, true))) {
            // Escribir los datos del cliente en el archivo de texto
            writer.println(cliente.getNombre() + "," + cliente.getRut() + "," + cliente.getCorreo());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}