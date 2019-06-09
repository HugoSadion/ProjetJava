/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modele.Connexion;
import Modele.DetailBulletin;
import java.sql.*;
import java.util.ArrayList;

import java.sql.SQLException;

/**
 *
 * @author Thomas
 */
public class DetailBulletinDao extends Dao<DetailBulletin>{
    
    public DetailBulletinDao (Connexion connect)
    {
        super(connect);
    }

    public DetailBulletinDao() {
        super();
    }

    public boolean create(DetailBulletin obj)
    {
        try
        {
                String query = "INSERT INTO detailbulletin (IDEleve, IDEnseignement,IdBulletin) VALUES ("+obj.getIdEleve()+","+obj.getIdEnseignement()+","+obj.getIdBulletin()+")";
                //System.out.println(query);
                this.getConnexion().executeUpdate(query);
                return true;}


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
        try
        {
            String query1 ="SELECT MAX(ID) FROM detailbulletin WHERE IDEleve="+obj.getIdEleve()+" AND IDEnseignement="+obj.getIdEnseignement()+" AND IDBulletin="+obj.getIdBulletin();
            String result1 = connect.remplirChampsRequete(query1).get(0).toString();
            int id = Integer.valueOf(result1.trim());
            String query = "UPDATE detailbulletin SET Appreciation_matiere='"+obj.getAppreciation_matiere()+"', Note_Matiere="+obj.getNote_matiere()+" WHERE IDEleve="+obj.getIdEleve()+" AND IDEnseignement="+obj.getIdEnseignement()+" AND IDBulletin="+obj.getIdBulletin()+" AND ID="+id;
            this.getConnexion().executeUpdate(query);
            return true;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return false;
        }
    }
    
    public DetailBulletin find(int id){
    return null;
  }

  public int recup_id_enseign (int id_matiere, int id_prof, int id_classe){

        try
        {

        String query = "SELECT ID FROM enseignement WHERE IDClasse="+id_classe+" AND IDDiscipline="+id_matiere+" AND IDPersonne="+id_prof;
        String result2 = connect.remplirChampsRequete(query).get(0).toString();
        int id_enseignement = Integer.parseInt(result2.trim());
        return id_enseignement;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return 0;
        }



    }

    public int recup_notes (int id_eleve, int id_matiere, int trimestre, int annee){

        try
        {

            String query = "SELECT Note FROM evaluation WHERE IdEleve="+id_eleve+" AND IDMatiere="+id_matiere+" AND Trimestre="+trimestre+" AND Annee="+annee;
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


    public String recup_appreciation (int id_eleve, int id_matiere, int trimestre, int annee){

        try
        {

            String query = "SELECT Appreciation FROM evaluation WHERE IdEleve="+id_eleve+" AND IDMatiere="+id_matiere+" AND Trimestre="+trimestre+" AND Annee="+annee;
            String result2 = connect.remplirChampsRequete(query).get(0).toString();
            return result2;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return "";
        }



    }


    public int recup_idClasse(int id_eleve){

        try
        {
            //recupération de l'id classe de l'éleve à partir de son identifiant

            String query1 = "SELECT IdClasse FROM Personne WHERE (ID="+id_eleve+") ";
            String result1 = connect.remplirChampsRequete(query1).get(0).toString();
            int id_classe = Integer.valueOf(result1.trim());
            return id_classe;


        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return 0;
        }


    }

    public int recup_idprof(int matiere, int id_classe){

        try
        {
            //recupération de l'id classe de l'éleve à partir de son identifiant

            String query1 = "SELECT ID FROM Personne WHERE IdClasse="+id_classe+" AND IdMatiere="+matiere ;
            String result1 = connect.remplirChampsRequete(query1).get(0).toString();
            int id_prof = Integer.valueOf(result1.trim());
            return id_prof;


        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return 0;
        }


    }

    public String recup_nom_prof(int id_prof){

        try
        {
            //recupération du nom du prof à partir de son identifiant
            String query1 = "SELECT Nom FROM Personne WHERE (ID="+id_prof+") ";
            String result1 = connect.remplirChampsRequete(query1).get(0).toString();
            String nom_prof = result1;
            return nom_prof;


        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return "null";
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

}