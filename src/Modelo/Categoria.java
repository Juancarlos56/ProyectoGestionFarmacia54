/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class Categoria {
    private int id;
    private String nombreCategoria;
    private ArrayList<SubCategoria> subcategorias;

    public Categoria() {
        subcategorias = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreSubCategoria) {
        this.nombreCategoria = nombreSubCategoria;
    }

    public ArrayList<SubCategoria> getSubcategorias() {
        return subcategorias;
    }

    public void addSubcategorias(SubCategoria subcategorias) {
        this.subcategorias.add(subcategorias);
    }
    
}
