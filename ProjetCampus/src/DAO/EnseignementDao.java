/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modele.Connexion;
import java.sql.*;
import Modele.Enseignement;
/**
 *
 * @author Thomas
 */
public class EnseignementDao extends Dao<Enseignement>{
    
    public EnseignementDao (Connexion connect)
    {
        super(connect);
    }
    
     public boolean create(Enseignement obj) 
    {
        try
        {
            String query = "INSERT INTO enseignement (IDClasse, IDDiscipline, IDPersonne) VALUES ("+obj.getIdCLasse()+","+obj.getIdDiscipline()+","+obj.getIdPersonne()+")";
            this.getConnexion().executeUpdate(query);
            return true;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return false;
        }
        
    }

    public boolean delete(Enseignement obj) 
    {
        try
        {
           String query = "DELETE FROM enseignement WHERE ID ="+ obj.getId();
           this.getConnexion().executeUpdate(query);
           return true;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return false;
        }
        
        
    }
   
    public boolean update(Enseignement obj) 
    {
        return false;
    }
    
    public Enseignement find (int id)
    {    
        return null;
        
    }
    
}
