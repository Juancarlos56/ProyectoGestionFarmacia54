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
import java.util.List;

/**
 *
 * @author Carlos
 */
public class ControladorSubcategorias {
    private ArrayList<SubCategoria> subcategorias;
    private ControladorProductos productos;

    public ControladorSubcategorias() {
        subcategorias = new ArrayList<>();
        productos = new ControladorProductos();
    }
    
    

    public ArrayList<SubCategoria> listarSubCategoriasEspecifica(Categoria categoria) {  
        return categoria.getSubcategorias();
    }
    
    public ArrayList<Producto> obtenerProductosSubCategoria(SubCategoria subCat){
        return productos.obtenerProductosDeSubCategorias(subCat);
    }
    
}
