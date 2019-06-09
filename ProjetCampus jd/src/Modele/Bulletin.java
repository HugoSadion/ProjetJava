/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import DAO.BulletinDao;
import DAO.DetailBulletinDao;
import DAO.EvaluationDao;

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

    public void setAppreciation(String appreciation){this.appreciation=appreciation;}

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
    public void setMoyenne_generale(int moyenne_generale){this.moyenne_generale=moyenne_generale;}
    public int getMoyenne_generale(){return this.moyenne_generale;}

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
        bulletin.setMoyenne_generale(bulletin_dao.recup_moyenne_generale(id_eleve,id_trimestre,annee_sco));
        System.out.println("Quelle appreciation voulez vous mettre à cette élève dans votre matière ?");
        String appreciation = sc.nextLine();
        bulletin.setAppreciation(appreciation);

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

            int id_prof = det_but_dao.recup_idprof (matiere, id_classe);

            int id_enseignement = det_but_dao.recup_id_enseign(matiere, id_prof, id_classe);


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
            System.out.printf("Moyenne : %d/20%n", det_but_dao.recup_notes(id_eleve, matiere, id_trimestre, annee_sco));
            //Appreciation
            System.out.println("L'appréciation du professeur : " + det_but_dao.recup_appreciation(id_enseignement,bulletin.getId()));
            System.out.println("----------------");

        }

        System.out.println("---------------------------------------------------");
//Generation et récupération de la note grace à id_eleve
        System.out.println("La moyenne générale de l'élève est de : "+bulletin_dao.recup_moyenne_generale(id_eleve,id_trimestre,annee_sco)+"/20");
        //generation et recupération de l'appreciation
        System.out.println("Appreciation générale : "+appreciation);

        if (bulletin_dao.create(bulletin)){System.out.println("Le bulletin a été mis dans la basse de donnée à l'identidiant : "+bulletin.getId());}
        else {System.out.println("On a pas pu le mettre dans la bdd");}

    }


    public void afficher_bulletin(Connexion connect){

        Scanner scan = new Scanner(System.in);
        Scanner sc= new Scanner(System.in);

        System.out.println("Quel est l'identifiant élève ? ");
        int id_eleve = scan.nextInt();


        System.out.println("De quel trimestre voulez vous les notes ? (1=Premier Trimestre, 2=Second Semestre, 3=Troisième Trimestre");
        int trimestre = scan.nextInt();

        System.out.println("De quelle année ?");
        int annee = scan.nextInt();

        BulletinDao bulletinDao = new BulletinDao(connect);
        bulletinDao.recup_bulletin(id_eleve, trimestre, annee);
    }
}
