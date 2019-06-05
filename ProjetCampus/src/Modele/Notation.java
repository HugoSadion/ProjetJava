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
public class Notation {
    protected int ID;
    Enseignement enseignement;
    int note;
    String appreciation;

    public Notation () {

    }

    public Notation (Enseignement enseignement, String appreciation, int note){
        this.note=note;
        this.enseignement=enseignement;
        this.appreciation=appreciation;
    }
}
