/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */

public class ControladorClientes {
    
    private ControladorDirecciones cd;
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ControladorBaseDeDatos cb;

    public ControladorClientes() {
        cb = new ControladorBaseDeDatos();
    }

    public void cargarClientes() {
        clientes = cb.obtenerClientes();
        
    }
    
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente buscarClientePorNombre(String nombre) {
        for (int i = 0; i < clientes.size(); i++) {
            if (nombre.equalsIgnoreCase(clientes.get(i).getNombre())) {
               return clientes.get(i);
            }
            
        }
        return null;
    }
    
    
    public Cliente buscarClientePorCedula(String cedula) {
        for (int i = 0; i < clientes.size(); i++) {
            if (cedula.equalsIgnoreCase(clientes.get(i).getCedula())) {
                return clientes.get(i);
            }
        }
        return null;
    }
    
    
    public Cliente crearNuevoCliente(Cliente cliente) {
        cb.agregarNuevoCliente(cliente);
        return null;
    }

    public void borrarC() {
        clientes.clear();
    }
    
    
    
    
    
    
}
