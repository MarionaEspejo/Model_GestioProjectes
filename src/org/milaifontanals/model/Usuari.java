package org.milaifontanals.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe per gestionar usuaris (id, nom, cognom1, cognom2, data_naix, login, i
 * hass_passwd). id, nom, cognom1, data_naix, i login obligatoris. La resta,
 * optatius.
 */
public class Usuari implements Serializable {

    private int id;
    private String nom;
    private String cognom1;
    private String cognom2;
    private Date dataNaixement;
    private String login;
    private String passwordHash;
    private List<ProjecteUsuariRol> projectes = new ArrayList<ProjecteUsuariRol>();
    private List<Tasca> tasques = new ArrayList<Tasca>();

    protected Usuari(){
        
    }
    
    /**
     * Constructor amb tots els parametres
     *
     * @param pId: ID de l'usuari. Obligatori. Entre 1 i 9999
     * @param pNom: Nom de l'usuari. Obligatori. Cadena maxima 45
     * @param pCognom1: Cognom1 de l'usuari. Obligatori. Cadena maxima 45
     * @param pCognom2: Cognom2 de l'usuari. Pot valer null. Cadena maxima 45
     * @param pDataNaix: Data naixement de l'usuari. Obligatori. Ha de ser
     * inferior a la data actual.
     * @param pLogin: Login de l'usuari. Obligatori. Cadena maxima 30
     * @param pPasswordHash: Hash del password de l'usuari. Obligatori. Cadena
     * maxima 30
     */
    public Usuari(int pId, String pNom, String pCognom1, String pCognom2, Date pDataNaix, String pLogin, String pPasswordHash) {
        setId(pId);
        setNom(pNom);
        setCognom1(pCognom1);
        setCognom2(pCognom2);
        setDataNaix(pDataNaix);
        setLogin(pLogin);
        setHashPasswd(pPasswordHash);
    }

    /**
     * Constructor amb camps obligatoris, que invocarà al contructor principal
     * amb NULL
     *
     * @param pId: ID de l'usuari. Obligatori. Entre 1 i 9999
     * @param pNom: Nom de l'usuari. Obligatori. Cadena maxima 45
     * @param pCognom1: Cognom1 de l'usuari. Obligatori. Cadena maxima 45
     * @param pDataNaix: Data naixement de l'usuari. Obligatori. Ha de ser
     * inferior a la data actual.
     * @param pLogin: Login de l'usuari. Obligatori. Cadena maxima 30
     */
    public Usuari(int pId, String pNom, String pCognom1, Date pDataNaix, String pLogin) {
        this(pId, pNom, pCognom1, null, pDataNaix, pLogin, null);
    }

    /**
     * Canvia el id d'usuari
     *
     * @param newID: Nou ID de l'usuari
     * @throw El programa donarà error si s'intenta introduir un id negatiu o
     * superior a 9999
     */
    public void setId(int newID) {
        if (newID < 0 || newID > 9999) {
            throw new RuntimeException("L'usuari ha de tenir codi entre 0 i 9999");
        }
        this.id = newID;
    }

    /**
     * Canvia el nom d'usuari
     *
     * @param newNom: Nou nom de l'usuari
     * @throw El programa donarà error si s'intenta introduir un nom buit, null,
     * o superior a 45 caracters
     */
    public void setNom(String newNom) {
        if (newNom == null || newNom.length() == 0) {
            throw new RuntimeException("L'usuari ha de tenir nom obligatòriament");
        }
        if (newNom.length() > 45) {
            throw new RuntimeException("El nom de l'usuari no pot superar els 45 caracters");
        }
        this.nom = newNom;
    }

    /**
     * Canvia el cognom 1 d'usuari
     *
     * @param newCognom1 Nou cognom de l'usuari
     * @throw El programa donarà error si s'intenta introduir un cognom buit,
     * null, o superior a 45 caracters
     */
    public void setCognom1(String newCognom1) {
        if (newCognom1 == null || newCognom1.length() == 0) {
            throw new RuntimeException("L'usuari ha de tenir el primer cognom obligatòriament");
        }
        if (newCognom1.length() > 45) {
            throw new RuntimeException("El primer cognom del usuari no pot superar els 45 caracters");
        }
        this.cognom1 = newCognom1;
    }

    /**
     * Canvia el cognom 2 d'usuari
     *
     * @param newCognom2 Nou cognom de l'usuari
     * @throw El programa donarà error si s'intenta introduir un cognom superior
     * a 45 caracters
     */
    public void setCognom2(String newCognom2) {
        if (newCognom2 != null && newCognom2.length() > 45) {
            throw new RuntimeException("El segon cognom de l'usuari, no pot superar els 45 caracters");
        }
        this.cognom2 = newCognom2;
    }

    /**
     * Canvia la data de naixement d'usuari
     *
     * @param newOfici Nou ofici de l'usuari
     * @throw El programa donarà error si s'intenta introduir una data superior
     * a la actual
     */
    public void setDataNaix(Date newDateNaix) {
        Date aux = new Date();
        /* if(newDateNaix == null || aux.getTime()>newDateNaix){
            throw new RuntimeException("La data de naixement es obligatoria i no pot ser major a avui");
        }*/
        this.dataNaixement = newDateNaix;
    }

    /**
     * Canvia el login d'usuari
     *
     * @param newLogin: Nou login de l'usuari
     * @throw El programa donarà error si s'intenta introduir un login superior
     * a 30 caracters
     */
    public void setLogin(String newLogin) {
        if (newLogin == null || newLogin.length() == 0) {
            throw new RuntimeException("L'usuari ha de tenir el login obligatòriament");
        }
        if (newLogin.length() > 30) {
            throw new RuntimeException("El login del usuari no pot superar els 30 caracters");
        }
        this.login = newLogin;
    }

    /**
     * Canvia el hash de la contrasenya
     *
     * @param newHashPasswd: Nou hash de contrasenya de l'usuari
     * @throw El programa donarà error si s'intenta introduir un hash de
     * contrasenya superior a 30 caracters
     */
    public void setHashPasswd(String newHashPasswd) {
        if (newHashPasswd == null || newHashPasswd.length() > 250) {
            throw new RuntimeException("El hash de la password de l'usuari, no pot superar els 30 caracters");
        }
        this.passwordHash = newHashPasswd;
    }
	
	/**
     * Iterator que permet accedir als projectes d'un usuari
     */
    public Iterator<ProjecteUsuariRol> iteProjectes() {
        return projectes.iterator();
    }


	 /**
     * Mètode que assigna el projecte a un usuari amb un rol
     *
     * @param projecte
     */
    public void addProjecte(ProjecteUsuariRol projecteUsuariRol) {
        if (projecteUsuariRol == null) {
            throw new RuntimeException("No es pot afegir un projecte null");
        }
        if (!projectes.contains(projecteUsuariRol)) {
            projectes.add(projecteUsuariRol);
        }
    }

    public void removeProjecte(Projecte projecte) {
        if (projectes.contains(projecte)) {
            projectes.remove(projecte);
            projecte.removeUsuari(this);
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
     * Recupera el cognom1
     *
     * @return String cognom1
     */
    public String getCognom1() {
        return cognom1;
    }

    /**
     * Recupera el cognom2
     *
     * @return String Cognom2. Valor null si no té cognom2
     */
    public String getCognom2() {
        return cognom2;
    }

    /**
     * Recupera la data de naixement
     *
     * @return Date dataNaixement
     */
    public Date getDataNaix() {
        return dataNaixement;
    }

    /**
     * Recupera el login
     *
     * @return String login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Recupera el hash de contrasenya
     *
     * @return String passwordHash. Valor null si no té passwordHash
     */
    public String getPasswdHash() {
        return passwordHash;
    }

    /**
     * Metode toString En cas de tenir cognom2 i hash de contrasenya, pot
     * retornar: - Usuari: 1 - Espejo Gil, Mariona - Data naixement: 22/05/2001
     * - Login: mespejo - Hash de la contrasenya:
     * a317891d0025956ad7f49d084db006be En cas de tenir cognom2 i no tenir hash
     * de contrasenya, pot retornar: - Usuari: 1 - Espejo Gil, Mariona - Data
     * naixement: 22/05/2001 - Login: mespejo - Hash de la contrasenya:
     * Desconegut En cas de no tenir cognom2, pot retornar: - Usuari: 1 -
     * Espejo, Mariona - Data naixement: 22/05/2001 - Login: mespejo - Hash de
     * la contrasenya: Desconegut
     */
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String aux = "Usuari: " + id + " - " + cognom1;
        if (cognom2 != null) {
            aux = aux + " " + cognom2;
        }
        aux = aux + ", " + nom + " - Data naixement: " + sdf.format(dataNaixement.getTime()) + " - Login: " + login + " - Hash de la contrasenya: ";
        if (passwordHash != null) {
            aux = aux + passwordHash;
        } else {
            aux = aux + "Desconegut";
        }
        return aux;
    }

    /**
     * Igualtat d'usuaris en base a igualtat dels seus id's
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof Usuari) {
            return id == ((Usuari) obj).id;
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
