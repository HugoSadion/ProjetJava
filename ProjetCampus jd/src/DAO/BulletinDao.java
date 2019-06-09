/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import java.util.ArrayList;

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
            pstmt.executeUpdate(query);
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


    public int recup_moyenne_generale (int id_eleve, int trimestre, int annee){

        try
        {

            String query = "SELECT Note FROM evaluation WHERE IdEleve="+id_eleve+" AND Trimestre="+trimestre+" AND Annee="+annee;
            //for (int i=0, i<)
            ArrayList<String> result2 = new ArrayList<String>();

            result2 = connect.remplirChampsRequete(query);
            int somme_notes = 0;
            for (int i=0; i<result2.size(); i++){

                somme_notes = somme_notes + Integer.parseInt(result2.get(i).trim());

            }
            int moyenne_matière=somme_notes/result2.size();
            return moyenne_matière;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return 0;
        }



    }



    public void afficher_nom_eleve (int id_eleve){
        try
        {
            //recupération du nom du prof à partir de son identifiant
            String query1 = "SELECT Nom FROM Personne WHERE (ID="+id_eleve+") ";
            String nom = connect.remplirChampsRequete(query1).get(0).toString();
            String query2 = "SELECT Prenom FROM Personne WHERE (ID="+id_eleve+") ";
            String prenom = connect.remplirChampsRequete(query2).get(0).toString();
            System.out.println(prenom+" "+nom);
            String query3 = "SELECT IdClasse FROM Personne WHERE (ID="+id_eleve+") ";
            String id_classe_string = connect.remplirChampsRequete(query3).get(0).toString();
            int id_classe = Integer.valueOf(id_classe_string.trim());
            String query4 ="SELECT NomEcole FROM classe WHERE (ID="+id_classe+") ";
            String ecole = connect.remplirChampsRequete(query4).get(0).toString();
            System.out.println("ECOLE :"+ecole);
            String query5 ="SELECT Nom FROM classe WHERE (ID="+id_classe+") ";
            String nom_classe = connect.remplirChampsRequete(query5).get(0).toString();
            System.out.println("Classe :"+nom_classe);


        }
        catch (SQLException ex)
        {
            ex.printStackTrace();

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
