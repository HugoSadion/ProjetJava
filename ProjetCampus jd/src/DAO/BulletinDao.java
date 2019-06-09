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
            String query = "INSERT INTO bulletin (ID,Appreciation,Note_generale) VALUES ("+obj.getId()+",'"+obj.getAppreciation()+"',"+obj.getMoyenne_generale()+")";
            this.getConnexion().executeUpdate(query);
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

    public int recup_note (int ID){

        try
        {

            String query = "SELECT Note_general FROM enseignement WHERE ID="+ID;
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

    public void recup_bulletin (int id_eleve, int trimestre, int annee){


        String bul1 = "" + id_eleve + "";
        String bul2 = "" + trimestre + "";
        String bul3 = "" + annee + "";
        String bulletin = bul1 + bul2 + bul3;
        int ID = Integer.parseInt(bulletin);
            System.out.println("Le bulletin a pour identifiant : " + ID);

            BulletinDao bulletinDao=new BulletinDao(connect);
            DetailBulletinDao det_but_dao = new DetailBulletinDao(connect);

            for (int matiere = 1; matiere < 6; matiere++) {


                int id_classe = det_but_dao.recup_idClasse(id_eleve);

                int id_prof = det_but_dao.recup_idprof(matiere, id_classe);

                int id_enseignement = det_but_dao.recup_id_enseign(matiere, id_prof, id_classe);


                DetailBulletin detailBulletin = new DetailBulletin(id_eleve, id_enseignement);

                //Création du détail bulletin

                System.out.println("-------Recapitulatif De la Matiere--------");


                //Affichage de la matiere
                if (matiere == 1) {
                    System.out.println("MATIERE : Francais");
                } else if (matiere == 2) {
                    System.out.println("MATIERE : Geographie");
                } else if (matiere == 3) {
                    System.out.println("MATIERE : Histoire");
                } else if (matiere == 4) {
                    System.out.println("MATIERE : Maths");
                } else if (matiere == 5) {
                    System.out.println("MATIERE : Anglais");
                } else {
                    System.out.println("Erreur matiere");
                }

                //Affichage du professeur
                System.out.println("Professeur : " + det_but_dao.recup_nom_prof(id_prof));
                //Affichage de la moyenne
                System.out.printf("Moyenne : %d/20%n", det_but_dao.recup_notes(id_eleve, matiere, trimestre, annee));
                //Appreciation
                System.out.println("L'appréciation du professeur : " + det_but_dao.recup_appreciation(id_enseignement, ID));
                System.out.println("----------------");

            }

            System.out.println("---------------------------------------------------");
        System.out.println("---------------------------------------------------");

//Generation et récupération de la note grace à id_eleve
            System.out.println("La moyenne générale de l'élève est de : " +bulletinDao.recup_moyenne_generale(id_eleve, trimestre, annee) + "/20");
            //generation et recupération de l'appreciation
            System.out.println("Appreciation générale : " +bulletinDao.recup_appreciation(ID));


    }

    public String recup_appreciation (int ID){

        try
        {

            String query = "SELECT Appreciation FROM bulletin WHERE  ID="+ID;
            String result2 = connect.remplirChampsRequete(query).get(0).toString();
            return result2;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return "";
        }



    }



}
