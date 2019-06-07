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
public class Ecole {
    int ID;
    String nom;
    
    public Ecole(int id, String nom)
    {
        this.ID=id;
        this.nom=nom;
    }

    public String getNom() {
        return this.nom;
    }

    public int getId() {
        return this.ID;
    }
}
