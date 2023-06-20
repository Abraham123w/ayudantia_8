package data;

import model.Cliente;

import java.io.*;

public class ClientesDAO {
    private static String rutaArchivo = "C:/Users/abrah/OneDrive/Escritorio/UNIVERSIAS 2023/OneDrive/TAREAS DE PRAGRAMACION/Ayudantia8/clientes.txt";
    public boolean existeCliente(String nombre, String rut) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datosCliente = linea.split(",");
                String nombreCliente = datosCliente[0].trim();
                String rutCliente = datosCliente[1].trim();

                if (nombreCliente.equalsIgnoreCase(nombre) && rutCliente.equalsIgnoreCase(rut)) {
                    // El cliente ya existe en el archivo
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true; // El cliente no está duplicado en el archivo
    }
    public static boolean agregarCliente(Cliente cliente) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo, true))) {
            // Crear una cadena con los datos del artículo
            String datosCliente = cliente.getNombre() + "," + cliente.getRut() + "," + cliente.getCorreo();

            // Agregar los datos del artículo al archivo de texto
            writer.println(datosCliente);

            return true; // Indicar que se agregó correctamente
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Indicar que ocurrió un error al agregar el artículo
        }
    }
    public static void main(String[] args) {
        Cliente cliente = new Cliente("abraham", "188839886", "pepito@gmail.com");
        agregarCliente(cliente);
    }
}