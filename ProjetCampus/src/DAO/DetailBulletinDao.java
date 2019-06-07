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
            String query = "INSERT INTO detailbulletin (IdBulletin, IDEleve, IDEnseignement, Appreciation_matiere, Note_matiere) VALUES ("+obj.getIdBulletin()+","+obj.getIdEleve()+","+obj.getIdEnseignement()+",'"+obj.getAppreciation_matiere()+"',"+obj.getNote_matiere()+")";
            System.out.println(query);
            this.getConnexion().executeUpdate(query);
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



    public ArrayList<Integer> select (DetailBulletin det_but){

        ArrayList<Integer> notes = new ArrayList<Integer>();
        try
        {
            ArrayList<String> result = new ArrayList<String >();
            result = connect.remplirChampsRequete("SELECT Note FROM evaluation WHERE (idEleve='"+det_but.getIdEleve()+"') AND (IDMatiere='"+det_but.getIdEnseignement()+"')");
            for (int i=0; i<result.size(); i++){
            String res= result.get(i);
            int oo=Integer.parseInt(res);
            System.out.println(oo);
            notes.add(oo);

        }

        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }


        return notes;

        //enseign= new Enseignement( Integer.parseInt(res[0]) , Integer.parseInt(res[1]),Integer.parseInt(res[2]),Integer.parseInt(res[3]));



    }
}