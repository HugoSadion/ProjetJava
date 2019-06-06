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
    int IdDetailBulletin;
    int note;
    String Appreciation;
    
    public Evaluation(int id, int IdDetailBulletin, int note, String appreciation)
    {
        this.ID=id;
        this.Appreciation = appreciation;
        this.IdDetailBulletin = IdDetailBulletin;
        this.note = note;
    }
}
