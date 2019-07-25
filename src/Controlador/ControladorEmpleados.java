/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;

import java.util.ArrayList;


/**
 *
 * @author Carlos
 */
public class ControladorEmpleados {
    
    

    private ArrayList<Empleado> empleados;
    
    private ControladorBaseDeDatos cb;

    public ControladorEmpleados() {
        cb= new ControladorBaseDeDatos();
    }
    
    
    

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    
    public void cargarEmpleados(){
       
        ArrayList<Empleado> c = cb.obtenerEmpleados();
        empleados = c;
        
        

    }
    
}
