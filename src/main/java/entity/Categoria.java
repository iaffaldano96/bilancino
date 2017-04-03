/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@NamedQueries({
    @NamedQuery(name = Categoria.FIND_BY_ID,
        query = "SELECT c from Categoria c WHERE c.categoria= :categoria"),
    @NamedQuery(name = Categoria.FIND_ALL,
            query = "SELECT c from Categoria c order by c.categoria")
})
@Entity
public class Categoria implements Serializable{

    public static final String FIND_BY_ID ="Categoria.findById";
    public static final String FIND_ALL="Categoria.findAll";
    
    @Id
    private String categoria;

    public Categoria() {
    }

    public Categoria(String id) {
        this.categoria = id;
    }    
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.categoria);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categoria other = (Categoria) obj;
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Categoria{" + "categoria=" + categoria + '}';
    }        
    
}
