/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author Thomas
 */
public class Bulletin {
    int ID;
    int IDTrimestre;
    int IDEleve;
    String appreciation;
  

    public Bulletin (int id,int idTrimestre, String appreciation){
        this.ID=id;
        this.IDTrimestre = idTrimestre;
        this.appreciation = appreciation;
    }

    public Bulletin() {
    }
    
    public Bulletin(int id)
    {
        this.ID = id;
    }

    public String getAppreciation() {
        return this.appreciation;
    }

    public int getId() {
    return this.ID;   
    }
}
