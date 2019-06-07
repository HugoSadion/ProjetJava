/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import Modele.Connexion;
import Modele.Discipline;

/**
 *
 * @author Thomas
 */
public class DisciplineDao extends Dao<Discipline>{
    
    public DisciplineDao (Connexion connect)
    {
        super(connect);
    }
    
     public boolean create(Discipline obj) 
    {
        try
        {
            String query = "INSERT INTO discipline ('Nom') VALUES ('"+obj.getNom()+"')";
            this.getConnexion().executeUpdate(query);
            return true;
        }
        catch(SQLException ex)
        {
            return false;

        }
    }

    public boolean delete(Discipline obj) 
    {
        return false;
    }
   
    public boolean update(Discipline obj) 
    {
        return false;
    }
    
    public Discipline find(int id) {
    return null;
  }
    
}