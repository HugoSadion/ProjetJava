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
    int numero;
    String debut;
    String fin;
    int anneeScolaire;

    public Trimestre (){

    }

    public Trimestre (int id, int numero, String debut, String fin, int anneeScolaire){
        this.ID=id;
        this.numero=numero;
        this.debut=debut;
        this.fin=fin;
        this.anneeScolaire=anneeScolaire;
    }
}
