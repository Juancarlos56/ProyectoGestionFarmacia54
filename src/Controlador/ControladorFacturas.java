/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

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

    public ControladorFacturas(ControladorEmpleados empleados, ControladorClientes clientes, ControladorDirecciones direcciones, ControladorProductos productos, ControladorRecetasMedicas recetas) {
        this.empleados = empleados;
        this.clientes = clientes;
        this.direcciones = direcciones;
        this.productos = productos;
        this.recetas = recetas;
    }
    
    
    
}
