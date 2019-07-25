/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Conexion.SentenciasCRUD;
import Modelo.Categoria;
import Modelo.Producto;
import Modelo.SubCategoria;
import java.util.ArrayList;


/**
 *
 * @author Carlos
 */
public class ControladorProductos {




// Bueno.. Yo no utilizo esto Asi que GG Juan (Lo voy a dejar aqui por si acaso)
    private ArrayList<Categoria> categorias;
    private SentenciasCRUD st;

    public ControladorProductos() {
       categorias = new ArrayList<>();
       
    }
    
    
    public ArrayList<Producto> obtenerProductosDeSubCategorias(SubCategoria subCategoria) {
        return subCategoria.getProductos();
    }
    
    public Producto buscarProductoPorCodBarras(String codBarras ){
        Producto p = new Producto();
        p.setCodigoBarras(codBarras);
        p.setEstado('H');
        p.setIva('S');
        p.setNombre("Alcancecer");
        p.setOrigen("Si".toCharArray());
        p.setPctDescuento(55);
        p.setPrecioUnitario(0.5);
        p.setStock(10);
        p.setUnidadCompra("Cajas");
        p.setUnidadVenta("tabletas");
        
        return p;
    }
    
    public Producto buscarProductoPorNombre(String nombre){
        Producto p = new Producto();
        p.setCodigoBarras("6");
        p.setEstado('H');
        p.setIva('S');
        p.setNombre(nombre);
        p.setOrigen("Si".toCharArray());
        p.setPctDescuento(55);
        p.setPrecioUnitario(0.5);
        p.setStock(10);
        p.setUnidadCompra("Cajas");
        p.setUnidadVenta("tabletas");
        return p;
    }

    
}
