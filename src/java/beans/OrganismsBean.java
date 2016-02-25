/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Organisms;
import facades.OrganismsFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Tsutenkyo
 */
@Named(value = "organismsBean")
@RequestScoped
public class OrganismsBean {

    /**
     * Creates a new instance of IndexBean
     */
    @EJB
    private OrganismsFacade organismsEJB = new OrganismsFacade();

    public OrganismsFacade getOrganismsEJB() {
        return organismsEJB;
    }
    
    // Retriveing datapoints from the DatapointsEJB and store the data in
    private List<Organisms> organisms;
    
    public List<Organisms> getOrganisms(){
        organisms = getOrganismsEJB().findAll();
        return organisms; 
    }
       
    // Variable to store the chosen organism name
    private Boolean selectedIsFungus;
    
    /**
     * @return the selectedIsFungus
     */
    public Boolean getSelectedIsFungus() {
        return selectedIsFungus;
    }

    /**
     * @param selectedIsFungus the selectedOrganismName to set
     */
    public void setSelectedIsFungus(Boolean selectedIsFungus) {
        this.selectedIsFungus = selectedIsFungus;
    }
    

    // Information about the new experiment entered in the web page's form will be stored in this object
    private Organisms newOrganism = new Organisms();
    
    
    /**
     * @return the newDatapoints
     */
    public Organisms getNewOrganism() {
        return newOrganism;
    }
    
    /**
     * @param newOrganism the newDatapoints to set
     */
    public void setNewOrganism(Organisms newOrganism) {
        this.newOrganism = newOrganism;
    }
    
    
    //Method to tell the ExperimentsFacade from facades to persist the stored experiment data
    public void newDatapoint(){
        newOrganism.setIsFungus(selectedIsFungus);
        organismsEJB.persistOrganisms(newOrganism);
    }
    /**
     * Creates a new instance of OrganismsBean
     */
    public OrganismsBean() {
    }
    
}
