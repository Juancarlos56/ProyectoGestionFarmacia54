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

    private ArrayList<Categoria> categoriasProductos = new ArrayList<>();
    private ControladorBaseDeDatos cb;

    public ControladorProductos() {
       cb = new ControladorBaseDeDatos();
       categoriasProductos = cb.obtenerCategorias();
       
    }
    
    
    public ArrayList<Producto> obtenerProductosDeSubCategorias(SubCategoria subCategoria) {
        return subCategoria.getProductos();
    }
    
    public Producto buscarProductoPorCodBarras(String codBarras ){
        for (int i = 0; i < categoriasProductos.size(); i++) {
            for (int j = 0; j < categoriasProductos.get(i).getSubcategorias().size(); j++) {
                for (int k = 0; k < categoriasProductos.get(i).getSubcategorias().get(j).getProductos().size(); k++) {
                    if (categoriasProductos.get(i).getSubcategorias().get(j).getProductos().get(k).getCodigoBarras().equals(codBarras)) {
                        return categoriasProductos.get(i).getSubcategorias().get(j).getProductos().get(k);
                    }
                }
                
            }
        }
        return null;
    }
    
    public Producto buscarProductoPorNombre(String nombre){
        
        
         for (int i = 0; i < categoriasProductos.size(); i++) {
            for (int j = 0; j < categoriasProductos.get(i).getSubcategorias().size(); j++) {
                for (int k = 0; k < categoriasProductos.get(i).getSubcategorias().get(j).getProductos().size(); k++) {
                    if ((categoriasProductos.get(i).getSubcategorias().get(j).getProductos().get(k).getNombre().compareTo(nombre)) == 0) {
                        return categoriasProductos.get(i).getSubcategorias().get(j).getProductos().get(k);
                    }
                }
                
            }
        }
        return null;
    }
    
    public boolean verificarStockProduto(Producto p, int cantidadCompra){
        if (p.getStock() - cantidadCompra > 0 ) {
            return true;
        }
        return false;
    }

    public ArrayList<Categoria> getCategoriasProductos() {
        return categoriasProductos;
    }

    public void setCategoriasProductos(ArrayList<Categoria> categoriasProductos) {
        this.categoriasProductos = categoriasProductos;
    }


    
}
