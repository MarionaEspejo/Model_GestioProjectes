package org.milaifontanals.model;

import java.io.Serializable;
import java.util.Date;

public class ProjecteUsuariRol implements Serializable {

    private Integer idProjecte;
    private Integer idUsuari;

    private Projecte projecte;
    private Usuari usuari;
    private Rol rol;

    protected ProjecteUsuariRol() {
    }

    /**
     * Constructor amb tots els parametres
     *
     * @param pProjecte
     * @param pUsuari
     * @param pRol
     */
    public ProjecteUsuariRol(Projecte pProjecte, Usuari pUsuari, Rol pRol) {
        setProjecte(pProjecte);
        setUsuari(pUsuari);
        setRol(pRol);
    }

    /**
     * Canvia el projecte
     *
     * @param newProject
     * @throw El programa donarà error si s'intenta introduir un null
     */
    public void setProjecte(Projecte projecte) {
        this.projecte = projecte;
        this.idProjecte = projecte.getID();
    }

    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
        this.idUsuari = usuari.getID();
    }

    /**
     * Canvia el rol
     *
     * @param newRol
     * @throw El programa donarà error si s'intenta introduir un null
     */
    public void setRol(Rol newRol) {
        if (newRol == null) {
            throw new RuntimeException("El rol no pot ser null");
        }
        this.rol = newRol;
    }
}
