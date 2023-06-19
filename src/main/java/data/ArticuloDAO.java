package data;

import model.Articulo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArticuloDAO {
    //private static String rutaArchivo;
    private static final String rutaArchivo = "C:/Users/abrah/OneDrive/Escritorio/UNIVERSIAS 2023/OneDrive/TAREAS DE PRAGRAMACION/Ayudantia8/articulos.txt";
    // Constructor que recibe la ruta del archivo de texto


    public boolean agregarArticulo(Articulo articulo) {
        boolean exito = false;

        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo, true))) {
            // Crear una cadena con los datos del artículo
            String datosArticulo = articulo.getNombre() + "," + articulo.getTipo() + "," + articulo.getPeso() + "," + articulo.getPrecio();

            // Agregar los datos del artículo al archivo de texto
            writer.println(datosArticulo);

            exito = true; // Marcar como éxito si se agrega correctamente
        } catch (IOException e) {
            // Manejar errores si ocurre algún problema al escribir en el archivo
            e.printStackTrace();
        }

        return exito;
    }

    public static List<String> obtenerNombresArticulos() {
        List<String> nombresArticulos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length > 0) {
                    String nombreArticulo = campos[0].trim();
                    nombresArticulos.add(nombreArticulo);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nombresArticulos;
    }




    public static boolean modificarArticulo(String nombre, String nuevoPrecio, String nuevoTipo, String nuevoPeso) {
        List<Articulo> articulosOriginales = leerArticulos(); // Implementa este método para leer los datos del archivo
        boolean exito = false;

        // Buscar el artículo por nombre y modificar sus valores
        for (int i = 0; i < articulosOriginales.size(); i++) {
            Articulo articuloOriginal = articulosOriginales.get(i);
            if (articuloOriginal.getNombre().equalsIgnoreCase(nombre)) {
                articuloOriginal.setPrecio(nuevoPrecio);
                articuloOriginal.setTipo(nuevoTipo);
                articuloOriginal.setPeso(nuevoPeso);
                exito = true;
                break;
            }
        }

        // Sobrescribir el archivo con los datos actualizados
        if (exito) {
            escribirArticulos(articulosOriginales); // Implementa este método para escribir los datos en el archivo
        }

        return exito;
    }
    public static List<Articulo> leerArticulos() {
        List<Articulo> articulos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datosArticulo = linea.split(",");
                String nombre = datosArticulo[0].trim();
                String precio = datosArticulo[1].trim();
                String tipo = datosArticulo[2].trim();
                String peso = datosArticulo[3].trim();

                Articulo articulo = new Articulo(nombre, precio, tipo, peso);
                articulos.add(articulo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return articulos;
    }
    public static void escribirArticulos(List<Articulo> articulosOriginales) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Articulo articulo : articulosOriginales) {
                String linea = articulo.getNombre() + "," +
                        articulo.getPeso() + "," +
                        articulo.getPrecio() + "," +
                        articulo.getTipo()
                        ;
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
