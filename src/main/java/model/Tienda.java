package model;

import java.util.ArrayList;

public class Tienda {

    private ArrayList<Articulo> listaProductos;
    private ArrayList<Cliente> listaClientes;

    public Tienda(ArrayList<Articulo> listaProductos, ArrayList<Cliente> listaClientes) {
        this.listaProductos = listaProductos;
        this.listaClientes = listaClientes;
    }

    public ArrayList<Articulo> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Articulo> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }


}
