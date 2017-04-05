/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Categoria;
import entity.Utente;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author tss
 */
@SessionScoped  // è come se fosse un localStorage in javascript. Rimane memorizzato per una sessione
public class LoggedFilter implements Serializable{
    
    private Utente utenteLogged;

    public Utente getUtenteLogged() {
        return utenteLogged;
    }

    public void setUtenteLogged(Utente utenteLogged) {
        this.utenteLogged = utenteLogged;
    }
    
    private Categoria categoriaScelta;

    public Categoria getCategoriaScelta() {
        return categoriaScelta;
    }

    public void setCategoriaScelta(Categoria categoriaScelta) {
        this.categoriaScelta = categoriaScelta;
    }
    
    
    
}
