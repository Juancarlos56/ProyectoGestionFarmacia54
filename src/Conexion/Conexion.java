/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Carlos
 */
public class Conexion {
    
    private String username;
    private String password;
    private String url;
    private Connection conexion = null;

    /*
    Metodo sirve para conectar con la base datos oracle
    */
    public void conectar(){
        try{
            this.setConexion(DriverManager.getConnection(this.getUrl(), this.getUsername(), this.getPassword()));
        }catch(SQLException e){
            e.printStackTrace();
        }
    
    }
    //Sirve para cerrar la conexion con la base da datos
    public void cerrarConexion(){
        try{                              //Si no esta cerrado El !!!!!!
            if(this.getConexion() !=null && !this.getConexion().isClosed()){
                this.getConexion().close();
            }
        }catch(SQLException e){
            e.printStackTrace();
            
        }
    
    }
    
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Connection getConexion() {
        return conexion;
    }

    //Quitando el autocommit
    public void setConexion(Connection conexion) throws SQLException {
        this.conexion = conexion;
        this.conexion.setAutoCommit(false);
    }
    
}
