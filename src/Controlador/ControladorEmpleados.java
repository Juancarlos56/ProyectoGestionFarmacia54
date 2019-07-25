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
     * @param username
     * @param cedula
     * @return 
     */
    public Empleado buscarEmpleadoLogin(String nombre, String cedula){
        
        for (int i = 0; i < empleados.size(); i++) {
            System.out.println(empleados.get(i));
            
        }
        
        for (int i = 0; i < getEmpleados().size(); i++) {
            if (getEmpleados().get(i).getNombre().equalsIgnoreCase(nombre)== true) {
                System.out.println("holad");
                if (getEmpleados().get(i).getCedula().equals(cedula) == true) {
                    System.out.println("holat");
                    return getEmpleados().get(i);
                }else{
                    return null;
                }
            }else{
                return null;
            }
            
        }
        

        //Esto es solo para prueba
        Empleado e = new Empleado();
        e.setCedula("0106113301");
        e.setNombre("Carlos");
        return e;
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