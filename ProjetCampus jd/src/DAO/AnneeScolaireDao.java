/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import java.util.ArrayList;

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

  public float recup_moyenne_classe (Connexion connect,int matiere){

      try
      {
            //liste des notes
          String query = "SELECT Note FROM evaluation WHERE IDMatiere="+matiere;
          ArrayList<String> result2 = new ArrayList<String>();
          result2 = connect.remplirChampsRequete(query);
          int somme_notes = 0;
          System.out.println("Voila le détail des notes : ");
          for (int i=0; i<result2.size(); i++){
              System.out.println("=>"+Integer.parseInt(result2.get(i).trim()));
              somme_notes = somme_notes + Integer.parseInt(result2.get(i).trim());
          }
          int nombre_note=result2.size();
          System.out.println("Il y a "+nombre_note+" notes pour cette matière.");
          float moyenne_matière=(float)somme_notes/nombre_note;

          System.out.println("-----------------------------");

          //nombres de personne au dessus et en dessous de la moyenne avec la moyenne
          //dessous
          String query2 ="SELECT Note FROM evaluation WHERE IDMatiere="+matiere+" AND Note<9";
          ArrayList<String> result1 = new ArrayList<String>();
          result1 = connect.remplirChampsRequete(query2);
          int moyenne_dessous = 0;
          System.out.println("Voici le détail des notes en dessous de la moyenne :");
          for (int i=0; i<result1.size(); i++){
              System.out.println("=>"+Integer.parseInt(result1.get(i).trim()));
          }
          int nombre_dessous = result1.size();
          System.out.println(nombre_dessous+" élèves ont en dessous de la moyenne");
          float propo_dessous = (float)nombre_dessous/nombre_note;
          float pourcentage = (float)propo_dessous*100;
          System.out.println(pourcentage+"% des élèves ont eu en dessous de la moyenne");

          System.out.println("-- -- -- -- -- -- -- -- -- --");

          //dessus
          String query3 ="SELECT Note FROM evaluation WHERE IDMatiere="+matiere+" AND Note>9";
          ArrayList<String> result3 = new ArrayList<String>();
          result3 = connect.remplirChampsRequete(query3);
          int moyenne_dessus = 0;
          System.out.println("Voici le détail des notes au dessus de la moyenne :");
          for (int i=0; i<result3.size(); i++){
              System.out.println("=>"+Integer.parseInt(result3.get(i).trim()));
          }
          int nombre_dessus = result3.size();
          System.out.println(nombre_dessus+" élèves ont en dessus de la moyenne");
          float propo_dessus = (float)nombre_dessus/nombre_note;
          float pourcentage_dessus = (float)propo_dessus*100;
          System.out.println(pourcentage_dessus+"% des élèves ont eu au dessus de la moyenne");

          System.out.println("-----------------------------");


          return moyenne_matière;
      }
      catch (SQLException ex)
      {
          ex.printStackTrace();
          return 0;
      }

  }
    
}
