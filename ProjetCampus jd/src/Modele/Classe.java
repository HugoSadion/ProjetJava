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
    int IdEcole;
    int IdAnneeScolaire;
    
    
    public Classe()
{

}

    public Classe(int ID, String nom,int IdEcole, int IdAnneeScolaire) {
        this.ID = ID;
        this.nom = nom;
        this.IdEcole = IdEcole;
        this.IdAnneeScolaire = IdAnneeScolaire;
    }
    
    public Classe (int ID)
    {
        this.ID=ID;

    }
     public String getnom (){
        return nom;
     }

    public int getID() {
return this.ID;
    }
    
    public int getIdEcole()
    {
        return this.IdEcole;
    }
    
    public int getIdAnneeScolaire()
    {
        return this.IdAnneeScolaire;
    }
}


