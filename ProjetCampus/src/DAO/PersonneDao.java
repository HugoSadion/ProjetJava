/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.awt.*;
import java.util.*;
import java.sql.*;
import java.sql.SQLException;



import Modele.Connexion;
import Modele.Personne;

/**
 *
 * @author Thomas
 */
public class PersonneDao extends Dao<Personne>{

    
    public PersonneDao (Connexion connect)
    {
        super(connect);
    }
    
     public boolean create(Personne obj) 
    {

        try
        {

            String query = "INSERT INTO personne (Nom, Prenom, Type) VALUES ('"+obj.getNom()+" ',' "+obj.getPrenom()+ "','"+obj.getType()+" ')";
            this.getConnexion().executeUpdate(query);
            return true;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return false;
        }



    }

    public boolean delete(Personne obj) 
    {
        return false;
    }


    public boolean update (Personne obj)
    {

        try
        {

            String query = "UPDATE personne SET IdClasse= "+obj.getIdClasse()+" WHERE(Nom='"+obj.getNom()+"')";
            System.out.println(query);
            this.getConnexion().executeUpdate(query);
            return true;
        }
        catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        }


    }
    
    public Personne find(int id) {
    return null;
  }
    
}