/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Controlador.ControladorValidaciones;
import Modelo.Categoria;
import Modelo.Ciudad;
import Modelo.Cliente;
import Modelo.Direccion;
import Modelo.Empleado;
import Modelo.FacturaCabecera;
import Modelo.FacturaDetalle;
import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.SubCategoria;
import java.io.IOException;
import java.sql.Date;
//import static Vista.Principal.Categorias;
//import static Vista.Principal.Clientes;
//import static Vista.Principal.Empleados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
    private Controlador.ControladorValidaciones cv = new ControladorValidaciones();
    
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    
    ArrayList<Categoria> Categorias= new ArrayList();
    
    ArrayList<Empleado> Empleados= new ArrayList();
    
    ArrayList<Cliente> Clientes= new ArrayList();
    
    ArrayList<Proveedor> proveedores= new ArrayList();
    
    ArrayList<Ciudad> Ciudades= new ArrayList();
    
    ArrayList<FacturaCabecera> fac = new ArrayList<>();
    
    
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


    public  ArrayList<Empleado>cargarEmpleados(Conexion con) throws IOException {
        
        try{                                                    //aqui van las consultas
            sentencia = con.getConexion().prepareStatement("select * from PFC_EMPLEADOS");
            
            
            
            resultado = sentencia.executeQuery();
            
            // Se Presenta el resultado
            
            while (resultado.next()){
                
                Empleado e = new Empleado();
                e.setId(resultado.getInt("EMP_ID"));
                e.setNombre(resultado.getString("EMP_NOMBRE"));
                e.setApellido(resultado.getString("EMP_APELLIDO"));
                e.setCedula(resultado.getString("EMP_CEDULA"));
                e.setEstadoEmpleado((resultado.getNString("EMP_ESTADO").charAt(0)));
                
                
                Empleados.add(e);
                
                
                
            }
            
            
            return Empleados;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }   
        
        
    }
    

    
    public ArrayList<Cliente> cargarClientes(Conexion con) {
        
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
            
            
            cargarCiudades(con);
                
            cargarDirecciones(con);
            
            
            return Clientes;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        } 
    }  
    

    private void cargarCiudades(Conexion con) {
        try {
            sentencia = con.getConexion().prepareStatement("select * from PFC_CIUDADES ");
            
            resultado = sentencia.executeQuery();
           
            while (resultado.next()) {                
                Ciudad c = new Ciudad();
                c.setId(resultado.getInt("CUI_ID"));
                c.setNombre(resultado.getString("CUI_NOMBRE"));
               
                Ciudades.add(c);     
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    private void cargarDirecciones(Conexion con) {
        
        try {
            
            sentencia = con.getConexion().prepareStatement("SELECT * FROM PFC_DIRECCIONES ");
            resultado = sentencia.executeQuery();
            while (resultado.next()) { 
                
                Direccion d = new Direccion();
                d.setCallePrincipal(resultado.getString("DIR_CALLE_PRINCIPAL"));
                d.setCalleSecundaria(resultado.getString("DIR_CALLE_SECUNDARIA"));
                d.setId(resultado.getInt("DIR_ID"));
                
                for (int i = 0; i < Ciudades.size(); i++) {
                    if (Ciudades.get(i).getId() == resultado.getInt("CUI_ID")) {
                        d.setCiudad(Ciudades.get(i));
                    }   
                }
                
                for (int i = 0; i < Clientes.size(); i++) {
                    if (Clientes.get(i).getId() == resultado.getInt("CLI_ID")) {
                        Clientes.get(i).addDireccionesP(d);
                    }   
                }
                
            }
        } catch (Exception e) {
        }
    }

    

    public void agregarNuevoClientes(Conexion con, Cliente cliente) {
        
        
        try{
            
            
            sentencia= con.getConexion().prepareStatement("INSERT INTO PFC_CLIENTES VALUES(cli_id_seq.NEXTVAL, ?, ?, ?, ?, ?)");
            
            sentencia.setString(1, cliente.getCedula());
            sentencia.setString(2, cliente.getNombre());
            sentencia.setString(3, cliente.getApellido());
            sentencia.setString(4, cliente.getTlfConvencional());
            sentencia.setString(5, cliente.getTlfCelular());
          
            //Ejecutar INSERT
            sentencia.executeUpdate();
            con.getConexion().commit();
        }catch(SQLException e) {
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
            
            busqueda = con.getConexion().prepareStatement("select s.CSU_ID " +
                                                            "from PFC_SUB_CATEGORIAS s,PFC_CATEGORIAS c " +
                                                            "where s.CAT_ID = c.CAT_ID " +
                                                            "and s.CSU_NOMBRE = ? " +
                                                            "and c.CAT_NOMBRE = ? ");
            busqueda.setString(1, subcategoria);
            busqueda.setString(2, categoria);
            
            resultadobusc = busqueda.executeQuery();
            int subC=0;
            
            while (resultadobusc.next()){

               subC = resultadobusc.getInt("CSU_ID");
                
            
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

    public void compraProducto(Conexion con, Proveedor proveedorSelec, Categoria categoriaSelec, SubCategoria subCategoriaSelec, Producto productoSelec, String razon, String monto) {
        
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

    public void crearEmpleado(Conexion con, String nombre, String apellido, String cedula, String cargo) {
       
        try{
            
            
            sentencia= con.getConexion().prepareStatement("INSERT INTO PFC_EMPLEADOS VALUES(emp_id_seq.NEXTVAL, ? , ? , ? , ? , 'A')");
            
            sentencia.setString(1, cargo);
            sentencia.setString(2, nombre);
            sentencia.setString(3, apellido);
            sentencia.setString(4, cedula);
            
            
            //Ejecutar INSERT
            
            sentencia.executeUpdate();
            
            
            con.getConexion().commit();

            
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
    
    }

    public void editarEmpleado(Conexion con, String nombre, String apellido, String cedula, String cargo) {
        try{
            
            
            sentencia= con.getConexion().prepareStatement("UPDATE PFC_EMPLEADOS " +
                                                            "SET EMP_NOMBRE = ? , EMP_APELLIDO = ? ,EMP_CARGO = ? " +
                                                            "WHERE EMP_CEDULA =  ? ");
            
            sentencia.setString(1, nombre);
            sentencia.setString(2, apellido);
            sentencia.setString(3, cargo);
            sentencia.setString(4, cedula);
            
            
            //Ejecutar INSERT
            
            sentencia.executeUpdate();
            
            
            con.getConexion().commit();

            
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void despEmpleado(Conexion con, String nombre, String apellido, String cedula) {
        try{
            
            
            sentencia= con.getConexion().prepareStatement("UPDATE PFC_EMPLEADOS " +
                                                            "SET EMP_CARGO = 'D' " +
                                                            "WHERE EMP_CEDULA =  ? ");
            
            sentencia.setString(1, cedula);
            
            
            //Ejecutar INSERT
            
            sentencia.executeUpdate();
            
            
            con.getConexion().commit();

            
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }


    public void elimProd(Conexion con, Categoria categoriaSelec, SubCategoria subCategoriaSelec, Producto productoSelec) {
        try{
            
            sentencia= con.getConexion().prepareStatement("UPDATE PFC_PRODUCTOS \n" +
                                                            "SET PRO_ESTADO = 'I' " +
                                                            "WHERE PRO_CODIGO_BARRAS = ? ");
            
            sentencia.setString(1, productoSelec.getCodigoBarras());
            
                        
            
            //Ejecutar INSERT
            
            sentencia.executeUpdate();
            
            
            con.getConexion().commit();

            
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
    

    }

    
    public void agregarNuevaDirecc(Conexion con, String cedula, Direccion direcciones) {
        try{
            String ciudad =direcciones.getCiudad().getNombre();
            
            sentencia= con.getConexion().prepareStatement("INSERT INTO PFC_CIUDADES VALUES(cui_id_seq.NEXTVAL,  ? )");
            sentencia.setString(1, ciudad);
            sentencia.executeUpdate();
            con.getConexion().commit();
            
            sentencia= con.getConexion().prepareStatement("select CUI_ID\n" +
                                                            "from PFC_CIUDADES\n" +
                                                            "where CUI_NOMBRE = ? ");
            sentencia.setString(1, ciudad);
            
            resultado = sentencia.executeQuery();
            int ciuID=0;
            
            while (resultado.next()){
                ciuID=resultado.getInt("CUI_ID");
            }
            
            sentencia= con.getConexion().prepareStatement("select CLI_ID\n" +
                                                            "from PFC_CLIENTES \n" +
                                                            "where CLI_CEDULA = ? ");
            sentencia.setString(1, cedula);
            
            resultado = sentencia.executeQuery();
            int cliID=0;
            
            while (resultado.next()){
                cliID=resultado.getInt("CLI_ID");
            }
            
            
            sentencia= con.getConexion().prepareStatement("INSERT INTO PFC_DIRECCIONES VALUES(dir_id_seq.NEXTVAL, ?, ? , ? , ? ) ");
            sentencia.setString(1, direcciones.getCallePrincipal());
            sentencia.setString(2, direcciones.getCalleSecundaria());
            
            sentencia.setInt(3 , ciuID );
            sentencia.setInt(4 , cliID );
            
            sentencia.executeQuery();

            con.getConexion().commit();
        
        }catch(SQLException e) {
            e.printStackTrace();
        }


    }

    public void addFactura(Conexion con, FacturaCabecera factura, String text) {
        
        int facID = Integer.parseInt(text);
        
        try{
            
            
            
            
            
            sentencia= con.getConexion().prepareStatement("INSERT INTO PFC_FACTURAS_CABECERA VALUES( ? , ? , ?, ? , ? , ? , 'V', 'E',  ?, ?, ?)");
            
            sentencia.setInt(1, facID);
            sentencia.setDate(2, factura.getFechaVenta());
            

            sentencia.setDouble(3, factura.getSubtotal());
            sentencia.setDouble(4, factura.getDescuento());
            
            sentencia.setDouble(5, factura.getAdicionalEnvio());
            sentencia.setDouble(6, factura.getValorTotal());
            
            sentencia.setInt(7, factura.getCliente().getId());
            sentencia.setInt(8, factura.getEmpleado().getId());
            sentencia.setInt(9, factura.getCliente().getDirecciones().get(0).getId());
            
            
            sentencia.executeQuery();
        
            
            for (FacturaDetalle detalle : factura.getDetalle()) {
                
                String pro =detalle.getProducto().getCodigoBarras();
                int cant= detalle.getCantidad();  
            

                
                
                sentencia= con.getConexion().prepareStatement("INSERT INTO PFC_FACTURAS_DETALLE VALUES(fde_id_seq.NEXTVAL, ? ,  ? , ? , ? , ? , ? )");
                
                sentencia.setInt(1 , cant );
                sentencia.setDouble(2, detalle.getPrecio());
                sentencia.setDouble(3 , detalle.getDescuento() );
                sentencia.setDouble(4, detalle.getSubtotal());
                sentencia.setInt(5, facID);
                sentencia.setString(6, pro);
                
                sentencia.executeQuery();
                
                
                
                
            }
            

            
            con.getConexion().commit();
            
            

            
            
        }catch(SQLException e) {
            e.printStackTrace();

        }
    
    
    
    
    
    
    
    }

    
    public ArrayList<FacturaCabecera> obtFacts(Conexion con) throws IOException {
        
        cargarClientes(con);
        
        ArrayList<Empleado> emps =cargarEmpleados(con);
        
        Categorias.clear();
        cargarCategorias(con);
        
        
        
        try{
            sentencia= con.getConexion().prepareStatement("select * from PFC_FACTURAS_CABECERA");
            resultado = sentencia.executeQuery();
            
            // Se Presenta el resultado
            
            while (resultado.next()){
                
                FacturaCabecera c = new FacturaCabecera();
                
                c.setId(resultado.getInt("FCA_ID"));
                c.setFechaVenta(resultado.getDate("FCA_FECHA_VENTA"));
                c.setSubtotal(resultado.getDouble("FCA_SUBTOTAL"));
                c.setDescuento(resultado.getDouble("FCA_DESCUENTO"));
                c.setAdicionalEnvio(resultado.getDouble("FCA_ADICIONAL_ENVIO"));
                c.setValorTotal(resultado.getDouble("FCA_VALOR_TOTAL"));
                c.setEstado(resultado.getString("FCA_ESTADO").charAt(0));

                
                
                
                
                 for (Cliente cli : Clientes) {
                     
                    
                    if ( resultado.getInt("CLI_ID") == cli.getId()){
                        
                        
                        c.setCliente(cli);
                         for (Direccion direccione : cli.getDirecciones()) {
                             if ( direccione.getId()== resultado.getInt("DIR_ID")  ) {
                                 
                                 c.setDireccion(direccione);
                             }
                         }
                     }
                     
                     
                     
                 }
                 
                 
                 for (Empleado emp : emps) {
                     if(emp.getId()== resultado.getInt("EMP_ID") ){
                         c.setEmpleado(emp);
                         
                     }
                     
                 }
                 
                 
                 
                 
                 
                 fac.add(c);
                
                
                
                
            }
            //Cargar Detalles
            
            

                
                
            sentencia= con.getConexion().prepareStatement("select * from PFC_FACTURAS_DETALLE");

            resultado = sentencia.executeQuery();


            while (resultado.next()){
            FacturaDetalle fd = new FacturaDetalle();
                fd.setId(resultado.getInt("FDE_ID"));
                fd.setCantidad(resultado.getInt("FDE_CANTIDAD"));
                fd.setPrecio(resultado.getDouble("FDE_PRECIO"));
                fd.setDescuento(resultado.getDouble("FDE_DESCUENTO"));
                fd.setSubtotal(resultado.getDouble("FDE_SUBTOTAL"));
                
                
                for (FacturaCabecera fac1 : fac) {
                    if ( fac1.getId() ==resultado.getInt("FCA_ID") ) {  
                        fac1.addDetalle(fd);
                    
                    }
                }
                
                for (Categoria Categoria : Categorias) {
                    
                    
                    for (SubCategoria subcategoria : Categoria.getSubcategorias()) {
                        
                        for (Producto producto : subcategoria.getProductos()) {
                        
                            if (producto.getCodigoBarras().equals(resultado.getString("PRO_CODIGO_BARRAS"))){
                        
                                fd.setProducto(producto);
                            }    
                        }
                        
                        
                    }   
                } 
                
                
                
                
                

            }
            
            
            return fac; 
            
        }catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
        
        
        
        
    }

    public void anularF(Conexion con, FacturaCabecera factSelect) throws IOException {
        
        fac.clear();
        obtFacts(con);
        
        
        
        
        try{
            sentencia= con.getConexion().prepareStatement("UPDATE PFC_FACTURAS_CABECERA \n" +
                                                            "SET FCA_ESTADO = 'A'\n" +
                                                            "WHERE FCA_ID = ? ");
            
            sentencia.setInt(1 , factSelect.getId() );
            
            sentencia.executeQuery();
        
            System.out.println(factSelect.getDetalle().size());
            
            for (FacturaDetalle detalle : factSelect.getDetalle()) {
                
               
                
                String pro =detalle.getProducto().getCodigoBarras();
                int cant= detalle.getCantidad();  
                
                
             
                sentencia= con.getConexion().prepareStatement("UPDATE PFC_PRODUCTOS\n" +
                                                                "SET PRO_STOCK = PRO_STOCK + ? \n" +
                                                                "WHERE PRO_CODIGO_BARRAS =   ? ");
                sentencia.setInt(1 , cant );
                sentencia.setString(2 , pro );
                
                sentencia.executeQuery();
            
            }
            
            con.getConexion().commit();
            
            

            
            
        }catch(SQLException e) {
            e.printStackTrace();

        }
        
        
        
        
        
    }

    public String anularF(Conexion con) throws SQLException {
        busqueda = con.getConexion().prepareStatement("select fca_id_seq.NEXTVAL" +
                                                                " from dual");
            
            resultadobusc = busqueda.executeQuery();
            int facID=0;
            
            while (resultadobusc.next()){
                
                facID = resultadobusc.getInt("NEXTVAL");
            
            }
            
            return Integer.toString(facID);
            
    }


    
    
    
    
    
    
}
