/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Authors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tsutenkyo
 */
@Stateless
public class AuthorsFacade extends AbstractFacade<Authors> {

    @PersistenceContext(unitName = "WebAppAPIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AuthorsFacade() {
        super(Authors.class);
    }
    
    // Add a method to tell the entity manager to persist (save) an author to the database
    public void persistAuthors(Authors authors){
        em.persist(authors); 
    }
    
}
