/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Categoria;
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
    LoggedFilter filtro;

    @PersistenceContext
    private EntityManager em;
    
    @Inject
    CategoriaService categoriaService;
    
    public Spesa save(Spesa tosave){
        return em.merge(tosave);
    }
    
    public Spesa findById(Long id){
        List<Spesa> spe= em.createNamedQuery(Spesa.FIND_BY_ID, Spesa.class).setParameter("id_spesa", id).getResultList();
        if(spe.isEmpty())
            return null;
        return spe.get(0);
    }
    
    public List<Spesa> findByUser(){
        Utente u=filtro.getUtenteLogged();
        return em.createNamedQuery(Spesa.FIND_BY_USER, Spesa.class).setParameter("utente", u).getResultList();
    }
    
    public List<Spesa> findByCategoria(String cate){
        Categoria c = categoriaService.findById(cate);
  
        Utente u=filtro.getUtenteLogged();       
        List<Spesa> sp= em.createNamedQuery(Spesa.FIND_BY_CATEGORIA, Spesa.class).setParameter("categoria", c).setParameter("utente", u).getResultList();
        if(sp.isEmpty())
            return null;
        else
            return sp;
    }
    
    public List<Spesa> findByData(Date data){
        return em.createNamedQuery(Spesa.FIND_BY_DATA, Spesa.class).setParameter("data_creato", data).getResultList();
    }
    
      public void remove(Spesa s) {        
        em.remove(s);
    }
}
