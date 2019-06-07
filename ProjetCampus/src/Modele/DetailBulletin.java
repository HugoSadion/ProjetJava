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
public class DetailBulletin {
    int ID;
    int IdEleve;
    int IdBulletin;
    int IdEnseignement;
    String AppreciationMatiere;
    int NoteMatiere;
    
    public int getIdBulletin()
    {
        return this.IdBulletin;
    }
    
    public int getIdEnseignement()
    {
        return this.IdEnseignement;
    }
    public String getAppreciationMatiere()
    {
        return this.AppreciationMatiere;
    }
    
    public int getID()
    {
        return this.ID;
    }
    public DetailBulletin()
    {
        
    }
    
    public DetailBulletin(int IdEleve, int IdBulletin, int IdEnseignement, String AppreciationMatiere, int NoteMatiere)
    {
        this.IdEleve=IdEleve;
        this.AppreciationMatiere=AppreciationMatiere;
        this.IdBulletin=IdBulletin;
        this.IdEnseignement=IdEnseignement;
        this.NoteMatiere=NoteMatiere;
    }

    public int getIdEleve() {
        return this.IdEleve;
        }

    public int getNoteMatiere() {
        return this.NoteMatiere;
    }
    
}
