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
public class Trimestre {
    int ID;
    String debut;
    String fin;
    int anneeScolaire;

    public Trimestre (){

    }

    public Trimestre (String debut, String fin, int anneesco){
        this.debut=debut;
        this.fin=fin;
        anneeScolaire=anneesco;
    }
}
