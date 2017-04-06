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
        List<Utente> ute = em.createNamedQuery(Utente.FIND_BY_ID, Utente.class)
                .setParameter("id_utente", id).getResultList();
        if (ute.isEmpty()) {
            return null;
        }
        return ute.get(0);
    }

    public Utente findByUserEPsw(String usr, String psw) {
        List<Utente> ute = em.createNamedQuery(Utente.FIND_BY_USER_PSW, Utente.class)
                .setParameter("usr", usr).setParameter("psw", psw).getResultList();
        if (ute.isEmpty()) {
            return null;
        }
        return ute.get(0);
    }

    public Utente findUser(String usr) {
        List<Utente> ute = em.createNamedQuery(Utente.FIND_USER, Utente.class)
                .setParameter("usr", usr).getResultList();
        if (ute.isEmpty()) {
            return null;
        }
        return ute.get(0);
    }

    public void remove(Utente u) {
        em.remove(u);
    }

    public void delete(Long id) {
        List<Utente> ute = em.createNamedQuery(Utente.FIND_BY_ID, Utente.class)
                .setParameter("id_utente", id).getResultList();
        em.remove(ute.get(0));
    }
}
