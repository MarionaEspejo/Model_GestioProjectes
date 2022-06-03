/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milaifontanals.model;

import java.io.Serializable;
import java.util.UUID;


public class UsuariToken implements Serializable{

    protected UsuariToken(){
        
    }
    
    private int ID;
    private String login;
    private String passwordHash;
    private String token;

    
    
    public UsuariToken(int ID, String login, String passwordHash) {
        this.ID = ID;
        this.login = login;
        this.passwordHash = passwordHash;
        //this.token = token;
        
        //token = UUID.randomUUID().toString();
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    public void setID(int id) {
        this.ID = id;
    }


    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setToken() {
        this.token = UUID.randomUUID().toString();
    }

    public String getLogin() {
        return login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getToken() {
        return token;
    }
    
        public int getId() {
        return ID;
    }

    @Override
    public String toString() {
        return "UsuariToken{" + "ID=" + ID + ", login=" + login + ", passwordHash=" + passwordHash + ", token=" + token + '}';
    }
    
       
}
