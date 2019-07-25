/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Categoria;
import Modelo.Producto;
import Modelo.SubCategoria;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class ControladorCategorias {
    
    ControladorSubcategorias subCategoria;
    ArrayList<Categoria> categorias;
    ArrayList<SubCategoria> subCategorias;

    public ControladorCategorias() {
        subCategoria = new ControladorSubcategorias();
        categorias = new  ArrayList<>();
        subCategorias = new ArrayList<>();
    }
    
    
    
    //Metodo para que me devuelva la lista de Categorias que existen
    public ArrayList<Categoria> obtenerCategorias(){
        
        //Esto es para prueba
        Categoria c = new Categoria();
        c.setId(0);
        c.setNombreCategoria("Pañales");
        SubCategoria s = new SubCategoria();
        s.setId(0);
        s.setNombreSubCategoria("Pañales para niño");
        Producto p = new Producto();
        p.setCodigoBarras("1");
        p.setEstado('H');
        p.setIva('S');
        p.setNombre("Pañales huggies");
        //p.setOrigen("Si".toCharArray());
        p.setPctDescuento(56);
        p.setPrecioUnitario(6.90);
        p.setStock(30);
        p.setUnidadCompra("Paquetes");
        p.setUnidadVenta("unidades");
        s.addProductos(p);
        c.addSubcategorias(s);
        categorias.add(c);
        
        //Esto es para prueba
        Categoria cd = new Categoria();
        cd.setId(1);
        cd.setNombreCategoria("Tetas");
        SubCategoria sd = new SubCategoria();
        sd.setId(0);
        sd.setNombreSubCategoria("tetas para niño");
        Producto pd = new Producto();
        pd.setCodigoBarras("2");
        pd.setEstado('H');
        pd.setIva('S');
        pd.setNombre("Pañales huggies");
        //pd.setOrigen("Si".toCharArray());
        pd.setPctDescuento(66);
        pd.setPrecioUnitario(5.90);
        pd.setStock(30);
        pd.setUnidadCompra("Paquetes");
        pd.setUnidadVenta("unidades");
        sd.addProductos(pd);
        cd.addSubcategorias(sd);
        categorias.add(cd);
        
        
        return categorias;
    } 
    
    //Metodo para devolver una SubCategoria en Especifico
    public ArrayList<SubCategoria> obtenerSubCategorias(int id, String nombreCat){
        //Esto es Prueba
        Categoria cat = buscarCategoria(id);
        return subCategoria.listarSubCategoriasEspecifica(cat);
    }

    //Buscar una Categoria por el ID
    public Categoria buscarCategoria(int id) {
        
        //Esto es para prueba
        for (int i = 0; i < categorias.size(); i++) {
            if(id == categorias.get(i).getId()){
            return categorias.get(i);
            }
        }
       
        return null;
    }
    
    
}
