/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modele.*;

/**
 *
 * @author Thomas
 * @param <T>
 * 
 */
public abstract class Dao<T> {
    
    protected Connexion connect = null;
    
    public Dao(Connexion connect)
    {
        this.connect = connect;
    }
    
    public abstract boolean create (T objet);
    
    public abstract  boolean delete (T objet);
    
    public abstract boolean update (T objet);

    
    public abstract T find (int id);
    
    
            
    
}
