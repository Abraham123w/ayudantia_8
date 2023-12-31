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
             String lineaAntigua=(articuloOriginal.getNombre()+articuloOriginal.getPrecio()+articuloOriginal.getTipo()+articuloOriginal.getPeso());
             String lineaNueva=(nombre+nuevoPrecio+nuevoTipo+nuevoPeso);
                //String rutaArchivo, String lineaAntigua, String lineaNueva
                reemplazarLineas(rutaArchivo,lineaAntigua,lineaNueva);

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
                        articulo.getTipo() + "," +
                        articulo.getPeso() +   "," +
                        articulo.getPrecio()
                        ;
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Articulo> buscarArticulos(String nombre, String precio, String tipo, String peso) {
        List<Articulo> articulosEncontrados = new ArrayList<>();
        List<Articulo> articulos = leerArticulos(); // Suponiendo que tienes un método para leer los artículos

        for (Articulo articulo : articulos) {
            if (articulo.getNombre().trim().equalsIgnoreCase(nombre) &&
                    articulo.getPrecio().trim().equalsIgnoreCase(precio) &&
                    articulo.getTipo().trim().equalsIgnoreCase(tipo) &&
                    articulo.getPeso().trim().equalsIgnoreCase(peso)) {
                articulosEncontrados.add(articulo);
            }
        }

        return articulosEncontrados;
    }
    public static void reemplazarLineas(String rutaArchivo, String lineaAntigua, String lineaNueva) {
        try {
            // Crear un archivo temporal para almacenar los cambios
            File archivoTemporal = new File("temp.txt");

            // Abrir el archivo de origen para lectura
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));

            // Crear un escritor para el archivo temporal
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemporal));

            String linea;

            // Leer el archivo línea por línea
            while ((linea = br.readLine()) != null) {
                // Reemplazar la línea antigua por la línea nueva
                if (linea.equals(lineaAntigua)) {
                    linea = lineaNueva;
                }

                // Escribir la línea en el archivo temporal
                bw.write(linea);
                bw.newLine();
            }

            // Cerrar los flujos de lectura y escritura
            br.close();
            bw.close();

            // Eliminar el archivo original
            File archivoOriginal = new File(rutaArchivo);
            archivoOriginal.delete();

            // Renombrar el archivo temporal con el nombre del archivo original
            archivoTemporal.renameTo(archivoOriginal);

            System.out.println("Reemplazo de líneas completado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
