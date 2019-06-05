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
public class Eleve extends Personne{
    Notation note;
    Classe classe;


    public Eleve (){

    }

    public Eleve (int id, String nom, String prenom, Classe classe){
        super (id, nom, prenom);
        this.classe=classe;
    }
}
