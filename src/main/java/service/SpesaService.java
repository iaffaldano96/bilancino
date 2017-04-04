/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Spesa;
import entity.Utente;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */

@Stateless
@Named("spesaService")
public class SpesaService {
    
    @Inject
    LoggedFilter utenteLogged;
    
    @PersistenceContext
    private EntityManager em;
    
    public Spesa save(Spesa tosave){
        return em.merge(tosave);
    }
    
    public Spesa findById(Long id){
        return em.createNamedQuery(Spesa.FIND_BY_ID, Spesa.class).setParameter("id_spesa", id).getSingleResult();
    }
    
    public List<Spesa> findByUser(){
        Utente u=utenteLogged.getUtenteLogged();
        return em.createNamedQuery(Spesa.FIND_BY_USER, Spesa.class).setParameter("utente", u).getResultList();
    }
    
    public List<Spesa> findByCategoria(String cate){
        return em.createNamedQuery(Spesa.FIND_BY_CATEGORIA, Spesa.class).setParameter("categoria", cate).getResultList();
    }
    
    public List<Spesa> findByData(Date data){
        return em.createNamedQuery(Spesa.FIND_BY_DATA, Spesa.class).setParameter("data_creato", data).getResultList();
    }
    
      public void remove(Spesa s) {        
        em.remove(s);
    }
}
