/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Datapoints;
import entities.DatapointsPK;
import entities.Experiments;
import facades.DatapointsFacade;
import facades.ExperimentsFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Tsutenkyo
 */
@Named(value = "datapointsBean")
@RequestScoped
public class DatapointsBean {

    /**
     * Creates a new instance of IndexBean
     */
    @EJB
    private DatapointsFacade datapointsEJB = new DatapointsFacade();

    public DatapointsFacade getDatapointsEJB() {
        return datapointsEJB;
    }
    
    // Retriveing datapoints from the DatapointsEJB and store the data in
    private List<Datapoints> datapoints;
    
    public List<Datapoints> getDatapoints(){
        datapoints = getDatapointsEJB().findAll();
        return datapoints; 
    }
    
    @EJB // Dependency injector, only applies to the next line
    private ExperimentsFacade experimentsEJB = new ExperimentsFacade();
    
        /**
     * @return the organismsEJB
     */
    public ExperimentsFacade getExperimentsEJB() {
        return experimentsEJB;
    }   
    
    // Retriveing data from the organismsEJB and store the data in
    private List<Experiments> experiments;
    
    public List<Experiments> getExperiments(){
        experiments = getExperimentsEJB().findAll();
        return experiments; 
    }
    
    // Variable to store the chosen organism name
    private String selectedExperimentID;
    
    /**
     * @return the selectedExperimentID
     */
    public String getSelectedExperimentID() {
        return selectedExperimentID;
    }

    /**
     * @param selectedExperimentID the selectedOrganismName to set
     */
    public void setSelectedExperimentID(String selectedExperimentID) {
        this.selectedExperimentID = selectedExperimentID;
    }
    

    // Information about the new experiment entered in the web page's form will be stored in this object
    private Datapoints newDatapoints = new Datapoints(new DatapointsPK()); // To set the datapointsPK in Datapoints
    
    
    /**
     * @return the newDatapoints
     */
    public Datapoints getNewDatapoints() {
        return newDatapoints;
    }
    
    /**
     * @param newDatapoints the newDatapoints to set
     */
    public void setNewDatapoints(Datapoints newDatapoints) {
        this.newDatapoints = newDatapoints;
    }
    
    
    //Method to tell the ExperimentsFacade from facades to persist the stored experiment data
    public void newDatapoint(){
        newDatapoints.setExperiments(experimentsEJB.find(selectedExperimentID));
        newDatapoints.getDatapointsPK().setExperimentId(selectedExperimentID);  // connect DatapointsPK to its experiemtn ID
        datapointsEJB.persistDatapoints(newDatapoints);
    }
    
    /**
     * Creates a new instance of DatapointsBean
     */
    public DatapointsBean() {
    }
    
}
