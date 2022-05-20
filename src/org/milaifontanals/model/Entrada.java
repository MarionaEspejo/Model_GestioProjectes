package org.milaifontanals.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe per gestionar entrades (logs) (numero, data, entrada, nouEsta, escriptor, novaAssignacio).
 * numero, data, entrada, escriptor obligatoris. La resta, optatius.
 */
public class Entrada implements Serializable {

    private int numero;
    private Date data;
    private String entrada;
    private Estat nouEstat;
    private Usuari escriptor;
    private Usuari novaAssignacio;

    protected Entrada() {
    }

    /**
     * Constructor amb tots els parametres
     *
     * @param pId: ID de la entrada. Obligatori. Entre 1 i 9999
     * @param pData: Data creacio de la entrada. Hauria de ser automatica
     * @param pEntrada: Descripcio de la entrada. Obligatori. Cadena maxima 200
     * @param pNouEstat: Nou estat de la entrada. Pot valer null.
     * @param pEscriptor: Escriptor la entrada. Obligatori
     * @param pNovaAssignacio: Nova assignacio de una entrada. Pot null.
     */
    public Entrada(int pNumero, Date pData, String pEntrada, Estat pNouEstat, Usuari pEscriptor, Usuari pNovaAssignacio) {
        setNumero(pNumero);
        setData(pData);
        setEntrada(pEntrada);
        setNouEstat(pNouEstat);
        setEscriptor(pEscriptor);
        setNovaAssignacio(pNovaAssignacio);
    }

    /**
     * Constructor amb camps obligatoris, que invocarà al contructor principal
     * amb NULL
     *
     * @param pId: ID de la entrada. Obligatori. Entre 1 i 9999
     * @param pData: Data creacio de la entrada. Hauria de ser automatica
     * @param pEntrada: Descripcio de la entrada. Obligatori. Cadena maxima 200
     * @param pEscriptor: Escriptor la entrada. Obligatori
     */
    public Entrada(int pId, Date pData, String pEntrada, Usuari pEscriptor) {
        this(pId, pData, pEntrada, null, pEscriptor, null);
    }

    /**
     * Canvia el numero d'entrada
     *
     * @param newNumero: Nou numero de l'entrada
     * @throw El programa donarà error si s'intenta introduir un numero negatiu o
     * superior a 9999
     */
    public void setNumero(int newNumero) {
        if (newNumero < 0 || newNumero > 9999) {
            throw new RuntimeException("La entrada ha de tenir numero entre 0 i 9999");
        }
        this.numero = newNumero;
    }

    /**
     * Canvia la data de la entrada
     *
     * @param newDate: Nova data
     * @throw El programa donarà error si s'intenta introduir una data nulla
     */
    public void setData(Date newDate) {
        if (newDate == null) {
            throw new RuntimeException("La entrada ha de tenir data de creació");
        }
        this.data = newDate;
    }

    /**
     * Canvia la descripcio de la entrada
     *
     * @param newEntrada: Nova entrada
     * @throw El programa donarà error si s'intenta introduir un nom buit, null,
     * o superior a 100 caracters
     */
    public void setEntrada(String newEntrada) {
        if (newEntrada == null || newEntrada.length() == 0) {
            throw new RuntimeException("La entrada es obligatoria");
        }
        if (newEntrada.length() > 100) {
            throw new RuntimeException("La entrada no pot superar els 100 caracters");
        }
        this.entrada = newEntrada;
    }

    /**
     * Canvia el estat
     *
     * @param newEstat: Nou estat
     */
    public void setNouEstat(Estat newEstat) {
        this.nouEstat = newEstat;
    }

    /**
     * Canvia de escriptor
     *
     * @param newEscriptor: Nou escriptor
     */
    public void setEscriptor(Usuari newEscriptor) {
        if (newEscriptor == null) {
            throw new RuntimeException("El escriptor no pot ser null");
        }
        this.escriptor = newEscriptor;
    }

    /**
     * Nova assignacio d'entrada
     *
     * @param newAssignacio
     */
    public void setNovaAssignacio(Usuari newAssignacio) {
        this.novaAssignacio = newAssignacio;
    }

    public int getNumero() {
        return numero;
    }

    public Date getData() {
        return data;
    }

    public String getEntrada() {
        return entrada;
    }

    public Estat getNouEstat() {
        return nouEstat;
    }

    public Usuari getEscriptor() {
        return escriptor;
    }

    public Usuari getNovaAssignacio() {
        return novaAssignacio;
    }

    
    //TOOODOO
    /**
     * Metode toString En cas de tenir descripcio i alguna entrada, pot
     * retornar: - Entrada: 1 - NomProjecte - Descripcio: Aixo es la descripcio
     * de la entrada 1 - Cap de entrada: Mariona - Llista de entrades: Nom:
     * entrada 1
     */
    /*public String toString() {
        String aux = "Entrada: " + id + " - " + nom + " - Descripcio: ";
        if (descripcio != null) {
            aux = aux + descripcio;
        } else {
            aux = aux + "Desconeguda";
        }
        aux = aux + " - Cap de entrada: " + capProjecte.getNom();
        if (entrades.length > 0) {
            aux = aux + " - Llista de entrades: ";
            for (int i = 0; i < entrades.length; i++) {
                aux = aux + "\n\t" + entrades[i].toString();
            }
        }
        return aux;
    }

    /**
     * Igualtat de entrades en base a igualtat dels seus id's
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof Entrada) {
            return numero == ((Entrada) obj).numero;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.numero;
        return hash;
    }

}
