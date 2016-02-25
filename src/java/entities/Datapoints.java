/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tsutenkyo
 */
@Entity
@Table(name = "datapoints")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datapoints.findAll", query = "SELECT d FROM Datapoints d"),
    @NamedQuery(name = "Datapoints.findByExperimentId", query = "SELECT d FROM Datapoints d WHERE d.datapointsPK.experimentId = :experimentId"),
    @NamedQuery(name = "Datapoints.findByTime", query = "SELECT d FROM Datapoints d WHERE d.datapointsPK.time = :time"),
    @NamedQuery(name = "Datapoints.findByCfu", query = "SELECT d FROM Datapoints d WHERE d.cfu = :cfu")})
public class Datapoints implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DatapointsPK datapointsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cfu")
    private double cfu;
    @JoinColumn(name = "experiment_id", referencedColumnName = "experiment_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Experiments experiments;

    public Datapoints() {
    }

    public Datapoints(DatapointsPK datapointsPK) {
        this.datapointsPK = datapointsPK;
    }

    public Datapoints(DatapointsPK datapointsPK, double cfu) {
        this.datapointsPK = datapointsPK;
        this.cfu = cfu;
    }

    public Datapoints(String experimentId, double time) {
        this.datapointsPK = new DatapointsPK(experimentId, time);
    }

    public DatapointsPK getDatapointsPK() {
        return datapointsPK;
    }

    public void setDatapointsPK(DatapointsPK datapointsPK) {
        this.datapointsPK = datapointsPK;
    }

    public double getCfu() {
        return cfu;
    }

    public void setCfu(double cfu) {
        this.cfu = cfu;
    }

    public Experiments getExperiments() {
        return experiments;
    }

    public void setExperiments(Experiments experiments) {
        this.experiments = experiments;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datapointsPK != null ? datapointsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datapoints)) {
            return false;
        }
        Datapoints other = (Datapoints) object;
        if ((this.datapointsPK == null && other.datapointsPK != null) || (this.datapointsPK != null && !this.datapointsPK.equals(other.datapointsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Datapoints[ datapointsPK=" + datapointsPK + " ]";
    }
    
}
