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
    
    public int getIdCLasse()
    {
        return this.IdClasse;
    }
    public int getIdDiscipline()
    {
        return this.IdDiscipline;
    }
    public int getIdPersonne()
    {
        return this.IdPersonne;
    }

    public Enseignement() {
    }

    public Enseignement(int ID, int IdClasse, int IdDiscipline, int IdPersonne){

        this.ID = ID;
        this.IdClasse=IdClasse;
        this.IdDiscipline=IdDiscipline;
        this.IdPersonne=IdPersonne;

    }

    public int getId() {
            return this.ID;
    }

    
    
}
