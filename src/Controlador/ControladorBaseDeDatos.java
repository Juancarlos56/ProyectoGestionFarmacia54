/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.Conexion;
import Conexion.SentenciasCRUD;
import Modelo.Categoria;
import Modelo.Empleado;
import java.util.ArrayList;

/**
 *
 * @author sebas
 */
public class ControladorBaseDeDatos {
    
    
    private Conexion con;
    private SentenciasCRUD s;
    
    public ControladorBaseDeDatos() {
        con = new Conexion();
        
        s = new SentenciasCRUD(); 
         
        //Base de datos local
        con.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        con.setUsername("farmacia");
        con.setPassword("farm_123");
        
        
        
    }
    
    
    /*public void iniciarConexion() {
        // TODO code application logic here
        Conexion con = new Conexion();
        
        SentenciasCRUD s = new SentenciasCRUD(); 
         
        //Base de datos local
        con.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        con.setUsername("farmacia");
        con.setPassword("farm_123");
        
        con.conectar();
        
        
        if(con.getConexion() !=null){
            
            //System.out.println("Base de datos conectada");
            
            s.cargarCategorias(con);
            s.cargarSubCategorias(con);
            s.cargarProductos(con);
            
            s.cargarEmpleados(con);
            
            s.cargarClientes(con);
            //s.cargarDireciones(con);
            
            
            
            s.cargarFacturas(con);
            
            
            //s.cargarFacturas(con);
            
            
            
            
            con.cerrarConexion();
            
        
        }
        
    }*/

    public ArrayList<Categoria> obtenerCategorias() {
    
        ArrayList<Categoria> CategoriasC= new ArrayList();
        con.conectar();
        if(con.getConexion() !=null){
            CategoriasC=s.cargarCategorias(con);
            con.cerrarConexion();
        }
        return CategoriasC;
        
    }
    
    
    public ArrayList<Empleado> obtenerEmpleados(){
        
        ArrayList<Empleado> Empleados= new ArrayList();
        con.conectar();
        if(con.getConexion() !=null){
            Empleados=s.cargarEmpleados(con);
            con.cerrarConexion();
        }
        return Empleados;
        
    }
    
    
    
    
}
