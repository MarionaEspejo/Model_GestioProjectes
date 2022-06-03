package org.milaifontanals.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe per gestionar tasques (id, dataCreacio, nom, descripcio, dataLimit,
 * entrades, propietari, responsable). id, dataCreacio, nom, propietari
 * obligatoris. La resta, optatius.
 */
public class Tasca implements Serializable {

    private int id;
    private Date dataCreacio;
    private String nom;
    private String descripcio;
    private Date dataLimit;
    private Estat estat;
    private List<Entrada> entrades = new ArrayList<>();
    private Usuari propietari;
    private Usuari responsable;

    protected Tasca() {

    }

    /**
     * Constructor amb tots els parametres
     *
     * @param pId: ID de la tasca. Obligatori. Entre 1 i 9999
     * @param pDataCreacio: Data creacio de la tasca
     * @param pNom: Nom de la tasca. Obligatori. Cadena maxima 45
     * @param pDescripcio: Descripcio de la tasca. Pot valer null. Cadena maxima
     * 200
     * @param pEstat: Estat. Obligatoria
     * @param pDataLimit: Data limit de la tasca. Pot valer null. En cas de no
     * ser nulla, ha de ser superior a la Data de creacio
     * @param pEntrades: Entrades que te una tasca(un historic). Poden ser
     * nulles.
     * @param pPropietari: Propiertari d'una tasca. Obligatori.
     * @param pResponsable: Responsable d'una tasca. Pot ser null.
     */
    public Tasca(int pId, Date pDataCreacio, String pNom, String pDescripcio, Date pDataLimit,
            List<Entrada> pEntrades, Usuari pPropietari, Usuari pResponsable, Estat pEstat) {
        setId(pId);
        setDataCreacio(pDataCreacio);
        setNom(pNom);
        setDesc(pDescripcio);
        setDataLimit(pDataLimit);
        //setEntrades(pEntrades);
        setPropietari(pPropietari);
        setResponsable(pResponsable);
        setEstat(pEstat);
    }

    public Tasca(int pId, Date pDataCreacio, String pNom, String pDescripcio, Usuari pPropietari) {
        setId(pId);
        setDataCreacio(pDataCreacio);
        setNom(pNom);
        setDesc(pDescripcio);
        setPropietari(pPropietari);
    }

    /**
     * Constructor amb camps obligatoris, que invocarà al contructor principal
     * amb NULL
     *
     * @param pId: ID de la tasca. Obligatori. Entre 1 i 9999
     * @param pDataCreacio: Data creacio de la tasca
     * @param pNom: Nom de la tasca. Obligatori. Cadena maxima 45
     * @param pPropietari: Propiertari d'una tasca. Obligatori.
     */
    public Tasca(int pId, Date pDataCreacio, String pNom, Usuari pPropietari, Estat pEstat) {
        this(pId, pDataCreacio, pNom, null, null, null, pPropietari, null, pEstat);
    }

    /**
     * Canvia el id d'tasca
     *
     * @param newID: Nou ID de l'tasca
     * @throw El programa donarà error si s'intenta introduir un id negatiu o
     * superior a 9999
     */
    public void setId(int newID) {
        if (newID < 0 || newID > 9999) {
            throw new RuntimeException("La tasca ha de tenir codi entre 0 i 9999");
        }
        this.id = newID;
    }

    /**
     * Canvia la data de creacio de la tasca
     *
     * @param newDateCreacio: Nova data de creacio
     * @throw El programa donarà error si s'intenta introduir una data nulla
     */
    public void setDataCreacio(Date newDateCreacio) {
        if (newDateCreacio == null) {
            throw new RuntimeException("La tasca ha de tenir data de creació");
        }
        this.dataCreacio = newDateCreacio;
    }

    /**
     * Canvia el nom de la tasca
     *
     * @param newNom: Nou nom de la tasca
     * @throw El programa donarà error si s'intenta introduir un nom buit, null,
     * o superior a 45 caracters
     */
    public void setNom(String newNom) {
        if (newNom == null || newNom.length() == 0) {
            throw new RuntimeException("La tasca ha de tenir nom obligatòriament");
        }
        if (newNom.length() > 45) {
            throw new RuntimeException("El nom de la tasca no pot superar els 45 caracters");
        }
        this.nom = newNom;
    }

    /**
     * Canvia la descripcio de la tasca
     *
     * @param newDesc: Nova descripcio de la tasca
     * @throw El programa donarà error si s'intenta introduir una descripcio
     * superior a 200 caracters
     */
    public void setDesc(String newDesc) {
        if (newDesc != null && newDesc.length() > 200) {
            throw new RuntimeException("La descripció de la tasca no pot superar els 200 caracters");
        }
        this.descripcio = newDesc;
    }

    /**
     * Canvia la data limit de la tasca
     *
     * @param newDataLimit: Nova data limit
     * @throw El programa donarà error si no existeix el cap de tasca
     */
    public void setDataLimit(Date newDataLimit) {
        if (newDataLimit.before(this.dataCreacio)) {
            throw new RuntimeException("La data limit ha de ser posterior a la data de creació de la tasca");
        }
        this.dataLimit = newDataLimit;
    }

    /**
     * Canvi de propietari
     *
     * @param newPropietari: nou propietari de la tasca
     */
    public void setPropietari(Usuari newPropietari) {
        this.propietari = newPropietari;
    }

    /**
     * Canvi de responsable
     *
     * @param newResponsable: nou responsable de la tasca
     */
    public void setResponsable(Usuari newResponsable) {
        this.responsable = newResponsable;
    }

    public void setEstat(Estat newEstat) {
        if (newEstat == null) {
            throw new RuntimeException("El estat no pot ser null");
        }
        this.estat = newEstat;
    }

    /**
     * Afegeix entrada
     *
     * @param entrada: nova entrada a afegir a la llista
     * @throw El programa donarà error si s'intenta introduir una entrada ja
     * existent
     */
    public void addEntrada(Entrada entrada) {
        if (entrades.contains(entrada)) {
            throw new RuntimeException("La entrada ja existeix a la llista");
        }
        entrades.add(entrada);
    }

    /**
     * Elimina entrada
     *
     * @param entrada: entrada a eliminar de la llista
     * @throw El programa donarà error si s'intenta introduir una entrada que no
     * esta a la llista
     */
    public void removeEntrada(Entrada entrada) {
        if (!entrades.contains(entrada)) {
            throw new RuntimeException("La entrada no es troba a la llista");
        }
        entrades.remove(entrada);
    }

    /**
     * Recupera el id
     *
     * @return int id
     */
    public int getID() {
        return id;
    }

    /**
     * Recupera el nom
     *
     * @return String nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Recupera la descripcio
     *
     * @return String descripcio. Valor null si no té descripcio
     */
    public String getDescripcio() {
        return descripcio;
    }

    public Date getDataCreacio() {
        return dataCreacio;
    }

    public Date getDataLimit() {
        return dataLimit;
    }

    public Usuari getPropietari() {
        return propietari;
    }

    public Usuari getResponsable() {
        return responsable;
    }

    public List<Entrada> getEntrades() {
        return entrades;
    }

    //TOOODOO
    /**
     * Metode toString En cas de tenir descripcio i alguna tasca, pot retornar:
     * - Tasca: 1 - NomProjecte - Descripcio: Aixo es la descripcio de la tasca
     * 1 - Cap de tasca: Mariona - Llista de tasques: Nom: tasca 1
     */
    /*public String toString() {
        String aux = "Tasca: " + id + " - " + nom + " - Descripcio: ";
        if (descripcio != null) {
            aux = aux + descripcio;
        } else {
            aux = aux + "Desconeguda";
        }
        aux = aux + " - Cap de tasca: " + capProjecte.getNom();
        if (tasques.length > 0) {
            aux = aux + " - Llista de tasques: ";
            for (int i = 0; i < tasques.length; i++) {
                aux = aux + "\n\t" + tasques[i].toString();
            }
        }
        return aux;
    }

    /**
     * Igualtat de tasques en base a igualtat dels seus id's
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof Tasca) {
            return id == ((Tasca) obj).id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.id;
        return hash;
    }

}
