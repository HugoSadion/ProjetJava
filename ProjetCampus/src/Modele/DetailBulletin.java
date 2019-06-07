/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import DAO.DetailBulletinDao;

import java.util.Scanner;

/**
 *
 * @author Thomas
 */
public class DetailBulletin {
    int ID;
    int IdBulletin;
    int IdEleve;
    int IdEnseignement;
    String Appreciation_matiere;
    int Note_matiere;


    
    public int getIdBulletin()
    {
        return this.IdBulletin;
    }
    public int getIdEleve(){return this.IdEleve;}
    public int getNote_matiere(){return this.Note_matiere;}
    public int getIdEnseignement()
    {
        return this.IdEnseignement;
    }
    public String getAppreciation_matiere(){return this.Appreciation_matiere; }
    public int getID()
    {
        return this.ID;
    }

    public DetailBulletin()
    {
        
    }
    
    public DetailBulletin(/*int IdBulletin*/ int IdEleve, int IdEnseignement/*, String Appreciation_matiere, int Note_matiere*/)
    {
        //this.IdBulletin=IdBulletin;
        this.IdEnseignement=IdEnseignement;
        this.IdEleve=IdEleve;
        //this.Appreciation_matiere=Appreciation_matiere;
        //this.Note_matiere=Note_matiere;
    }

    public void generer_detail (DetailBulletinDao det_but_dao){

        Scanner scan = new Scanner(System.in);
        Scanner sc= new Scanner(System.in);
        //recupérétion de la matiere
        System.out.println("Matière évaluez vous ? 1=Francais, 2=Geographie, 3=Histoire, 4=Maths, 5=Anglais");
        int matière = scan.nextInt();
        //Recuperation de l'id de l'élève
        System.out.println("Quelle élève souhaitez vous évaluer ? (identifiant uniquement) ");
        int id_eleve = scan.nextInt();
        //Generation de la note grace à id_eleve
        int note_matiere=0;



        System.out.println("Quelle appreciation voulez vous mettre à cette élève dans votre matière ?");
        String appreciation_matiere = sc.nextLine();




    }
}
