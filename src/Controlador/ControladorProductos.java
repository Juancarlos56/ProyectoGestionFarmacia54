/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import Modelo.SubCategoria;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class ControladorProductos {

    public ArrayList<Producto> obtenerProductosDeSubCategorias(SubCategoria subCategoria) {
        return subCategoria.getProductos();
    }
    
}
