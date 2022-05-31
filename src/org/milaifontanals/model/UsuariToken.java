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
    
    private String login;
    private String passwordHash;
    private String token;
    
    
    public UsuariToken(String login, String passwordHash) {
        this.login = login;
        this.passwordHash = passwordHash;
        //this.token = token;
        
        //token = UUID.randomUUID().toString();
    }

    public void setLogin(String login) {
        this.login = login;
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
    
       
}