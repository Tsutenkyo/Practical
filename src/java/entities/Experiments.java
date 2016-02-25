/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "experiments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Experiments.findAll", query = "SELECT e FROM Experiments e"),
    @NamedQuery(name = "Experiments.findByExperimentId", query = "SELECT e FROM Experiments e WHERE e.experimentId = :experimentId"),
    @NamedQuery(name = "Experiments.findByMedium", query = "SELECT e FROM Experiments e WHERE e.medium = :medium")})
public class Experiments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "experiment_id")
    private String experimentId;
    @Size(max = 10)
    @Column(name = "medium")
    private String medium;
    @ManyToMany(mappedBy = "experimentsCollection")
    private Collection<Authors> authorsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "experiments")
    private Collection<Datapoints> datapointsCollection;
    @JoinColumn(name = "organism", referencedColumnName = "organism")
    @ManyToOne
    private Organisms organism;

    public Experiments() {
    }

    public Experiments(String experimentId) {
        this.experimentId = experimentId;
    }

    public String getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(String experimentId) {
        this.experimentId = experimentId;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    @XmlTransient
    public Collection<Authors> getAuthorsCollection() {
        return authorsCollection;
    }

    public void setAuthorsCollection(Collection<Authors> authorsCollection) {
        this.authorsCollection = authorsCollection;
    }

    @XmlTransient
    public Collection<Datapoints> getDatapointsCollection() {
        return datapointsCollection;
    }

    public void setDatapointsCollection(Collection<Datapoints> datapointsCollection) {
        this.datapointsCollection = datapointsCollection;
    }

    public Organisms getOrganism() {
        return organism;
    }

    public void setOrganism(Organisms organism) {
        this.organism = organism;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (experimentId != null ? experimentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Experiments)) {
            return false;
        }
        Experiments other = (Experiments) object;
        if ((this.experimentId == null && other.experimentId != null) || (this.experimentId != null && !this.experimentId.equals(other.experimentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Experiments[ experimentId=" + experimentId + " ]";
    }
    
}
