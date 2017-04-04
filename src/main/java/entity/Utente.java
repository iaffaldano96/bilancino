/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tss
 */

@NamedQueries({
    @NamedQuery(name=Utente.FIND_ALL,
            query = "SELECT u from Utente u order by u.usr"),
    @NamedQuery(name=Utente.FIND_BY_USER_PSW,
            query = "SELECT u from Utente u WHERE u.usr= :usr and u.psw= :psw"),
    @NamedQuery(name=Utente.FIND_USER,
            query = "SELECT u from Utente u WHERE u.usr= :usr"),
    @NamedQuery(name=Utente.FIND_BY_ID,
            query = "SELECT u from Utente u WHERE u.id= :id_utente")    
})

@Entity
public class Utente implements Serializable{
    
    public static final String FIND_ALL="Utente.findall";
    public static final String FIND_BY_USER_PSW="Utente.findByUserPsw";
    public static final String FIND_USER="Utente.findUser";
    public static final String FIND_BY_ID="Utente.findById";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
        
    @Column(nullable = false,unique = true)
    private String usr;
 
    @Column(nullable = false)
    private String psw;

    private String email;

    public Utente() {
    }

    public Utente(String usr, String psw, String email) {
        this.usr = usr;
        this.psw = psw;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Utente other = (Utente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Utente{" + "id=" + id + ", usr=" + usr + ", psw=" + psw + ", email=" + email + '}';
    }
        
}
