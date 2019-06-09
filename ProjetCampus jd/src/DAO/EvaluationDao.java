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
    
}