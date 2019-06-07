/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modele.Connexion;
import Modele.Trimestre;
import java.sql.SQLException;

/**
 *
 * @author Thomas
 */
public class TrimestreDao extends Dao<Trimestre>{
    
    public TrimestreDao (Connexion connect)
    {
        super(connect);
    }
    
     public boolean create(Trimestre obj) 
    {
        try
        {
            String query = "INSERT INTO trimstre (Numero, Debut, Fin, AnneeScolaire) VALUES ("+obj.getNumero()+",'"+obj.getDebut()+"','"+obj.getFin()+"',"+obj.getAnneeScolaire()+")";
            this.getConnexion().executeUpdate(query);
            return true;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
          return false;  
        }
        
    }

    public boolean delete(Trimestre obj) 
    {
        return false;
    }
   
    public boolean update(Trimestre obj) 
    {
        return false;
    }
    
    public Trimestre find(int id) {
    return null;
  }
    
}
