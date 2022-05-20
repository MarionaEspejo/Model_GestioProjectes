package org.milaifontanals.model;

import java.io.Serializable;

public class Estat implements Serializable {

    protected Estat() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
