/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Authors;
import facades.AuthorsFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Tsutenkyo
 */
@Named(value = "authorsBean")
@RequestScoped
public class AuthorsBean {

    /**
     * Creates a new instance of IndexBean
     */
    @EJB
    private AuthorsFacade authorsEJB = new AuthorsFacade();

    /**
     * @return the authorsEJB
     */
    public AuthorsFacade getAuthorsEJB() {
        return authorsEJB;
    }
    
    
    // Retriveing data from the authorsEJB and store the data in
    private List<Authors> authors;
    
    public List<Authors> getAuthors(){
        authors = getAuthorsEJB().findAll();
        return authors; 
    }
    

    // Information about the new experiment entered in the web page's form will be stored in this object
    private Authors newAuthor = new Authors();
    
    /**
     * @return the newAuthor
     */
    public Authors getNewAuthor() {
        return newAuthor;
    }

    /**
     * @param newAuthor the newAuthor to set
     */
    public void setNewAuthor(Authors newAuthor) {
        this.newAuthor = newAuthor;
    }
    

    // Variable to store the chosen author name from the list
    private String selectedAuthorName;
    
    /**
     * @return the selectedAuthorName
     */
    public String getSelectedAuthorName() {
        return selectedAuthorName;
    }

    /**
     * @param selectedAuthorName the selectedAuthorName to set
     */
    public void setSelectedAuthorName(String selectedAuthorName) {
        this.selectedAuthorName = selectedAuthorName;
    }
        
    //Method to tell the AuthorsFacade to persist the stored author info
    public void insertAuthor(){
        authorsEJB.persistAuthors(newAuthor);
    }
    /**
     * Creates a new instance of AuthorsBean
     */
    public AuthorsBean() {
    }
    
}
