/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import DAO.DetailBulletinDao;

import java.awt.*;
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

    public void setAppreciation_matiere(String Appreciation_matiere){ this.Appreciation_matiere=Appreciation_matiere;}
    public void setNote_matiere(int note_matiere){Note_matiere=note_matiere;}
    public void setIdBulletin(int id_eleve, int id_trimestre, int annee_scolaire){
        /*int id_bul1 = id_eleve;
        int id_bul2 =id_trimestre;
        int id_bul3 = annee_scolaire;*/
        String bul1 =""+id_eleve+"";
        String bul2 =""+id_trimestre+"";
        String bul3 =""+annee_scolaire+"";
        //int bulletin1 =id_eleveInteger.parseInt(bul1,id_bul1);
        //int bulletin2=Integer.parseInt()
        String bulletin = bul1+bul2+bul3;
        IdBulletin=Integer.parseInt(bulletin);

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
        //recupérétion de la matiere pour retrouver l'enseignement
        System.out.println("Matière évaluez vous ? 1=Francais, 2=Geographie, 3=Histoire, 4=Maths, 5=Anglais");
        int matiere = scan.nextInt();
        //recupération id prof pour retrouver le bon enseignement
        System.out.println("Quel est votre identifiant prof ?");
        int id_prof = scan.nextInt();
        //Recuperation de l'id de l'élève pour retrouver la classe pour l'enseignement
        System.out.println("Quelle élève souhaitez vous évaluer ? (identifiant uniquement) ");
        int id_eleve = scan.nextInt();

        int id_classe = det_but_dao.recup_idClasse(id_eleve);
        int id_enseignement=det_but_dao.recup_id_enseign(matiere,id_prof,id_classe);

        System.out.println("Quel Trimestre évaluez vous ? (1=Premier Trimestre, 2=Second Semestre, 3=Troisième Trimestre");
        int id_trimestre = scan.nextInt();

        System.out.println("Quelle année voulez vous évaluer ?");
        int annee_sco = scan.nextInt();

        //Création du détail bulletin
        DetailBulletin detailBulletin = new DetailBulletin(id_eleve, id_enseignement);
        detailBulletin.setIdBulletin(id_eleve,id_trimestre,annee_sco);

        //création de ce detail dans la bdd
        if (!det_but_dao.create(detailBulletin)) {
            System.out.println("Mettons à jour la note et l'appréciation !");
        } else {
            System.out.println("L'identifiant du bulletin sera : "+detailBulletin.getIdBulletin());
        }
        //Generation et récupération de la note grace à id_eleve
        System.out.println("La moyenne de l'élève dans cette matière est de : "+det_but_dao.recup_notes(id_eleve,matiere,id_trimestre,annee_sco)+"/20");
        //generation et recupération de l'appreciation
        System.out.println("Quelle appreciation voulez vous mettre à cette élève dans votre matière ?");
        String appreciation_matiere = sc.nextLine();

        //implémentation de l'objet
        detailBulletin.setAppreciation_matiere(appreciation_matiere);
        detailBulletin.setNote_matiere(det_but_dao.recup_notes(id_eleve,matiere,id_trimestre,annee_sco));
        //mise à jour avec les nouvelles données
        det_but_dao.update(detailBulletin);


        System.out.println("-------Recapitulatif De la Matiere--------");

        //NOM et Prenom de l'élève
        System.out.println("ELEVE : ");
        det_but_dao.afficher_nom_eleve(id_eleve);

        //Trimestre
        System.out.println("Trimestre n°"+id_trimestre);
        //Annee
        System.out.println("Année : "+annee_sco);
        System.out.println("-----------------------------");
        //Affichage de la matiere
        if (matiere==1)
        {System.out.println("MATIERE : Francais");}
        else if (matiere==2)
        {System.out.println("MATIERE : Geographie");}
        else if (matiere==3)
        {System.out.println("MATIERE : Histoire");}
        else if (matiere==4)
        {System.out.println("MATIERE : Maths");}
        else if (matiere==5)
        {System.out.println("MATIERE : Anglais");}
        else
        {System.out.println("Erreur matiere");}

        //Affichage du professeur
        System.out.println("Professeur : "+det_but_dao.recup_nom_prof(id_prof));
        //Affichage de la moyenne
        System.out.println("Moyenne : "+det_but_dao.recup_notes(id_eleve,matiere,id_trimestre,annee_sco)+"/20");
        //Appreciation
        System.out.println("L'appréciation du professeur : "+appreciation_matiere);

    }
}
