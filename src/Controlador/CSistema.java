/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.Date;

/**
 *
 * @author sebas
 */
public class CSistema {
    
    
    public static Date getHora() {
         Date now = new Date(System.currentTimeMillis());
         return now;
    }
    
}
