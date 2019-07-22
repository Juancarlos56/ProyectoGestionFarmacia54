/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

//import Controlador.ClasedeAlmacenamientoTemporal;
import Controlador.ControladorBaseDeDatos;
import Modelo.Categoria;
import Modelo.Cliente;
import Modelo.Empleado;
import Modelo.FacturaCabecera;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    
    //Hay
    public static ArrayList<Categoria> Categorias= new ArrayList();
    
    public static ArrayList<Empleado> Empleados= new ArrayList();
    
    public static ArrayList<Cliente> Clientes= new ArrayList();
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.println("Hola mundo Juan rama");
        
        //Lugar donde guardar Categorias
       
        
        
        
        
        ControladorBaseDeDatos  cb= new ControladorBaseDeDatos();
        cb.iniciarConexion();
        
        
        
        
        
        VentanaLogin v = new VentanaLogin();
        v.setVisible(true);
        
        //System.out.println(
        //Categorias.get(0).getSubcategorias().get(0).getProductos().get(0).getNombre());
        
        
        //ClasedeAlmacenamientoTemporal.CCP();
        //ClasedeAlmacenamientoTemporal.CLP();
             
    }
    
}
