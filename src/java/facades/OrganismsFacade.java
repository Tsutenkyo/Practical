/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Organisms;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tsutenkyo
 */
@Stateless
public class OrganismsFacade extends AbstractFacade<Organisms> {

    @PersistenceContext(unitName = "WebAppAPIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrganismsFacade() {
        super(Organisms.class);
    }
    
    // Add a method to tell the entity manager to persist (save) a new organism to the database
    public void persistOrganisms(Organisms organisms){
        em.persist(organisms); 
    }
    
}
