/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Modelo.Categoria;
import Modelo.Cliente;
import Modelo.Direccion;
import Modelo.Empleado;
import Modelo.FacturaCabecera;
import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.SubCategoria;
//import static Vista.Principal.Categorias;
//import static Vista.Principal.Clientes;
//import static Vista.Principal.Empleados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



/**
 *
 * @author Carlos
 */
public class SentenciasCRUD {
    private ResultSet resultado = null;
    private ResultSet resultadobusc = null;
    private PreparedStatement sentencia = null;
    private PreparedStatement busqueda = null;
    
    ArrayList<Categoria> Categorias= new ArrayList();
    
    ArrayList<Empleado> Empleados= new ArrayList();
    
    ArrayList<Cliente> Clientes= new ArrayList();
    
    ArrayList<Proveedor> proveedores= new ArrayList();
    
    
    
    
    public void cargarProductos(Conexion con) {
        try{                                                    //aqui van las consultas
            sentencia = con.getConexion().prepareStatement("Select * " +
                                                            "from PFC_PRODUCTOS");
            
            resultado = sentencia.executeQuery();
            
            // Se Presenta el resultado
            
            while (resultado.next()){
                
                Producto p = new Producto();
                
                p.setCodigoBarras(resultado.getString("PRO_CODIGO_BARRAS"));
                p.setNombre(resultado.getString("PRO_NOMBRE"));
                p.setPrecioUnitario(resultado.getDouble("PRO_PRECIO_UNITARIO"));
                p.setPctDescuento(resultado.getDouble("PRO_PORCENTAJE_DESCUENTO"));
                p.setUnidadCompra(resultado.getString("PRO_UNIDAD_COMPRA"));
                p.setUnidadVenta(resultado.getString("PRO_UNIDAD_VENTA"));
                p.setOrigen(resultado.getString("PRO_ORIGEN").charAt(0));
                p.setIva(resultado.getNString("PRO_IVA").charAt(0));
                p.setStock(resultado.getInt("PRO_STOCK"));
                p.setEstado(resultado.getNString("PRO_ESTADO").charAt(0));
                
                
                for (Categoria Categoria : Categorias) {
                    
                    
                    for (SubCategoria subcategoria : Categoria.getSubcategorias()) {
                        
                        if (subcategoria.getId() == resultado.getInt("CSU_ID")){
                        
                            subcategoria.addProductos(p);
                        }    
                    }   
                } 
                
            }
            
            
            
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    
    
    public ResultSet getResultado() {
        return resultado;
    }

    public void setResultado(ResultSet reseultado) {
        this.resultado = reseultado;
    }

    public PreparedStatement getSentencia() {
        return sentencia;
    }

    public void setSentencia(PreparedStatement sentencia) {
        this.sentencia = sentencia;
    }

    
    
    
    
    
    public ArrayList<Categoria> cargarCategorias(Conexion con) {
        
        
        
        try{                                                    //aqui van las consultas
            sentencia = con.getConexion().prepareStatement("Select * " +
                                                            "from PFC_CATEGORIAS");
            
            
            
            resultado = sentencia.executeQuery();
            
            // Se Presenta el resultado
            
            while (resultado.next()){
                
                Categoria c = new Categoria();
                
                c.setId(resultado.getInt("CAT_ID"));
                c.setNombreCategoria(resultado.getString("CAT_NOMBRE"));
                
                Categorias.add(c);
                
                
                
            }
            
            cargarSubCategorias(con);
            cargarProductos(con);
            
            
            
            return Categorias; 
            
        }catch(SQLException e){
            e.printStackTrace();
            return null; 
        }   
    }
    
    
    public void cargarSubCategorias(Conexion con) {
        
        
        
        try{                                                    //aqui van las consultas
            sentencia = con.getConexion().prepareStatement("select * from PFC_SUB_CATEGORIAS");

            resultado = sentencia.executeQuery();
            
            // Se Presenta el resultado
            
            while (resultado.next()){
                
                SubCategoria c = new SubCategoria();
                
                c.setId(resultado.getInt("CSU_ID"));
                c.setNombreSubCategoria(resultado.getString("CSU_NOMBRE"));
                
                for (Categoria Categoria : Categorias) {
                    
                    if (Categoria.getId() == resultado.getInt("CAT_ID")){
                        
                        Categoria.addSubcategorias(c);
                        
                    }
                } 
            } 
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        
    }


    public  ArrayList<Empleado>cargarEmpleados(Conexion con) {
        
        try{                                                    //aqui van las consultas
            sentencia = con.getConexion().prepareStatement("select * from PFC_EMPLEADOS");
            
            
            
            resultado = sentencia.executeQuery();
            
            // Se Presenta el resultado
            
            while (resultado.next()){
                
                Empleado e = new Empleado();
                
                e.setId(resultado.getInt("EMP_ID"));
                e.setCargo((resultado.getString("EMP_CARGO").charAt(0)));
                
                e.setNombre(resultado.getString("EMP_NOMBRE"));
                e.setApellido(resultado.getString("EMP_APELLIDO"));
                e.setCedula(resultado.getString("EMP_CEDULA"));
                e.setEstadoEmpleado((resultado.getString("EMP_ESTADO").charAt(0)));
                
                
                Empleados.add(e);
                
                
                
            }
            
            
            return Empleados;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }   
        
        
    }
    
    
    public void cargarClientes(Conexion con) {
        
        try{                                                    //aqui van las consultas
            sentencia = con.getConexion().prepareStatement("select * from PFC_CLIENTES");
            
            
            
            resultado = sentencia.executeQuery();
            
            // Se Presenta el resultado
            
            while (resultado.next()){
                
                Cliente c = new Cliente();
                
                c.setId(resultado.getInt("CLI_ID"));
                c.setCedula(resultado.getString("CLI_CEDULA"));
                c.setNombre(resultado.getString("CLI_NOMBRE"));
                c.setApellido(resultado.getString("CLI_APELLIDO"));
                c.setTlfConvencional(resultado.getString("CLI_TELEFONO_CONVENCIONAL"));
                c.setTlfCelular(resultado.getString("CLI_TELEFONO_CELULAR"));
                
                Clientes.add(c);    
            }
        }catch(SQLException e){
            e.printStackTrace();
        }   
        
    }    

    /*public void cargarDireciones(Conexion con) {
        
        try{                                                    //aqui van las consultas
            sentencia = con.getConexion().prepareStatement("select DIR_ID, DIR_CALLE_PRINCIPAL,DIR_CALLE_SECUNDARIA,CLI_ID,CUI_NOMBRE\n" +
                                                                "from PFC_DIRECCIONES, PFC_CIUDADES\n" +
                                                                "where PFC_CIUDADES.CUI_ID = PFC_DIRECCIONES.CUI_ID;");

            resultado = sentencia.executeQuery();
            
            // Se Presenta el resultado
            
            while (resultado.next()){
                
                Direccion d = new Direccion();
                
                d.setId(resultado.getInt("DIR_ID"));
                d.setCiudadNombre( resultado.getString("CUI_NOMBRE") );
                d.setCallePrincipal( resultado.getString("DIR_CALLE_PRINCIPAL") );
                d.setCalleSecundaria( resultado.getString("DIR_CALLE_SECUNDARIA") );
                
                for (Cliente Cliente : Clientes) {
                    
                    if (Cliente.getId() == resultado.getInt("CLI_ID")) {
                     
                        Cliente.addDirecciones(d);
                        
                    }
                }
                
                
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }   
        
        
    }*/
    
    public void cargarFacturas(Conexion con) {
        
        try{                                                    //aqui van las consultas
            sentencia = con.getConexion().prepareStatement("select * from PFC_FACTURAS_CABECERA");
            
            
            
            resultado = sentencia.executeQuery();
            
            // Se Presenta el resultado
            
            while (resultado.next()){
                
                FacturaCabecera f = new FacturaCabecera();
                f.setId(resultado.getInt("FCA_ID"));
                f.setFechaVenta(resultado.getDate("FCA_FECHA_VENTA"));
                f.setSubtotal(resultado.getDouble("FCA_SUBTOTAL"));
                f.setDescuento(resultado.getDouble("FCA_DESCUENTO"));
                f.setAdicionalEnvio(resultado.getDouble("FCA_ADICIONAL_ENVIO"));
                f.setValorTotal(resultado.getDouble("FCA_VALOR_TOTAL"));
                f.setEstado(resultado.getString("FCA_ESTADO").charAt(0));
                //f.setAvisoEnvio(0);
                //Sets de objetos 
                //Cliente
                
                for (Cliente Cliente : Clientes) {
                    if(Cliente.getId() == resultado.getInt("CLI_ID")){
                        f.setCliente(Cliente);
                        
                        
                        /*for (Direccion direccione : Cliente.getDirecciones()) {
                            
                            if(direccione.getId() == resultado.getInt("DIR_ID")){
                                
                                f.;
                                
                            }
                            
                            
                        }*/  
                    
                    }
                }
                
                for (Empleado Empleado : Empleados) {
                    if(Empleado.getId() == resultado.getInt("EMP_ID")){
                        f.setEmpleado(Empleado);
                        
                        
                        Empleado.addFacturas(f);
                    }
                    
                }
 
            }
        }catch(SQLException e){
            e.printStackTrace();
        }   
        
        
    }

    
    
    
    public ArrayList<Proveedor> cargarProveedores(Conexion con) {
        
        
        try{                                                    //aqui van las consultas
            sentencia = con.getConexion().prepareStatement("select * from PFC_PROVEEDORES");

            resultado = sentencia.executeQuery();
            
            // Se Presenta el resultado
            
            while (resultado.next()){
                
                Proveedor c = new Proveedor();
                
                String nombre = resultado.getString("PRV_NOMBRE");
                
                String[] nombreS = nombre.split(" ");
                
                c.setNombre(nombreS[0]);
                c.setApellido(nombreS[1]);
                
                c.setRuc(resultado.getString("PRV_RUC"));
                
                
                proveedores.add(c);
                
                
                
            }
            
            
            
            return proveedores; 
            
        }catch(SQLException e){
            e.printStackTrace();
            return null; 
        }   
        
        
    
        

    }

    public void crearProveedores(Conexion con, String text, String text0, String text1) {
        
        try{
            
            String nombreApellido = text +" "+text0;
            
            sentencia= con.getConexion().prepareStatement("INSERT INTO PFC_PROVEEDORES VALUES(prv_id_seq.NEXTVAL, ?,?)");
            
            sentencia.setString(1, nombreApellido);
            sentencia.setString(2, text1);
            
            
            //Ejecutar INSERT
            
            sentencia.executeUpdate();
            
            
            con.getConexion().commit();

            
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
    
    
    
    
    
    }

    public void crearProducto(Conexion con, String codigoBarras, String nombre, String precioUnitario, String unidadCompra, String unidadVenta, String iva, String descuento, String categoria, String subcategoria) {
        
        try{
            
            busqueda = con.getConexion().prepareStatement("select s.CSU_ID\n" +
                                                            "from PFC_SUB_CATEGORIAS s,PFC_CATEGORIAS c\n" +
                                                            "where s.CAT_ID = c.CAT_ID\n" +
                                                            "and s.CSU_NOMBRE = ? \n" +
                                                            "and c.CAT_NOMBRE = ?");
            busqueda.setString(1, subcategoria);
            busqueda.setString(2, categoria);
            
            resultadobusc = busqueda.executeQuery();
            int subC=0;
            
            while (resultadobusc.next()){

                System.out.println(subC);
            
            }
            
            
            
            sentencia= con.getConexion().prepareStatement("INSERT INTO PFC_PRODUCTOS VALUES(? , ? , ? , ?, ?, ?, 'E', ? , 0, 'A', ?)");
            
            sentencia.setString(1, codigoBarras);
            sentencia.setString(2, nombre);
            sentencia.setDouble(3, Double.parseDouble(precioUnitario));
            sentencia.setDouble(4, Double.parseDouble(descuento));
            sentencia.setString(5, unidadCompra);
            sentencia.setString(6, unidadVenta);
            sentencia.setString(7, iva);
            sentencia.setInt(8, subC);
            
            
            
            
            
            //Ejecutar INSERT
            
            sentencia.executeUpdate();
            
            
            con.getConexion().commit();

            
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        
        
        
    }

    public void editarProducto(Conexion con,String eCodigoBarras, String nombre, String precioUnitario, String unidadCompra, String unidadVenta, String iva, String descuento, String categoria, String subcategoria) {
        
        try{
            
            busqueda = con.getConexion().prepareStatement("select s.CSU_ID\n" +
                                                            "from PFC_SUB_CATEGORIAS s,PFC_CATEGORIAS c\n" +
                                                            "where s.CAT_ID = c.CAT_ID\n" +
                                                            "and s.CSU_NOMBRE = ? \n" +
                                                            "and c.CAT_NOMBRE = ?");
            busqueda.setString(1, subcategoria);
            busqueda.setString(2, categoria);
            
            resultadobusc = busqueda.executeQuery();
            int subC=0;
            
            while (resultadobusc.next()){
                
                subC = resultadobusc.getInt("CSU_ID");
            
            }
            
            
            
            sentencia= con.getConexion().prepareStatement("UPDATE PFC_PRODUCTOS \n" +
                                                            "SET PRO_NOMBRE = ? ,PRO_PRECIO_UNITARIO= ? ,PRO_PORCENTAJE_DESCUENTO= ? "
                    + "                                     ,PRO_UNIDAD_COMPRA= ? ,PRO_UNIDAD_VENTA= ? ,PRO_IVA = ?"
                    + "                                     ,CSU_ID= ? \n" +
                                                            "WHERE PRO_CODIGO_BARRAS = ? ");
            
            sentencia.setString(1, nombre);
            sentencia.setDouble(2, Double.parseDouble(precioUnitario));
            sentencia.setDouble(3, Double.parseDouble(descuento));
            sentencia.setString(4, unidadCompra);
            sentencia.setString(5, unidadVenta);
            sentencia.setString(6, iva);
            sentencia.setInt(7, subC);
            
            sentencia.setString(8, eCodigoBarras);
            
                        
            
            //Ejecutar INSERT
            
            sentencia.executeUpdate();
            
            
            con.getConexion().commit();

            
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
    
    
    
    
    }

    public void editarProducto(Conexion con, Proveedor proveedorSelec, Categoria categoriaSelec, SubCategoria subCategoriaSelec, Producto productoSelec, String razon, String monto) {
        
        try{
            
            //Stableciendo proveedor
            String nombreApellido = proveedorSelec.getNombre() +" "+proveedorSelec.getApellido();
            
            
            busqueda = con.getConexion().prepareStatement("select PRV_ID \n" +
                                                            "from PFC_PROVEEDORES\n" +
                                                            "where PRV_NOMBRE = ? ");
            busqueda.setString(1,  nombreApellido);
            
            resultadobusc = busqueda.executeQuery();
            int provId=0;
            
            while (resultadobusc.next()){
                
                provId = resultadobusc.getInt("PRV_ID");
            
            }
            
            
            
            sentencia= con.getConexion().prepareStatement("INSERT INTO PFC_FACTURAS_COMPRAS VALUES(fco_id_seq.NEXTVAL, ? , ?, ?)");
            
            sentencia.setString(1, razon);
            sentencia.setInt(2, provId);
            sentencia.setString(3, productoSelec.getCodigoBarras());
            sentencia.executeUpdate();
            con.getConexion().commit();
            
            
            
            //Aumentando Stock
            sentencia= con.getConexion().prepareStatement("UPDATE PFC_PRODUCTOS \n" +
                                                            "SET PRO_STOCK = PRO_STOCK + ? \n" +
                                                            "WHERE PRO_CODIGO_BARRAS = ? ");
            
            sentencia.setInt(1, Integer.parseInt(monto));
            sentencia.setString(2, productoSelec.getCodigoBarras());
            
            sentencia.executeUpdate();
            
            
            con.getConexion().commit();
            
            
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
    
    }
    
    
    
    
    
    
    
}
