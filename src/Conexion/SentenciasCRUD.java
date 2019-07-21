/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

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

    
    /*
    
    Metodo para consultar los datos de un empleado 
    recibe el codigo del empleado, y un atributo conexion
    
    */
    public void ConsultarEmpleados(Conexion con, int codigo){
        try {
            sentencia = con.getConexion().prepareStatement(
                                "SELECT first_name, last_name, email "
                                + "FROM hr.employees "
                                + "WHERE employee_id = ?"
            
            );
            sentencia.setInt(1, codigo);
            resultado = sentencia.executeQuery();
            
            //Se presenta el resultado
            while (resultado.next()) {                
                System.out.println("First Name: " + resultado.getString("first_name") );
                System.out.println("Last Name: " + resultado.getString("last_name"));
                System.out.println("email: "+resultado.getString("email"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }
    
    
    //Metodo para insertar pais
    public void insertarPais(Conexion con, String countryID, String countryName, String regionID){
        try {
            sentencia = con.getConexion().prepareStatement(
                    "INSERT INTO countries VALUES(?,?,?)");
            sentencia.setString(1, countryID);
            sentencia.setString(2, countryName);
            sentencia.setString(3, regionID);
            //Se ejecuta la accion de insertar
            sentencia.executeUpdate();
            
            //Para colocar el COMMIT 
            System.out.println("1. Commit / 2.Rollback");
            Scanner s = new Scanner(System.in);
            int opcion = s.nextInt();
            if (opcion == 1) {
                con.getConexion().commit();
            }else{
                con.getConexion().rollback();
            }
 
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }
    
    public void eliminarPais(Conexion con, String countryID){
        try {
            sentencia = con.getConexion().prepareStatement(
                    "DELETE FROM countries WHERE country_id = ?");
            sentencia.setString(1, countryID);
            sentencia.executeUpdate();
        } catch (SQLException e) {
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
    
    
    
    
    
    
}
