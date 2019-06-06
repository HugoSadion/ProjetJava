/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modele.Connexion;
import Modele.Ecole;

/**
 *
 * @author Thomas
 */
public class EcoleDao extends Dao<Ecole> {

    public EcoleDao(Connexion connect) {
        super(connect);
    }

    public boolean create(Ecole obj) {
        return false;
    }

    public boolean delete(Ecole obj) {
        return false;
    }

    public boolean update(Ecole obj) {
        return false;
    }

    public Ecole find(int id) {
        return null;
    }

}
