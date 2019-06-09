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
        Scanner sc= new Scanner(System.in);
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

        System.out.println("----------- MENU ----------");
        System.out.println("Vous êtes un prof (1), un élève (2) ou un administrateur (3) ?");
        int type_utilisateur = scan.nextInt();

        //det_bul_dao.select(det_bul);
        //si jamais l'utilisateur est un admin
        if (type_utilisateur==3){
            System.out.println("1 - Ajouter une personne");
            int reponse_admin = scan.nextInt();

            if (reponse_admin==1){
                perso.ajouter_personne(pers,nouvelleCo);

            }

        }
        //type utilisateur prof
        else if (type_utilisateur==1){
            System.out.println("1 - Ajouter une nouvelle note");
            System.out.println("2 - Générer le détail par matière du Bulletin");
            System.out.println("3 - Générer le bulletin d'un élève");
            int reponse_prof = scan.nextInt();

            if (reponse_prof==1){
                eval.noter(eval_test);
            }
            else if (reponse_prof==2){
                det_bul.generer_detail(det_bul_dao);

            }
            else if (reponse_prof==3){
                bulletin.generer_bulletin(bulletin_dao,det_bul_dao, nouvelleCo);
            }
        }
        //type utilisateur élève
        else if (type_utilisateur==2){

            System.out.println("1 - Voir mes notes par matière");
            System.out.println("2 - Voir mon bulletin");
            System.out.println("3 - Reporting");

            int reponse_eleve=scan.nextInt();

            if (reponse_eleve==1){
                eval.affiche_notes(nouvelleCo);
            }

            else if (reponse_eleve==2){
                bulletin.afficher_bulletin(nouvelleCo);
            }
            else if (reponse_eleve==3){

            }

        }


        else
        { System.out.println("Pas de bon numero gros");}


    }
}
