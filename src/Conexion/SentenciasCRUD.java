/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Modelo.Categoria;
import Modelo.Producto;
import Modelo.SubCategoria;
import static Vista.Principal.Categorias;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


/**
 *
 * @author Carlos
 */
public class SentenciasCRUD {
    private ResultSet resultado = null;
    private PreparedStatement sentencia = null;

    
    
    
    
    
    
    
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

    
    
    
    
    
    public void cargarCategorias(Conexion con) {
        
        
        
        try{                                                    //aqui van las consultas
            sentencia = con.getConexion().prepareStatement("Select * " +
                                                            "from PFC_CATEGORIAS");
            
            
            
            resultado = sentencia.executeQuery();
            
            // Se Presenta el resultado
            
            while (resultado.next()){
                
                Categoria c = new Categoria();
                
                c.setId(resultado.getInt("CAT_ID"));
                c.setNombreSubCategoria(resultado.getString("CAT_NOMBRE"));
                
                Categorias.add(c);
                
                
                
            }
            
            
            
            
            
        }catch(SQLException e){
            e.printStackTrace();
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
    
    
    
    
    
    
}
