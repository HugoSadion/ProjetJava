/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import Modele.Classe;
import Modele.Connexion;

/**
 *
 * @author Thomas
 */
public class ClasseDao extends Dao<Classe>{
    
     public ClasseDao (Connexion connect)
    {
        super (connect);
    }
    
     public boolean create(Classe obj) 
    {
        try
        {
            String query = "INSERT INTO classe (Nom, IDEcole, IDAnneeScolaire) VALUES ('"+obj.getnom()+"',"+obj.getIdEcole() +","+obj.getIdAnneeScolaire()+ ")";
            this.getConnexion().executeUpdate(query);
            return true;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
           return false; 
        }
        
    }

    public boolean delete(Classe obj) 
    {
        
        try
        {
            String query = "DELETE FROM classe WHERE ID ="+obj.getID();
            this.getConnexion().executeUpdate(query);
            return true;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return false;
        }
        
    }
   
    public boolean update(Classe obj) 
    {
        return false;
    }
    
    public Classe find(int id) {
    return null;
  }
}
