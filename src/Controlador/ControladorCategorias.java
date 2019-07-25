/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Categoria;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class ControladorCategorias {
    
    private ArrayList<Categoria> categorias;
    
    private ControladorBaseDeDatos cb;
    
    public ControladorCategorias() {
        cb= new ControladorBaseDeDatos();
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    
    
    
    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }
    
    
            
            
    public void cargarCategorias(){
       
        ArrayList<Categoria> c = cb.obtenerCategorias();
        categorias = c;
        
        
    }

    public void crearProducto(String codigoBarras, String nombre, String precioUnitario, String unidadCompra, String unidadVenta, String iva, String descuento, String categoria, String subcategoria) {
                                  
        
        cb.crearProducto(codigoBarras, nombre, precioUnitario, unidadCompra ,  unidadVenta , iva, descuento,  categoria, subcategoria);
    
    }


    
}
