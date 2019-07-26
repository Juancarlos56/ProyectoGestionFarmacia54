/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class ControladorEmpleados {
    
    private ArrayList<Empleado> empleados = new ArrayList<>();
    
    private ControladorBaseDeDatos bd;
    
    public ControladorEmpleados() throws IOException {
        bd = new ControladorBaseDeDatos();
        
        //Comentado este cargar empleados por que causa que se duplique la lista dentro del gestion Empleados
        //Es mejor Poner el metodo Dentro de la clase a usar
        //Para entender mejor, hacer referencia a GestionEmpleados dentro de la vista
        //cargarEmpleados();
    
    }
    
    public void cargarEmpleados() throws IOException{
        setEmpleados(bd.obtenerEmpleados());
    }
    
    
    /**
     * Este metodo retorna el Empleado siempre y cuando la cedula y username
     * sean igual a la de los empleados guardados en la base de datos
     * sino deberia retornar Null 
     * @param nombre
     * @param username
     * @param cedula
     * @return 
     * @throws java.io.IOException 
     */
    public Empleado buscarEmpleadoLogin(String nombre, String cedula) throws IOException{
        
        Empleado emp= null;
        cargarEmpleados();
        
        
        for (Empleado empleado : empleados) {
        
            if (empleado.getNombre().equals(nombre)) {
                if (empleado.getCedula().equals(cedula)){
                    
                    emp= empleado;
                }
                
                
            }
        
        
        }
        return emp;
        

    }
    
    
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void crearEmpleado(String nombre, String apellido, String cedula, String cargo) {
        
        bd.crearEmpleado(nombre,apellido,cedula,cargo);
        
    }

    public void clearEmpleados() {
        empleados.clear();
    }

    public void editarEmpleado(String nombre, String apellido, String cedula, String cargo) {
        
        bd.editarEmpleado(nombre,apellido,cedula,cargo);
    }

    public void despEmpleado(String nombre, String apellido, String cedula) {
        bd.despEmpleado(nombre,apellido,cedula);
    }
    
}
