/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Tsutenkyo
 */
@Embeddable
public class DatapointsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "experiment_id")
    private String experimentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time")
    private double time;

    public DatapointsPK() {
    }

    public DatapointsPK(String experimentId, double time) {
        this.experimentId = experimentId;
        this.time = time;
    }

    public String getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(String experimentId) {
        this.experimentId = experimentId;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (experimentId != null ? experimentId.hashCode() : 0);
        hash += (int) time;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatapointsPK)) {
            return false;
        }
        DatapointsPK other = (DatapointsPK) object;
        if ((this.experimentId == null && other.experimentId != null) || (this.experimentId != null && !this.experimentId.equals(other.experimentId))) {
            return false;
        }
        if (this.time != other.time) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DatapointsPK[ experimentId=" + experimentId + ", time=" + time + " ]";
    }
    
}
