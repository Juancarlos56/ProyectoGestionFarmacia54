/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;

/**
 *
 * @author Carlos
 */
public class ControladorEmpleados {
    
    
    /**
     * Este metodo retorna el Empleado siempre y cuando la cedula y username
     * sean igual a la de los empleados guardados en la base de datos
     * sino deberia retornar Null 
     * @param username
     * @param cedula
     * @return 
     */
    public Empleado buscarEmpleadoLogin(String nombre, String cedula){
        

        //Esto es solo para prueba
        Empleado e = new Empleado();
        e.setCedula("0106113301");
        e.setNombre("Carlos");
        return e;
    }
    
}
