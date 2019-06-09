/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import DAO.BulletinDao;
import DAO.DetailBulletinDao;

import java.util.Scanner;

/**
 *
 * @author Thomas
 */
public class Bulletin {
    int ID;
    int IDTrimestre;
    int IDEleve;
    int annee;
    String appreciation;
    int moyenne_generale;


    public Bulletin(int id_eleve, int id_trimestre, int annee_scolaire) {

        this.IDTrimestre = id_trimestre;
        this.IDEleve = id_eleve;
        this.annee = annee_scolaire;
        String bul1 = "" + id_eleve + "";
        String bul2 = "" + id_trimestre + "";
        String bul3 = "" + annee_scolaire + "";
        String bulletin = bul1 + bul2 + bul3;
        ID = Integer.parseInt(bulletin);

    }

    public Bulletin() {
    }

    public void setIDBulletin() {
        /*int id_bul1 = id_eleve;
        int id_bul2 =id_trimestre;
        int id_bul3 = annee_scolaire;*/

        //int bulletin1 =id_eleveInteger.parseInt(bul1,id_bul1);
        //int bulletin2=Integer.parseInt()

    }

    public Bulletin(int id) {
        this.ID = id;
    }

    public String getAppreciation() {
        return this.appreciation;
    }

    public int getId() {
        return this.ID;
    }


    public void generer_bulletin(BulletinDao bulletin_dao,DetailBulletinDao det_but_dao, Connexion connect) {


        Scanner scan = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);


        //Recuperation de l'id de l'élève pour retrouver la classe pour l'enseignement
        System.out.println("Quelle élève souhaitez vous évaluer ? (identifiant uniquement) ");
        int id_eleve = scan.nextInt();

        System.out.println("Quel Trimestre évaluez vous ? (1=Premier Trimestre, 2=Second Semestre, 3=Troisième Trimestre");
        int id_trimestre = scan.nextInt();

        System.out.println("Quelle année voulez vous évaluer ?");
        int annee_sco = scan.nextInt();

        Bulletin bulletin = new Bulletin(id_eleve, id_trimestre, annee_sco);


        //Generation et récupération de la note grace à id_eleve
        System.out.println("La moyenne générale de l'élève est de : "+bulletin_dao.recup_moyenne_generale(id_eleve,id_trimestre,annee_sco)+"/20");
        //generation et recupération de l'appreciation
        System.out.println("Quelle appreciation voulez vous mettre à cette élève dans votre matière ?");
        String appreciation = sc.nextLine();


        System.out.println("-------------------------------------");

        //NOM et Prenom de l'élève
        System.out.println("ELEVE : ");
        det_but_dao.afficher_nom_eleve(id_eleve);

        //Trimestre
        System.out.println("Trimestre n°" + id_trimestre);
        //Annee
        System.out.println("Année : " + annee_sco);


        System.out.println("-----------------------------");


        //RECUPERATION DES DETAILS BULLETIN

        //recupérétion de la matiere pour retrouver l'enseignement
        for (int matiere = 1; matiere < 6; matiere++) {



            int id_classe = det_but_dao.recup_idClasse(id_eleve);
            System.out.println("ID CLASSE : "+id_classe);
            System.out.println("ID matiere : "+matiere);


            int id_prof = det_but_dao.recup_idprof (matiere, id_classe);
            System.out.println("ID Prof : "+id_prof);


            int id_enseignement = det_but_dao.recup_id_enseign(matiere, id_prof, id_classe);
            System.out.println("ID ensei : "+id_enseignement);


            DetailBulletin detailBulletin = new DetailBulletin(id_eleve, id_enseignement);

            //Création du détail bulletin

            System.out.println("-------Recapitulatif De la Matiere--------");


            //Affichage de la matiere
            if (matiere == 1) {
                System.out.println("MATIERE : Francais");
            } else if (matiere == 2) {
                System.out.println("MATIERE : Geographie");
            } else if (matiere == 3) {
                System.out.println("MATIERE : Histoire");
            } else if (matiere == 4) {
                System.out.println("MATIERE : Maths");
            } else if (matiere == 5) {
                System.out.println("MATIERE : Anglais");
            } else {
                System.out.println("Erreur matiere");
            }

            //Affichage du professeur
            System.out.println("Professeur : " + det_but_dao.recup_nom_prof(id_prof));
            //Affichage de la moyenne
            System.out.println("Moyenne : " + det_but_dao.recup_notes(id_eleve, matiere, id_trimestre, annee_sco) + "/20");
            //Appreciation
            System.out.println("L'appréciation du professeur : " + det_but_dao.recup_appreciation(id_eleve, matiere, id_trimestre, annee_sco));
            System.out.println("----------------");

        }

        System.out.println("---------------------------------------------------");
//Generation et récupération de la note grace à id_eleve
        System.out.println("La moyenne générale de l'élève est de : "+bulletin_dao.recup_moyenne_generale(id_eleve,id_trimestre,annee_sco)+"/20");
        //generation et recupération de l'appreciation
        System.out.println("Appreciation générale : "+appreciation);


    }
}
