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
public class Evaluation {
    int ID;
    int IdMatiere;
    int note;
    int IdEleve;
    
    public Evaluation(int id, int IdMatiere, int note, int IdEleve)
    {
        this.ID=id;
        this.IdMatiere = IdMatiere;
        this.IdEleve = IdEleve;
        this.note = note;
    }

    public int getId() {
        return this.ID;
    }

    public int getIdMatiere() {
        return IdMatiere;
    }
    

    public int getNote() {
        return this.note;
    }

    public int getIdEleve() {
        return IdEleve;
    }


}
