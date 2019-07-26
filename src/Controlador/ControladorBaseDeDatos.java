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

import Modelo.Direccion;

import Modelo.Empleado;
import Modelo.FacturaCabecera;
import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.SubCategoria;
import java.io.IOException;
import java.sql.SQLException;
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
    
    
    public ArrayList<Empleado> obtenerEmpleados() throws IOException{
        
        ArrayList<Empleado> Empleados= new ArrayList<>();
        con.conectar();
        if(con.getConexion() !=null){
            Empleados=s.cargarEmpleados(con);
            con.cerrarConexion();
        }
        return Empleados;
        
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

    public void agregarNuevoCliente(Cliente cliente) {
        con.conectar();
        if(con.getConexion() !=null){
            s.agregarNuevoClientes(con, cliente);
            con.cerrarConexion();
        }
    }


    public void agregarDireccionCliente(String cedula, Direccion direcciones) {
        con.conectar();
        if(con.getConexion() !=null){
            s.agregarNuevaDirecc(con, cedula,direcciones);
            con.cerrarConexion();
        }
    
    
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
            
            s.compraProducto(con, proveedorSelec, categoriaSelec, subCategoriaSelec, productoSelec, razon, monto);
            
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

    void elimProd(Categoria categoriaSelec, SubCategoria subCategoriaSelec, Producto productoSelec) {
        
        con.conectar();
        
        if(con.getConexion() !=null){
            
            s.elimProd(con,categoriaSelec,subCategoriaSelec,productoSelec);
            
            con.cerrarConexion();
        }
    
    
    }

    void agregarFactura(FacturaCabecera factura, String text) {
        

         con.conectar();
        
        if(con.getConexion() !=null){
            
            s.addFactura(con,factura,text);
            
            con.cerrarConexion();
        }
    
    }

    ArrayList<FacturaCabecera> obtenerFacturas() throws IOException {
        
        con.conectar();
        
        if(con.getConexion() !=null){
            
            ArrayList<FacturaCabecera> f= s.obtFacts(con);
            
            con.cerrarConexion();
            
            return f;
        }else{
           return null; 
        }
        
    
    }

    void anular(FacturaCabecera factSelect) throws IOException {
        con.conectar();
        
        if(con.getConexion() !=null){
            
            s.anularF(con,factSelect);
            
            con.cerrarConexion();
            
        }else{

        }
    }

    String getnumFac() throws SQLException {
        con.conectar();
        
        if(con.getConexion() !=null){
            
            String num = s.anularF(con);
            
            con.cerrarConexion();
            return num;
        }else{
            return null;
        }
    }


}
