package org.milaifontanals.model;

import java.io.Serializable;

public class Estat implements Serializable {

    public int id;
    public String nom;

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
    /*PROGRAMADOR,
    ANALISTA,
    CLIENT*/
}
