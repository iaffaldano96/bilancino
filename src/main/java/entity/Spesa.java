/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tss
 */
@NamedQueries({
    @NamedQuery(name = Spesa.FIND_BY_ID,
            query = "select s from Spesa s where s.id= :id_spesa"),
    @NamedQuery(name = Spesa.FIND_BY_USER,
            query = "select s from Spesa s where s.utente= :id_utente"),
    @NamedQuery(name = Spesa.FIND_BY_CATEGORIA,
            query = "select s from Spesa s where s.categoria= :categoria"),
    @NamedQuery(name = Spesa.FIND_BY_DATA,
            query = "SELECT s FROM Spesa s where s.dataSalvato= :data_creato")
})

@Entity
@Table(name = "spesa")
public class Spesa implements Serializable {

    public static final String FIND_BY_USER = "Spesa.findByUser";
    public static final String FIND_BY_ID = "Spesa.findById";
    public static final String FIND_BY_DATA = "Spesa.findByData";
    public static final String FIND_BY_CATEGORIA="Spesa.findByCategoria";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DATA_CREATO")
    @Temporal(TemporalType.TIMESTAMP) //per dire che è un campo data
    private Date dataSalvato = new Date();

    @Column(nullable = false)
    private double importo;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Categoria categoria;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false) // il JOIN quando fanno parte della relazione
    private Utente utente;

    private String descrizione;

    public Spesa() {
    }

    public Spesa(double importo, Categoria categoria, Utente utente, String descrizione) {
        this.importo = importo;
        this.categoria = categoria;
        this.utente = utente;
        this.descrizione = descrizione;
    }

    public Spesa(double importo, Categoria categoria, Utente utente) {
        this.importo = importo;
        this.categoria = categoria;
        this.utente = utente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataSalvato() {
        return dataSalvato;
    }

    public void setDataSalvato(Date dataSalvato) {
        this.dataSalvato = dataSalvato;
    }

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final Spesa other = (Spesa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Spesa{" + "id=" + id + ", dataSalvato=" + dataSalvato + ", importo=" + importo + ", categoria=" + categoria + ", utente=" + utente + ", descrizione=" + descrizione + '}';
    }

}
