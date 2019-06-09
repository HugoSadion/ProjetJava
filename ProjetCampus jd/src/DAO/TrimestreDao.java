/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modele.Connexion;
import Modele.Trimestre;

import java.util.ArrayList;

/**
 *
 * @author Thomas
 */
public class TrimestreDao extends Dao<Trimestre>{
    
    public TrimestreDao (Connexion connect)
    {
        super(connect);
    }
    
     public boolean create(Trimestre obj) 
    {
        return false;
    }

    public boolean delete(Trimestre obj) 
    {
        return false;
    }
   
    public boolean update(Trimestre obj) 
    {
        return false;
    }
    
    public Trimestre find(int id) {
    return null;
  }

  public ArrayList<Integer> select (Trimestre objet){
        ArrayList <Integer> array = new ArrayList<Integer>();
        array.add(1);
        return array;
    }


}
