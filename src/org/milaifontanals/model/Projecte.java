package org.milaifontanals.model;

import java.io.Serializable;
import java.util.List;

/**
 * Classe per gestionar projectes (id, nom, descripcio, capProjecte, tasques).
 * id, nom, capProjecte obligatoris. La resta, optatius.
 */
public class Projecte implements Serializable {

    private int id;
    private String nom;
    private String descripcio;
    private Usuari capProjecte;
    private List<Tasca> tasques;
    private List<ProjecteUsuariRol> usuaris;

    protected Projecte() {

    }

    /**
     * Constructor amb tots els parametres
     *
     * @param pId: ID del projecte. Obligatori. Entre 1 i 9999
     * @param pNom: Nom del projecte. Obligatori. Cadena maxima 45
     * @param pDescripcio: Descripcio del projecte. Pot valer null. Cadena
     * maxima 200
     * @param pCapProjecte: Cap de projecte del projecte. Obligatori.
     * @param pTasques: Llista de tasques del projecte. Pot valer null.
     */
    public Projecte(int pId, String pNom, String pDescripcio, Usuari pCapProjecte) {
        setId(pId);
        setNom(pNom);
        setDesc(pDescripcio);
        setCapProj(pCapProjecte);
    }

    /**
     * Constructor amb camps obligatoris, que invocarà al contructor principal
     * amb NULL
     *
     * @param pId: ID del projecte. Obligatori. Entre 1 i 9999
     * @param pNom: Nom del projecte. Obligatori. Cadena maxima 45
     * @param pCapProjecte: Cap de projecte del projecte. Obligatori.
     */
    public Projecte(int pId, String pNom, Usuari pCapProjecte) {
        this(pId, pNom, null, pCapProjecte);
    }

    /**
     * Canvia el id d'projecte
     *
     * @param newID: Nou ID de l'projecte
     * @throw El programa donarà error si s'intenta introduir un id negatiu o
     * superior a 9999
     */
    public void setId(int newID) {
        if (newID < 0 || newID > 9999) {
            throw new RuntimeException("El projecte ha de tenir codi entre 0 i 9999");
        }
        this.id = newID;
    }

    /**
     * Canvia el nom del projecte
     *
     * @param newNom: Nou nom del projecte
     * @throw El programa donarà error si s'intenta introduir un nom buit, null,
     * o superior a 45 caracters
     */
    public void setNom(String newNom) {
        if (newNom == null || newNom.length() == 0) {
            throw new RuntimeException("El projecte ha de tenir nom obligatòriament");
        }
        if (newNom.length() > 45) {
            throw new RuntimeException("El nom del projecte no pot superar els 45 caracters");
        }
        this.nom = newNom;
    }

    /**
     * Canvia la descripcio del projecte
     *
     * @param newDesc: Nova descripcio del projecte
     * @throw El programa donarà error si s'intenta introduir una descripcio
     * superior a 200 caracters
     */
    public void setDesc(String newDesc) {
        if (newDesc != null && newDesc.length() > 200) {
            throw new RuntimeException("La descripció del projecte no pot superar els 200 caracters");
        }
        this.descripcio = newDesc;
    }

    /**
     * Canvia el cap de projecte
     *
     * @param newCapProj: Nou cap de projecte
     * @throw El programa donarà error si no existeix el cap de projecte
     */
    public void setCapProj(Usuari newCapProj) {
        this.capProjecte = newCapProj;
    }

    /**
     * Afegeix tasca
     *
     * @param newTasca: nova tasca a afegir a la llista
     * @throw El programa donarà error si s'intenta introduir una tasca ja
     * existent
     */
    public void addTasca(Tasca newTasca) {
        if (tasques.contains(newTasca)) {
            throw new RuntimeException("La tasca ja existeix a la llista");
        }
        tasques.add(newTasca);
    }

    /**
     * Elimina tasca
     *
     * @param deleteTasca: tasca a eliminar de la llista
     * @throw El programa donarà error si s'intenta introduir una tasca que no
     * esta a la llista
     */
    public void removeTasca(Tasca deleteTasca) {
        if (!tasques.contains(deleteTasca)) {
            throw new RuntimeException("La tasca no es troba a la llista");
        }
        tasques.remove(deleteTasca);
    }
	
	public void addUsuari(ProjecteUsuariRol projecteUsuariRol) {
        if (projecteUsuariRol == null) {
            throw new RuntimeException("No es pot afegir un usuari null");
        }
        if (!usuaris.contains(projecteUsuariRol)) {
            usuaris.add(projecteUsuariRol);
        }
    }

    public void removeUsuari(Usuari usuari) {
        if (usuaris.contains(usuari)) {
            usuaris.remove(usuari);
            usuari.removeProjecte(this);
        }
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

    /**
     * Recupera el cap de projecte
     *
     * @return Usuari capProjecte.
     */
    public Usuari getCapProjecte() {
        return capProjecte;
    }

    /**
     * Recupera la llista de tasques
     *
     * @return List<Tasca> tasques. Valor null si no té cap tasca
     */
    public List<Tasca> getTasques() {
        return tasques;
    }

    /**
     * Metode toString En cas de tenir descripcio i alguna tasca, pot retornar:
     * - Projecte: 1 - NomProjecte - Descripcio: Aixo es la descripcio del
     * projecte 1 - Cap de projecte: Mariona - Llista de tasques: Nom: tasca 1
     */
    public String toString() {
        String aux = "Projecte: " + id + " - " + nom + " - Descripcio: ";
        if (descripcio != null) {
            aux = aux + descripcio;
        } else {
            aux = aux + "Desconeguda";
        }
        aux = aux + " - Cap de projecte: " + capProjecte.getNom();
        if (tasques.size() > 0) {
            aux = aux + " - Llista de tasques: ";
            for (int i = 0; i < tasques.size(); i++) {
                aux = aux + "\n\t" + tasques.get(i).toString();
            }
        }
        return aux;
    }

    /**
     * Igualtat de projectes en base a igualtat dels seus id's
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof Projecte) {
            return id == ((Projecte) obj).id;
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
