/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import Modele.Bulletin;
import Modele.*;
import Modele.Connexion;

/**
 *
 * @author Thomas
 */
public class BulletinDao extends Dao<Bulletin> {
    
    public BulletinDao (Connexion connect)
    {
        super (connect);
    }
    
     public boolean create(Bulletin obj) 
    {
        
        try
        {
            String query = "INSERT INTO bulletin ('Appreciation') VALUES (?)";
            PreparedStatement pstmt = (PreparedStatement) connect.remplirChampsRequete(query);
            pstmt.setObject(1, obj.getAppreciation());
            pstmt.executeUpdate();
            return true;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        return false;
        }
    }

    public boolean delete(Bulletin obj) 
    {
        
        try
        {
            String query = "DELETE FROM bulletin WHERE ID =" + obj.getId();
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
   
    public boolean update(Bulletin obj) 
    {
        return false;
    }
    
    
    public Bulletin find(int id) {
      return null;
        
  }
}
