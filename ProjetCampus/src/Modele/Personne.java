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
    int IdClasse;

    public Personne() {
    }

    public Personne( String nom, String prenom, String type, int IdClasse) {
        
        this.nom = nom;
        this.prenom = prenom;
        this.type=type;
        this.IdClasse=IdClasse;
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

    public int getIdClasse() {
        return IdClasse;
    }

    public String getType() {
        return type;
    }

 
    
    
    
}
