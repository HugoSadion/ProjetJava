/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modele.Connexion;
import Modele.DetailBulletin;
import java.sql.*;

/**
 *
 * @author Thomas
 */
public class DetailBulletinDao extends Dao<DetailBulletin>{
    
    public DetailBulletinDao (Connexion connect)
    {
        super(connect);
    }
    
     public boolean create(DetailBulletin obj) 
    {
        try
        {
            String query = "INSERT INTO detailbulletin ('IDBulletin', 'IDEnseignement', 'Appreciation' VALUES (?, ?, ?)";
            PreparedStatement pstms = (PreparedStatement) connect.remplirChampsRequete(query);
            pstms.setObject(1, obj.getIdBulletin());
            pstms.setObject(2, obj.getIdEnseignement());
            pstms.setObject(3, obj.getAppreciation());
            pstms.executeUpdate(query);
            return true;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
           return false; 
        }
        
    }

    public boolean delete(DetailBulletin obj) 
    {
        try
        {
            String query = "DELETE FROM detailbulletin WHERE ID ="+obj.getID();
            PreparedStatement pstms = (PreparedStatement) connect.remplirChampsRequete(query);
            pstms.executeUpdate(query);
            return true;
        }
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            return false;
        }
       
    }
   
    public boolean update(DetailBulletin obj) 
    {
        return false;
    }
    
    public DetailBulletin find(int id) {
    return null;
  }
    
}