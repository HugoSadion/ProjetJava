/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modele.Connexion;
import Modele.Evaluation;
import com.mysql.jdbc.PreparedStatement;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Thomas
 */
public class EvaluationDao extends Dao<Evaluation>{
    
    public EvaluationDao (Connexion connect)
    {
        super(connect);
    }
    
     public boolean create(Evaluation obj) 
    {

        try
        {
            String query = "INSERT INTO evaluation (IDMatiere,Note,idEleve,Trimestre,Annee) VALUES ("+obj.getIdDetailBulletin()+","+obj.getNote()+","+obj.getIdEleve()+","+obj.getTrimestre()+","+obj.getAnnee()+")";
            this.getConnexion().executeUpdate(query);
            //pstmt.executeUpdate(query);
            return true;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean delete(Evaluation obj) 
    {
        return false;
    }
   
    public boolean update(Evaluation obj) 
    {
        return false;
    }
    
    public Evaluation find(int id) {
    return null;
  }

    public void recup_notes_matiere (int id_eleve, int id_matiere, int trimestre, int annee){

        try
        {

            String query = "SELECT Note FROM evaluation WHERE IdEleve="+id_eleve+" AND IDMatiere="+id_matiere+" AND Trimestre="+trimestre+" AND Annee="+annee;
            //for (int i=0, i<)
            ArrayList<String> result2 = new ArrayList<String>();

            result2 = connect.remplirChampsRequete(query);
            int somme_notes = 0;
            for (int i=0; i<result2.size(); i++){
                System.out.println(" => "+Integer.parseInt(result2.get(i).trim()));
                somme_notes = somme_notes + Integer.parseInt(result2.get(i).trim());

            }
            int moyenne_matière=somme_notes/result2.size();
            System.out.println("Moyenne de la matière : "+moyenne_matière);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }



    }
    
}