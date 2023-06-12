package data;

import model.Articulo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArticulosDAO {

    public static List<Articulo> cargarProductosDesdeArchivo(String nombreArchivo) {
        List<Articulo> listaProductos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    String nombre = partes[0].trim();
                    String peso = partes[1].trim();
                    double precio = Double.parseDouble(partes[1].trim());
                    String tipo = partes[3].trim();
                    int id = Integer.parseInt(partes[4].trim());
                    Articulo producto = new Articulo(nombre, peso, precio, tipo, id);
                    listaProductos.add(producto);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaProductos;
    }


    public void guardarProductosEnArchivo(List<Articulo> listaProductos, String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Articulo producto : listaProductos) {
                String linea = producto.getNombre() + "," + producto.getPeso() + "," + producto.getPrecio()  +","+producto.getTipo() +","+ producto.getId();
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void eliminarContenidoArchivoArticulos(String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            bw.write("");
            System.out.println("Contenido del archivo eliminado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean modificarArticuloPorId(String nombreArchivo,int id, String nombre, String peso, double precio, String tipo) {
        // Lógica para modificar el artículo por ID
        // Supongamos que tienes una lista de artículos llamada "listaArticulos" donde se almacenan los objetos de tipo Articulo

        for (Articulo articulo : cargarProductosDesdeArchivo(nombreArchivo)) {
            if (articulo.getId() == id) {
                // Se encontró el artículo con el ID especificado, se procede a modificar sus atributos
                articulo.setNombre(nombre);
                articulo.setPeso(peso);
                articulo.setPrecio(precio);
                articulo.setTipo(tipo);
                return true; // Indicar que se realizó la modificación exitosamente
            }
        }

        return false; // Indicar que no se encontró el artículo con el ID especificado

    }

    public static boolean agregarProducto(String nombreArchivo, int id, String nombre, double peso, double precio, String tipo) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nombreArchivo, true))) {
            pw.println(id + "," + nombre + "," + peso + "," + precio + "," + tipo);
            System.out.println("Producto agregado correctamente.");
            return true;
        } catch (IOException e) {
            System.out.println("Error al agregar el producto: " + e.getMessage());
            return false;
        }
    }

    /**
     * Este método busca un artículo en un archivo de texto por su ID. El método toma dos parámetros:
     * idBusqueda, que es el ID del artículo que se desea buscar, y nombreArchivo, que es la ruta del archivo que
     * contiene los datos de los artículos. El método devuelve una cadena que representa la línea completa del
     * artículo en el archivo de texto, si se encuentra el artículo con el ID buscado, o null si no se encuentra
     * el artículo.
     */
    public static Articulo buscarArticuloPorId(String idBusqueda, String nombreArchivo) {
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                String idArticulo = campos[0].trim();
                if (idArticulo.equals(idBusqueda)) {
                    return new Articulo(campos[1], campos[2], Double.parseDouble(campos[3]), campos[4], Integer.parseInt(campos[0]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Imprime el rastro de pila del error en caso de que ocurra una excepción de entrada/salida.
        }
        return null; // Devuelve nulo si no se encuentra el artículo.
    }
}

