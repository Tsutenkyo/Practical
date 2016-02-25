/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Experiments;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Tsutenkyo
 */
@Named(value = "experimentViewBean")
@RequestScoped
public class ExperimentViewBean {

    // Initialise variable
    private Experiments experiment;
    
    /**
     * Creates a new instance of ExperimentViewBean
     */
    public ExperimentViewBean() {
    }

    /**
     * @return the experiment
     */
    public Experiments getExperiment() {
        return experiment;
    }

    /**
     * @param experiment the experiment to set
     */
    public void setExperiment(Experiments experiment) {
        this.experiment = experiment;
    }
    
}
