package Controleur;

import DAO.*;
import Modele.*;

import java.util.*;
import java.sql.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {


    public static void main(String[] args) throws SQLException {


        Scanner scan = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
// Connexion à la db
        Connexion nouvelleCo = null;
        try {
            nouvelleCo = new Connexion("ecole", "root", "root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

// implémentation des variables
        Classe classe_cp = new Classe(1, "CP", 100, 2019);
        Classe classe_ce1 = new Classe(2, "CE1", 100, 2019);
        Classe classe_ce2 = new Classe(3, "CE2", 100, 2019);
        Classe classe_cm1 = new Classe(4, "CM1", 100, 2019);
        Classe classe_cm2 = new Classe(5, "CM2", 100, 2019);
        //Creation premiere discipline
        Discipline discipline_test = new Discipline(10, "maths");

        Evaluation eval = new Evaluation();
        EvaluationDao eval_test = new EvaluationDao(nouvelleCo);

        PersonneDao pers = new PersonneDao(nouvelleCo);
        Personne perso = new Personne();

        DetailBulletin det_bul = new DetailBulletin();
        DetailBulletinDao det_bul_dao = new DetailBulletinDao(nouvelleCo);

        Bulletin bulletin = new Bulletin();
        BulletinDao bulletin_dao = new BulletinDao(nouvelleCo);

        AnneeScolaire anneeScolaire = new AnneeScolaire();
        AnneeScolaireDao anneeScolaireDao = new AnneeScolaireDao(nouvelleCo);
        int menu=0;
        int utilisateur=0;
        int exit=0;
        do{
            System.out.println("----------- MENU -----------");
            System.out.println("Vous êtes un prof (1), un élève (2) ou un Utilitaire (3) ?");
            int type_utilisateur = scan.nextInt();

                switch (type_utilisateur) {


                    //si jamais l'utilisateur est un admin
                    case 3:
                        //menu=1;
                        do {
                            System.out.println("1 - Ajouter une personne");
                            System.out.println("2 - Reporting par matière");
                            System.out.println("3 - Retour au menu");


                            int reponse_admin = scan.nextInt();


                            switch (reponse_admin) {
                                case 1:

                                        perso.ajouter_personne(pers, nouvelleCo);
                                    do{
                                        System.out.println("Tapez 1 pour retourner au menu");
                                        int x=scan.nextInt();
                                        if (x==1){
                                            utilisateur=1;
                                            exit=2;
                                        }
                                    }while (exit!=2);

                                        //utilisateur=1;


                                    break;
                                case 2:

                                        anneeScolaire.etude_matiere(eval_test, nouvelleCo);
                                        do{
                                            System.out.println("Tapez 1 pour retourner au menu");
                                            int x=scan.nextInt();
                                            if (x==1){
                                                utilisateur=1;
                                                exit=2;
                                            }
                                        }while (exit!=2);


                                    break;

                                case 3:
                                    menu=1;
                                    utilisateur=1;
                                    break;
                                default:
                                    System.out.println("Caractère non admis pour admin");
                                    utilisateur = 1;
                                    break;


                            }
                        }while(utilisateur==0);

                        break;

                    //type utilisateur prof
                    case 1:
                        //menu=1;
                        do{
                        System.out.println("1 - Ajouter une nouvelle note");
                        System.out.println("2 - Générer le détail par matière du Bulletin");
                        System.out.println("3 - Générer le bulletin d'un élève");
                        System.out.println("4 - Retour Menu");

                        int reponse_prof = scan.nextInt();

                        switch (reponse_prof) {

                            case 1:
                                eval.noter(eval_test);
                                do{
                                    System.out.println("Tapez 1 pour retourner au menu");
                                    int x=scan.nextInt();
                                    if (x==1){
                                        menu=1;
                                        utilisateur=1;

                                        exit=2;
                                    }
                                }while (exit!=2);
                                break;
                            case 2:
                                det_bul.generer_detail(det_bul_dao);
                                do{
                                    System.out.println("Tapez 1 pour retourner au menu");
                                    int x=scan.nextInt();
                                    if (x==1){
                                        menu=1;
                                        utilisateur=1;
                                        exit=2;
                                    }
                                }while (exit!=2);
                                break;

                            case 3:
                                bulletin.generer_bulletin(bulletin_dao, det_bul_dao, nouvelleCo);
                                do{
                                    System.out.println("Tapez 1 pour retourner au menu");
                                    int x=scan.nextInt();
                                    if (x==1){
                                        menu=1;
                                        utilisateur=1;
                                        exit=2;
                                    }
                                }while (exit!=2);
                                break;

                            case 4:
                                menu=1;
                                utilisateur=1;
                                break;
                            default:
                                System.out.println("Caractère non admis pour un prof");
                                utilisateur=1;
                                break;
                        }
                        //utilisateur=0;
                        }while(utilisateur==0);

                        break;


                    //type utilisateur élève
                    case 2:

                       // menu=1;
                        do{
                        System.out.println("1 - Voir mes notes par matière");
                        System.out.println("2 - Voir mon bulletin");
                        System.out.println("3 - Retour menu");

                            int reponse_eleve = scan.nextInt();
                        switch (reponse_eleve) {
                            case 1:
                                eval.affiche_notes(nouvelleCo);
                                do{
                                    System.out.println("Tapez 1 pour retourner au menu");
                                    int x=scan.nextInt();
                                    if (x==1){
                                        menu=1;
                                        utilisateur=1;

                                        exit=2;
                                    }
                                }while (exit!=2);
                                break;

                            case 2:
                                bulletin.afficher_bulletin(nouvelleCo);
                                do{
                                    System.out.println("Tapez 1 pour retourner au menu");
                                    int x=scan.nextInt();
                                    if (x==1){
                                        menu=1;
                                        utilisateur=1;
                                        exit=2;
                                    }
                                }while (exit!=2);
                                break;
                            case 3:
                                menu=1;
                                utilisateur=1;
                                break;

                            default:
                                System.out.println("Caractère non admis pour eleve");
                                utilisateur=1;
                                break;

                        }
                        //utilisateur=0;
                        }while(utilisateur==0);

                        break;

                    default:
                        System.out.println("Caractère non admis pour le menu");
                        menu = 1;
                        break;




                }menu = 0;

        }while (menu==0);
    }
}
