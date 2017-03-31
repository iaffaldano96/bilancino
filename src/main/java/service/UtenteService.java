/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Utente;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */

@Stateless
@Named("utenteService")
public class UtenteService {

    @PersistenceContext
    public EntityManager em;

    public Utente save(Utente tosave) {
        return em.merge(tosave);
    }

    public List<Utente> findAllUsr() {
        return em.createNamedQuery(Utente.FIND_ALL).getResultList();
    }

    public Utente findById(Long id) {
        Utente trovato = em.createNamedQuery(Utente.FIND_BY_ID,Utente.class)
                .setParameter("id_utente", id).getSingleResult();
        return trovato;
    }

    public Utente findByUserEPsw(String usr, String psw) {
        Utente result = null;
        try {
            result = em.createNamedQuery(Utente.FIND_BY_USER_PSW, Utente.class)
                    .setParameter("usr", usr).setParameter("psw", psw).getSingleResult();
        } catch (NoResultException ex) { // errore ingnorato dato che non fa niente
        }
        return result;
    }

    public void remove(Utente u) {        
        em.remove(u);
    }

    public void delete(Long id) {
       Utente trovato = em.createNamedQuery(Utente.FIND_BY_ID,Utente.class)
                .setParameter("id_utente", id).getSingleResult();         
        em.remove(trovato);
    }
}
