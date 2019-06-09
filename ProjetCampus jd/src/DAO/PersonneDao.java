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

            String query = "INSERT INTO personne (Nom, Prenom, Type) VALUES ('"+obj.getNom()+"' , '"+obj.getPrenom()+ "','"+obj.getType()+"')";
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
            this.getConnexion().executeUpdate(query);
            return true;
        }
        catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        }


    }


    public boolean update_prof (Personne obj)
    {

        try
        {

            String query = "UPDATE personne SET IdClasse= "+obj.getIdClasse()+",IdMatiere="+obj.getId_matiere()+" WHERE(Nom='"+obj.getNom()+"')";
            this.getConnexion().executeUpdate(query);
            return true;
        }
        catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        }


    }




    public boolean ajouter_enseignement (Personne obj,int id){

        try
        {

            String query = "INSERT INTO enseignement (IDClasse, IDDiscipline, IDPersonne) VALUES ('"+obj.getIdClasse()+"' , '"+obj.getId_matiere()+ "','"+id+"')";
            this.getConnexion().executeUpdate(query);
            return true;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return false;
        }

    }


    public int recup_gdID (){

            try
            {

                String query = "SELECT MAX(ID) FROM personne";
                String result2 = connect.remplirChampsRequete(query).get(0).toString();
                int id = Integer.parseInt(result2.trim());
                return id;
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
                return 0;
            }





    }
    
    public Personne find(int id) {
    return null;
  }
    
}