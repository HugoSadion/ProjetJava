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
public class Personne {
     int ID;
    String nom; 
    String prenom;
    String type;

    public Personne() {
    }

    public Personne(int ID, String nom, String prenom, String type) {
        this.ID = ID;
        this.nom = nom;
        this.prenom = prenom;
        this.type=type;
    }

    public int getID() {
        return ID;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
    
    
}
