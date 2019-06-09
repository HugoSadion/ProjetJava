/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modele.Connexion;
import Modele.Niveau;

/**
 *
 * @author Thomas
 */
public class NiveauDao extends Dao<Niveau>{
    
    public NiveauDao (Connexion connect)
    {
        super(connect);
    }
    
     public boolean create(Niveau obj) 
    {
        return false;
    }

    public boolean delete(Niveau obj) 
    {
        return false;
    }
   
    public boolean update(Niveau obj) 
    {
        return false;
    }
    
    public Niveau find(int id) {
    return null;
  }
    
}