/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.Conexion;
import Conexion.SentenciasCRUD;
import Modelo.Categoria;
import Modelo.Cliente;
import Modelo.Empleado;
import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.SubCategoria;
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

    ArrayList<Proveedor> obtenerProveedores() {
        
        ArrayList<Proveedor> proveedores= new ArrayList();
        con.conectar();
        if(con.getConexion() !=null){
            proveedores=s.cargarProveedores(con);
            con.cerrarConexion();
        }
        return proveedores;
        
    }

    void crearProveedor(String text, String text0, String text1) {
        
        con.conectar();
        if(con.getConexion() !=null){
            
            s.crearProveedores(con,text,text0,text1);
            
            con.cerrarConexion();
        }
        
        
    }
    
    public ArrayList<Cliente> obtenerClientes(){
        
        ArrayList<Cliente> clientes = new ArrayList<>();
        con.conectar();
        if(con.getConexion() !=null){
            clientes = s.cargarClientes(con);
            con.cerrarConexion();
        }
        return clientes;
        
    }

    void crearProducto(String codigoBarras, String nombre, String precioUnitario, String unidadCompra, String unidadVenta, String iva, String descuento, String categoria, String subcategoria) {
        
        con.conectar();
        if(con.getConexion() !=null){
            
            s.crearProducto(con,codigoBarras, nombre, precioUnitario, unidadCompra ,  unidadVenta , iva, descuento,  categoria, subcategoria);
            
            con.cerrarConexion();
        }
        
        
    }

    void editarProducto(String ecodigoBarras,String nombre, String precioUnitario, String unidadCompra, String unidadVenta, String iva, String descuento, String categoria, String subcategoria) {
        con.conectar();
        
        if(con.getConexion() !=null){
            
            s.editarProducto(con,ecodigoBarras, nombre, precioUnitario, unidadCompra ,  unidadVenta , iva, descuento,  categoria, subcategoria);
            
            con.cerrarConexion();
        }
    
    }

    void crearCompra(Proveedor proveedorSelec, Categoria categoriaSelec, SubCategoria subCategoriaSelec, Producto productoSelec, String razon, String monto) {
        con.conectar();
        
        if(con.getConexion() !=null){
            
            s.editarProducto(con,proveedorSelec, categoriaSelec, subCategoriaSelec,  productoSelec, razon ,  monto);
            
            con.cerrarConexion();
        }
    
    }

    void crearEmpleado(String nombre, String apellido, String cedula, String cargo) {
        con.conectar();
        
        if(con.getConexion() !=null){
            
            s.crearEmpleado(con,nombre,apellido,cedula,cargo);
            
            con.cerrarConexion();
        }
    }

    void editarEmpleado(String nombre, String apellido, String cedula, String cargo) {
        con.conectar();
        
        if(con.getConexion() !=null){
            
            s.editarEmpleado(con,nombre,apellido,cedula,cargo);
            
            con.cerrarConexion();
        }
        
    }

    void despEmpleado(String nombre, String apellido, String cedula) {
        
        con.conectar();
        
        if(con.getConexion() !=null){
            
            s.despEmpleado(con,nombre,apellido,cedula);
            
            con.cerrarConexion();
        }
        
    }
    
    
    
    
}
