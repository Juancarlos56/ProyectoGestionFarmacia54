/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import Modelo.FacturaCabecera;
import Modelo.Producto;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Carlos
 */
public class ControladorFacturas {
    private ControladorEmpleados empleados;
    private ControladorClientes clientes;
    private ControladorDirecciones direcciones;
    private ControladorProductos productos;
    private ControladorRecetasMedicas recetas;
    private ArrayList<FacturaCabecera> facturasCabeceras;

    public ControladorFacturas() {
        //this.empleados = new ControladorEmpleados();
        this.clientes = new ControladorClientes();
        this.direcciones = new ControladorDirecciones();
        this.productos = new ControladorProductos();
        this.recetas = new ControladorRecetasMedicas();
        facturasCabeceras = new ArrayList<>();
    }
    
    public ArrayList<FacturaCabecera> obtenerListaFacturas(){
        
        //Esto es para prueba
        FacturaCabecera fc = new FacturaCabecera();
        fc.setEstado('V');
        //Fecha tipo SQL formato por defecto YYYY-MM-DD
        java.sql.Date fecha = new java.sql.Date(new Date().getTime());
        fc.setFechaVenta(fecha);
        fc.setId(1);
        //CreacionEmpleado
        Empleado e = new Empleado();
        e.setNombre("Juan");
        fc.setEmpleado(e);
        facturasCabeceras.add(fc);
        
        FacturaCabecera fcd = new FacturaCabecera();
        fcd.setEstado('V');
        //Fecha tipo SQL formato por defecto YYYY-MM-DD
        java.sql.Date fechad = new java.sql.Date(new Date().getTime());
        fcd.setFechaVenta(fechad);
        fcd.setId(2);
        //CreacionEmpleado
        Empleado ed = new Empleado();
        ed.setNombre("Juan");
        fcd.setEmpleado(ed);
        facturasCabeceras.add(fcd);
        
        return facturasCabeceras;
    }
    
    public FacturaCabecera buscarFacturaCabecera(int codigoFactura){
        for (int i = 0; i < facturasCabeceras.size(); i++) {
            if ( facturasCabeceras.get(i).getId() == codigoFactura ) {
                return facturasCabeceras.get(i);
            }
        }
        return null;
    }
    
    public Double calcularSubtotalFacturaDetalle(Producto pro, int cantidadCompra){
        Double subT = pro.getPrecioUnitario()*cantidadCompra;
        return subT;
    }
    
    public Double calcularDescuentoFacturaDetalle(Producto pro, Double subT){
        Double desc = (pro.getPrecioUnitario() * pro.getPctDescuento())/100;
        return desc;
    }
    
}
