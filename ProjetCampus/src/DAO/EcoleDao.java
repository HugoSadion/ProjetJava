/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modele.Connexion;
import Modele.Ecole;
import java.sql.SQLException;

/**
 *
 * @author Thomas
 */
public class EcoleDao extends Dao<Ecole> {

    public EcoleDao(Connexion connect) {
        super(connect);
    }

    public boolean create(Ecole obj) {
        try
        {
            String query = "INSERT INTO ecole (nom) VALUES ('"+obj.getNom()+"')";
            this.getConnexion().executeUpdate(query);
            return true;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return false;
        }
        
    }

    public boolean delete(Ecole obj) {
        try
        {
            String query = "DELETE FROM ecole WHERE ID ="+obj.getId();
            this.getConnexion().executeUpdate(query);
            return true;
        }
        catch(SQLException ex)
        {
            return false;
        }
        
    }

    public boolean update(Ecole obj) {
        return false;
    }

    public Ecole find(int id) {
        return null;
    }

}
