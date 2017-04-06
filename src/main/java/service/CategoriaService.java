/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Categoria;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */
@Stateless
@Named("categoriaService")
public class CategoriaService {
    
    @PersistenceContext
    private EntityManager em;
    
    public Categoria save(Categoria tosave){
        return em.merge(tosave);
    }
    
    public List<Categoria> findAll(){
        return em.createNamedQuery(Categoria.FIND_ALL, Categoria.class).getResultList();
    }
    
    public Categoria findById(String categoria){
        List<Categoria> ca= em.createNamedQuery(Categoria.FIND_BY_ID,Categoria.class).setParameter("categoria", categoria).getResultList();
        if(ca.isEmpty())
            return null;
        return  ca.get(0);
    }
    
}
