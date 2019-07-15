/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import Vista.InternalVentanaFacturaVen;

/**
 *
 * @author sebas
 */
public class CProducto {
    
    
    public static Producto buscarPporN(String text) {
        
        
        for (Producto ProductosTemp : ClasedeAlmacenamientoTemporal.ProductosTemp) {
            
            
            if (ProductosTemp.getNombre().equals(text)){
                return ProductosTemp;
            }
            
        }
        
        return null;
    }
    
    
    
    
    
    public static Producto buscarPporDB(String text) {
        
        for (Producto ProductosTemp : ClasedeAlmacenamientoTemporal.ProductosTemp) {
            
            
            
            if (ProductosTemp.getCodigoBarras().equals(text)){
                return ProductosTemp;
            }
            
        }
        return null;
    }

    
    
    public static void cargarPenFactura() {
    
        InternalVentanaFacturaVen.setDatosP();
    }

    
    
    
    
    
    
    
    
    
    
}
