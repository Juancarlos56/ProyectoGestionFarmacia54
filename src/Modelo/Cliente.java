/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.ControladorBaseDeDatos;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class Cliente extends Persona{
    
    private String cedula;
    private String tlfConvencional;
    private String tlfCelular;
    private ArrayList<Direccion> direcciones;
    private ControladorBaseDeDatos cb;
    
    public Cliente() {
        super();
        cb = new ControladorBaseDeDatos();
        direcciones = new ArrayList<>();
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTlfConvencional() {
        return tlfConvencional;
    }

    public void setTlfConvencional(String tlfConvencional) {
        this.tlfConvencional = tlfConvencional;
    }

    public String getTlfCelular() {
        return tlfCelular;
    }

    public void setTlfCelular(String tlfCelular) {
        this.tlfCelular = tlfCelular;
    }

    public ArrayList<Direccion> getDirecciones() {
        return direcciones;
    }



    public void addDirecciones(String cedula, Direccion direcciones) {
        this.direcciones.add(direcciones);
        
        System.out.println(cedula + " "+ direcciones.getCallePrincipal());
        cb.agregarDireccionCliente(cedula,direcciones);
    }

    public void addDireccionesP(Direccion d) {
        this.direcciones.add(d);
    
    }

}
