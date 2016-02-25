/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Datapoints;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tsutenkyo
 */
@Stateless
public class DatapointsFacade extends AbstractFacade<Datapoints> {

    @PersistenceContext(unitName = "WebAppAPIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DatapointsFacade() {
        super(Datapoints.class);
    }
    
    // Add a method to tell the entity manager to persist (save) datapoints to the database
    public void persistDatapoints(Datapoints datapoints){
        em.persist(datapoints); 
    }
    
}
