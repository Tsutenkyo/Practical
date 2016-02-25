/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Experiments;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tsutenkyo
 */
@Stateless
public class ExperimentsFacade extends AbstractFacade<Experiments> {

    @PersistenceContext(unitName = "WebAppAPIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExperimentsFacade() {
        super(Experiments.class);
    }
    
    // Add a method to tell the entity manager to persist (save) an experiment to the database
    public void persistExperiments(Experiments experiment){
        em.persist(experiment); 
    }
    
}
