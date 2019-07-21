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
public class Producto {
    private String codigoBarras;
    private String nombre;
    private String unidadCompra;
    private String unidadVenta; 
    private ArrayList<FacturaCompra> compras;
    private char iva;
    private int stock;
    private double pctDescuento; 
    private double precioUnitario;
    private char[] origen;
    private char estado;

    public Producto() {
        compras = new ArrayList<>();
        origen = new char[2];
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidadCompra() {
        return unidadCompra;
    }

    public void setUnidadCompra(String unidadCompra) {
        this.unidadCompra = unidadCompra;
    }

    public char getIva() {
        return iva;
    }

    public void setIva(char iva) {
        this.iva = iva;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPctDescuento() {
        return pctDescuento;
    }

    public void setPctDescuento(double pctDescuento) {
        this.pctDescuento = pctDescuento;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    
    public String getUnidadVenta() {
        return unidadVenta;
    }

    public void setUnidadVenta(String unidadVenta) {
        this.unidadVenta = unidadVenta;
    }

    public ArrayList<FacturaCompra> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<FacturaCompra> compras) {
        this.compras = compras;
    }

    public char[] getOrigen() {
        return origen;
    }

    public void setOrigen(char[] origen) {
        this.origen = origen;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
    
}
