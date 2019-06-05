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
public class Classe {
    int ID;
    String nom;
    String ecole;
    int anneeScolaire;
    
    
    public Classe()
{

}

    public Classe(int ID, String nom, String ecole, int anneeScolaire) {
        this.ID = ID;
        this.nom = nom;
        this.ecole = ecole;
        this.anneeScolaire = anneeScolaire;
    }
    
}


