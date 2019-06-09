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
    int IdClasse;
    int IdDiscipline;
    int IdPersonne;

    public Enseignement() {
    }

    public Enseignement( int IdClasse, int IdDiscipline, int IdPersonne){

        this.IdClasse=IdClasse;
        this.IdDiscipline=IdDiscipline;
        this.IdPersonne=IdPersonne;
    }

    public int getID(){return this.ID;}
    public int getIdClasse(){return this.IdClasse;}
    public int getIdDiscipline(){return this.IdDiscipline;}
    public int getIdPersonne(){return this.IdPersonne;}

    
    
}
