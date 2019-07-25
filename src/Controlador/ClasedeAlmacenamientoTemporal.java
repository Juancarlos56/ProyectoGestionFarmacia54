/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Direccion;
import Modelo.FacturaCabecera;
import Modelo.Producto;
import java.util.ArrayList;

/**
 *
 * @author sebas
 */

// Esta Clase la voy a usar para almacenar datos temporalmente y probar funcionalidades
//Puede que tambien para Cargar datos temporales
public class ClasedeAlmacenamientoTemporal {
    
    public static int numFacAct =1;
    
    static int c =0;
    
    


    static void addCliente(Cliente ste) {
        
        ClientesTemp.add(ste);
        
    }
    
     private static void addProducto(Producto pro) {
        ProductosTemp.add(pro);
    }
    
    
    
    
    public static ArrayList<Producto> ProductosTemp= new ArrayList();
    
    
    
    
    public static ArrayList<FacturaCabecera> FacturasTemp= new ArrayList();

    
    public static int autID(){
      
        c++;
        return c; 
    };
    
    
    public static ArrayList<Cliente> ClientesTemp= new ArrayList();
    
    
    
    
    public static ArrayList<Producto> ProductossTemp= new ArrayList();
    
    
    
    
    
    //Ingreso manual de Clientes, USO SOLO DE PRUEBAS
    
       public static void CCP() {
        Cliente ste = new Cliente();
        
        ste.setNombre("Florencio");
        ste.setApellido("Peralta");
        ste.setCedula("0105895866");
        ste.setTlfConvencional("2250109");
        ste.setTlfCelular("0998017181");
        
        
        ste.setId(ClasedeAlmacenamientoTemporal.autID());
        
        ClasedeAlmacenamientoTemporal.addCliente(ste);
    }; 

    public static void CLP() {
        
        Producto p1 = new Producto();
        p1.setCodigoBarras("11111");
        p1.setIva('V');
        p1.setNombre("Vitamina C");
        p1.setPctDescuento(0.20);
        p1.setPrecioUnitario(0.50);
        p1.setStock(10);
        p1.setUnidadCompra("5");
        
        ClasedeAlmacenamientoTemporal.addProducto(p1);
        
        Producto p2 = new Producto();
        p2.setCodigoBarras("22222");
        p2.setIva('F');
        p2.setNombre("Jarabe");
        p2.setPctDescuento(0.10);
        p2.setPrecioUnitario(6.50);
        p2.setStock(5);
        p2.setUnidadCompra("1");
        
        ClasedeAlmacenamientoTemporal.addProducto(p2);
        
        Producto p3 = new Producto();
        p3.setCodigoBarras("33333");
        p3.setIva('V');
        p3.setNombre("PEMEX");
        p3.setPctDescuento(0.05);
        p3.setPrecioUnitario(100);
        p3.setStock(0);
        p3.setUnidadCompra("1");
        
        ClasedeAlmacenamientoTemporal.addProducto(p3);
    }

   
    
    
    
}
