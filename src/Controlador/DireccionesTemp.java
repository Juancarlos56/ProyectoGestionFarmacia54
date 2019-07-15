/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Direccion;
import java.util.ArrayList;

/**
 *
 * @author sebas
 */
public class DireccionesTemp {
    
    static int c = 0;
    
    private static int actId(){
        
        c++;
        return c;
    }
    
    
        
    public static ArrayList<Direccion> DireccionesTemp  = new ArrayList();

    
    public static void addDirec(String callep, String calles, String ciudad) {
        
        Direccion sta = new Direccion();
        
        sta.setCallePrincipal(callep);
        sta.setCalleSecundaria(calles);
        sta.setCiudadNombre(ciudad);
        int t = actId();
        sta.setId( t );
        
        
        System.out.println(sta.getCallePrincipal()+ sta.getCalleSecundaria() + sta.getCiudadNombre() + sta.getId());
        
        
        
        
        
        DireccionesTemp.add(sta);
        
        
    }
    
    
    
    public void setDirec(ArrayList<Direccion> DireccionesTempenv){
        
        DireccionesTemp=DireccionesTempenv;
        
    };
    
    
    public static ArrayList envDirec(){
        
        return DireccionesTemp;
    };
    
    
    public static void borrarDirec(){
        
        DireccionesTemp.clear();
        
    
    };
    
    
    
    public static void guardDir(Direccion pers) {
        DirEnv = pers;
    }
    
    static Direccion DirEnv;
    
    
    
}
