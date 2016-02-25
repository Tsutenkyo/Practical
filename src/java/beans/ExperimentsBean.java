/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Experiments;
import entities.Organisms;
import facades.ExperimentsFacade;
import facades.OrganismsFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Tsutenkyo
 */
@Named(value = "experimentsBean")
@RequestScoped
public class ExperimentsBean {

    /**
     * Creates a new instance of IndexBean
     */
    @EJB
    private ExperimentsFacade experimentsEJB = new ExperimentsFacade();
    
        /**
     * @return the experimentsEJB
     */
    public ExperimentsFacade getExperimentsEJB() {
        return experimentsEJB;
    }
    
    // Retriveing data from the experimentsEJB and store the data in
    private List<Experiments> experiments;
    
    public List<Experiments> getExperiments(){
        experiments = getExperimentsEJB().findAll();
        return experiments; 
    }
    
    
    @EJB // Dependency injector, only applies to the next line
    private OrganismsFacade organismsEJB = new OrganismsFacade();
    
        /**
     * @return the organismsEJB
     */
    public OrganismsFacade getOrganismsEJB() {
        return organismsEJB;
    }   
    
    // Retriveing data from the organismsEJB and store the data in
    private List<Organisms> organisms;
    
    public List<Organisms> getOrganisms(){
        organisms = getOrganismsEJB().findAll();
        return organisms; 
    }

    // Information about the new experiment entered in the web page's form will be stored in this object
    private Experiments novelExperiment = new Experiments();
    
    /**
     * @return the novelExperiment
     */
    public Experiments getNovelExperiment() {
        return novelExperiment;
    }

    /**
     * @param novelExperiment the novelExperiment to set
     */
    public void setNovelExperiment(Experiments novelExperiment) {
        this.novelExperiment = novelExperiment;
    }
    

    // Variable to store the chosen organism name
    private String selectedOrganismName;
    
    /**
     * @return the selectedOrganismName
     */
    public String getSelectedOrganismName() {
        return selectedOrganismName;
    }

    /**
     * @param selectedOrganismName the selectedOrganismName to set
     */
    public void setSelectedOrganismName(String selectedOrganismName) {
        this.selectedOrganismName = selectedOrganismName;
    }
    
    //Method to tell the ExperimentsFacade from facades to persist the stored experiment data
    public void insertExperiment(){
        novelExperiment.setOrganism(organismsEJB.find(selectedOrganismName)); 
        experimentsEJB.persistExperiments(novelExperiment);
    }
    
    /**
     * Creates a new instance of Experiments
     */
    public ExperimentsBean() {
    }
    
}
