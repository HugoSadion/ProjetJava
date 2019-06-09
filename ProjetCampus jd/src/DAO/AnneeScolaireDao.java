/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;

import Modele.AnneeScolaire;
import Modele.Connexion;

/**
 *
 * @author Thomas
 */
public class AnneeScolaireDao extends Dao<AnneeScolaire>{
    
    public AnneeScolaireDao (Connexion connect)
    {
        super(connect);
    }
    
    public boolean create (AnneeScolaire obj)
    {
        return false;
        
    }

    public boolean delete(AnneeScolaire obj) 
    {
        try
        {
            String query = "DELETE FROM anneescolaire WHERE ID ="+obj.getId();
            PreparedStatement pstmt = (PreparedStatement) connect.remplirChampsRequete(query);
            pstmt.executeUpdate();
            return true;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return false;
        }
        
        
    }
   
    public boolean update(AnneeScolaire obj) 
    {
        return false;
    }
    
    public AnneeScolaire find(int id) {
    return null;
  }
    
}
