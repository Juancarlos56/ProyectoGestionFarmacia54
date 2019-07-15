/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ClasedeAlmacenamientoTemporal;



/**
 *
 * @author Carlos
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VentanaLogin v = new VentanaLogin();
        v.setVisible(true);
        
        
        //Carga datos de prueba
        ClasedeAlmacenamientoTemporal.CCP();
        ClasedeAlmacenamientoTemporal.CLP();
             
    }
    
}
