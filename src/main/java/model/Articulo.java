package model;

public class Articulo {

    private  String nombre;
    private String peso;
    private Double precio;
    private String tipo;
    private  int id;

    public Articulo(String nombre, String peso, Double precio, String tipo, int id) {
        this.nombre = nombre;
        this.peso = peso;
        this.precio = precio;
        this.tipo = tipo;
        this.id=id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "nombre='" + nombre + '\'' +
                ", peso='" + peso + '\'' +
                ", precio=" + precio +
                ", tipo='" + tipo + '\'' +
                ", id=" + id +
                '}';
    }
}
