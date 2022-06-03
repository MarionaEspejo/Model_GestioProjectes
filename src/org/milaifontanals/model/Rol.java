package org.milaifontanals.model;

import java.io.Serializable;

public class Rol implements Serializable{
    
    protected Rol(){
        
    }

    public Rol(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
    
    private int id;
    private String nom;
    /*PROGRAMADOR,
    ANALISTA,
    CLIENT*/
}
