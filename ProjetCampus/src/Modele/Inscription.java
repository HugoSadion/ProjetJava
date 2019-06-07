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
public class Inscription {
    int ID;
    int IdClasse;
    int IdPersonne;
    
    public Inscription(int id, int IdClasse, int IdPersonne)
    {
        this.ID = id;
        this.IdClasse = IdClasse;
        this.IdPersonne = IdPersonne;
    }

    public int getId() {
        return this.ID;
    }

    public int getIdClasse() {
        return this.IdClasse;
    }

    public int getIdPersonne() {
        return this.IdPersonne;
    }
}
