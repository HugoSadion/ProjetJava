/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modele.Connexion;
import Modele.Inscription;

/**
 *
 * @author Thomas
 */
public class InscriptionDao extends Dao<Inscription>{
    
    public InscriptionDao (Connexion connect)
    {
        super(connect);
    }
    
     public boolean create(Inscription obj) 
    {
        return false;
    }

    public boolean delete(Inscription obj) 
    {
        return false;
    }
   
    public boolean update(Inscription obj) 
    {
        return false;
    }
    
    public Inscription find(int id) {
    return null;
  }
    
}