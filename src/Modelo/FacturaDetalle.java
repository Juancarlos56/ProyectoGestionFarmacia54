/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class FacturaDetalle {
    private int id;
    private int cantidad; 
    private double precio;
    private double subtotal;
    private double descuento;
    private ArrayList<Producto> productos;

    public FacturaDetalle() {
        productos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void addProductos(Producto productos) {
        this.productos.add(productos);
    }
    
    
    public double calcularSubtotal(){
        return 0;
    }
    
}
