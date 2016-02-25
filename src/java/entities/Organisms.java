/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tsutenkyo
 */
@Entity
@Table(name = "organisms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Organisms.findAll", query = "SELECT o FROM Organisms o"),
    @NamedQuery(name = "Organisms.findByOrganism", query = "SELECT o FROM Organisms o WHERE o.organism = :organism"),
    @NamedQuery(name = "Organisms.findByIsFungus", query = "SELECT o FROM Organisms o WHERE o.isFungus = :isFungus")})
public class Organisms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "organism")
    private String organism;
    @Column(name = "is_fungus")
    private Boolean isFungus;
    @OneToMany(mappedBy = "organism")
    private Collection<Experiments> experimentsCollection;

    public Organisms() {
    }

    public Organisms(String organism) {
        this.organism = organism;
    }

    public String getOrganism() {
        return organism;
    }

    public void setOrganism(String organism) {
        this.organism = organism;
    }

    public Boolean getIsFungus() {
        return isFungus;
    }

    public void setIsFungus(Boolean isFungus) {
        this.isFungus = isFungus;
    }

    @XmlTransient
    public Collection<Experiments> getExperimentsCollection() {
        return experimentsCollection;
    }

    public void setExperimentsCollection(Collection<Experiments> experimentsCollection) {
        this.experimentsCollection = experimentsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (organism != null ? organism.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organisms)) {
            return false;
        }
        Organisms other = (Organisms) object;
        if ((this.organism == null && other.organism != null) || (this.organism != null && !this.organism.equals(other.organism))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "entities.Organisms[ organism=" + organism + " ]";
        return organism;
    }
    
}
