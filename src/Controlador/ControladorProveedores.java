/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Proveedor;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class ControladorProveedores {

     private ArrayList<Proveedor> proveedores;
    
    private ControladorBaseDeDatos cb;

    public ControladorProveedores() {
        cb= new ControladorBaseDeDatos();
        
    }

    public ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(ArrayList<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }
    
    
    
    
    public void cargarProveedores() {
        proveedores = cb.obtenerProveedores();
    }

    public void crearProveedor(String text, String text0, String text1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
