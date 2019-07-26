/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import Modelo.FacturaCabecera;
import Modelo.Producto;
import java.io.IOException;
import java.sql.SQLException;
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

    
    private ControladorBaseDeDatos cb;

    
    
    public ControladorFacturas() {
        facturasCabeceras = new ArrayList<>();
        cb = new ControladorBaseDeDatos(); 
    }
    
    
    
    
    
    /*public ArrayList<FacturaCabecera> obtenerListaFacturas(){
        
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
    }*/
    
    public FacturaCabecera buscarFacturaCabecera(int codigoFactura){
        for (int i = 0; i < facturasCabeceras.size(); i++) {
            if ( facturasCabeceras.get(i).getId() == codigoFactura ) {
                return facturasCabeceras.get(i);
            }
        }
        return null;
    }
    
    public Double calcularSubtotalFacturaDetalle(Producto pro, int cantidadCompra){
        Double subT = 0.0;
        if (pro.getIva() == 'S') {
            subT = ((pro.getPrecioUnitario()*cantidadCompra)*112)/100;
            return subT;
        }
        
        if (pro.getIva() == 'N') {
            subT = pro.getPrecioUnitario()*cantidadCompra;
            return subT;
        }
        return subT;
    }
    
    public Double calcularDescuentoFacturaDetalle(Producto pro, Double subT){
        Double desc = (pro.getPrecioUnitario() * pro.getPctDescuento())/100;
        return desc;
    }
    
    public Double calcularDescuentoTotal(FacturaCabecera fac){
        Double desc = 0.0;
        for (int i = 0; i < fac.getDetalle().size(); i++) {
            desc = desc + fac.getDetalle().get(i).getDescuento();
        }
        return desc;
    }
    
    public Double calcularSubtotalTotal(FacturaCabecera fac){
        Double sbt = 0.0;
        for (int i = 0; i < fac.getDetalle().size(); i++) {
            sbt = sbt + fac.getDetalle().get(i).getSubtotal();
        }
        return sbt;
    }
    
    public Double calcularTotal(FacturaCabecera fac){
        Double total = 0.0;
        for (int i = 0; i < fac.getDetalle().size(); i++) {
            total = total + fac.getDetalle().get(i).getPrecio();
        }
        return total;
    }

    public void guardarFac(FacturaCabecera factura , String text) {
        
        cb.agregarFactura(factura, text);
        
        
    }

    public void cargarFacturas() throws IOException {
        
        ArrayList<FacturaCabecera> c = cb.obtenerFacturas();
        facturasCabeceras = c;
        
        
    }

    public ArrayList<FacturaCabecera> getFacturas() {
        return this.facturasCabeceras;
    }

    public void anular(FacturaCabecera factSelect) throws IOException {
        cb.anular(factSelect);
    }

    public void delFact() {
        facturasCabeceras.clear();
    }

    public String getNumFactura() throws SQLException {
        return cb.getnumFac();
    }


    
}
