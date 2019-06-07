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
    String appreciation;
    int NoteGenerale;
    String ecole;
  

    public Bulletin (int id,int idTrimestre, String appreciation, int noteGenrale, String ecole){
        this.ID=id;
        this.IDTrimestre = idTrimestre;
        this.appreciation = appreciation;
        this.NoteGenerale=noteGenrale;
        this.ecole=ecole;
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

    public String getEcole() {
        return ecole;
    }

    public int getNoteGenerale() {
        return NoteGenerale;
    }

    public int getIDTrimestre() {
        return IDTrimestre;
    }
    
    
}
