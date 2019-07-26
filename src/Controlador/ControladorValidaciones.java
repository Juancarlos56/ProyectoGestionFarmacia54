/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import java.sql.Date;

/**
 *
 * @author Carlos
 */
public class ControladorValidaciones {

    
    /*Date now = GestionBiblioteca.getHora();
                        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                        SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");*/
    
    // Uso : date.format(now)
    public Date getHora() {
         Date now = new Date(System.currentTimeMillis());
         return now;
    }
    
    
    
    public boolean validarDocumento(String documentoIDE) {
        boolean documentoIDECorrecto;
        try {
 
            if (documentoIDE.length() == 10){
                int tercerDigito = Integer.parseInt(documentoIDE.substring(2, 3));
                if (tercerDigito < 6) {

                    int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
                    int verificador = Integer.parseInt(documentoIDE.substring(9,10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (documentoIDE.length() - 1); i++) {
                        
                        digito = Integer.parseInt(documentoIDE.substring(i, i + 1))* coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }
 
                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        documentoIDECorrecto = true;
                    }
                    else if ((10 - (suma % 10)) == verificador) {
                        documentoIDECorrecto = true;
                    } 
                    else {
                        documentoIDECorrecto = false;
                    }
                    
                } 
                else {
                    documentoIDECorrecto = false;

                }

            } 
            else {
                documentoIDECorrecto = false;
            }

        } 
        catch (NumberFormatException nfe) {

            documentoIDECorrecto = false;
        } 
        catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion");
            documentoIDECorrecto = false;
        }
 
        if (!documentoIDECorrecto) {
            System.out.println("La Cédula ingresada es Incorrecta");
        }

        return documentoIDECorrecto;
    
    }
}
