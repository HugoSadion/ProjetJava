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
public class Niveau {
    int ID;
    String nom;
    
    public Niveau(int id, String nom)
    {
        this.ID = id;
        this.nom = nom;
    }

    public int getID() {
        return this.ID;
    }

    public String getNom() {
        return this.nom;
    }
}
