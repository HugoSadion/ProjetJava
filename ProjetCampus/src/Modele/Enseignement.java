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
public class Enseignement {
    int ID;
    Prof prof;
    Classe classe;

    public Enseignement() {
    }

    public Enseignement(Prof prof, Classe classe){

        this.prof=prof;
        this.classe=classe;

    }
    
    
}
