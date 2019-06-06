/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modele.Connexion;
import Modele.Evaluation;

/**
 *
 * @author Thomas
 */
public class EvaluationDao extends Dao<Evaluation>{
    
    public EvaluationDao (Connexion connect)
    {
        super(connect);
    }
    
     public boolean create(Evaluation obj) 
    {
        return false;
    }

    public boolean delete(Evaluation obj) 
    {
        return false;
    }
   
    public boolean update(Evaluation obj) 
    {
        return false;
    }
    
    public Evaluation find(int id) {
    return null;
  }
    
}