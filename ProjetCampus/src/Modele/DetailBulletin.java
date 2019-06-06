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
    int IdBulletin;
    int IdEnseignement;
    String Appreciation;
    
    public int getIdBulletin()
    {
        return this.IdBulletin;
    }
    
    public int getIdEnseignement()
    {
        return this.IdEnseignement;
    }
    public String getAppreciation()
    {
        return this.Appreciation;
    }
    
    public int getID()
    {
        return this.ID;
    }
    public DetailBulletin()
    {
        
    }
    
    public DetailBulletin(int id, int IdBulletin, int IdEnseignement, String Appreciation)
    {
        this.ID=id;
        this.Appreciation=Appreciation;
        this.IdBulletin=IdBulletin;
        this.IdEnseignement=IdEnseignement;
    }
    
}
