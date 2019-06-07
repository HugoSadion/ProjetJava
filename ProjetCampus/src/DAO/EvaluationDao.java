/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modele.Connexion;
import Modele.Evaluation;
import java.sql.SQLException;

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
        try
        {
            String query = "INSERT INTO evaluation (IDMatiere, Note, idEleve) VALUES ("+obj.getIdMatiere()+","+obj.getNote()+","+obj.getIdEleve()+")";
            this.getConnexion().executeUpdate(query);
            return true;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
           return false; 
        }
        
    }

    public boolean delete(Evaluation obj) 
    {
        try
        {
            String query = "DELETE FROM evaluation WHERE ID =" +obj.getId();
            this.getConnexion().executeUpdate(query);
            return true;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return false;
        }
        
    }
   
    public boolean update(Evaluation obj) 
    {
        return false;
    }
    
    public Evaluation find(int id) {
    return null;
  }
    
}