/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
import DAO.EnseignementDao;
import DAO.PersonneDao;

import java.util.*;
import java.sql.*;

/**
 *
 * @author Thomas
 */
public class Personne {
    int ID;
    String nom; 
    String prenom;
    String type;
    int idClasse;
    int id_matiere;

    public Personne() {
    }

    public Personne(String nom, String prenom, String type) {
        this.nom = nom;
        this.prenom = prenom;
        this.type=type;
    }
    public String getType (){return this.type;}
    public void setIdClasse(int idClasse){
        this.idClasse=idClasse;
    }
    public void setIdMatiere(int idmatiere){id_matiere=idmatiere;}
    public int getId_matiere(){return this.id_matiere;}
    public int getidClasse (){return this.idClasse;}

    public void setID(int ID) {
        this.ID = ID;
    }
    public int getID(){return this.ID;}

    public int ajouter_personne (PersonneDao perso_test, Connexion nouvelleCo){


        Scanner scan = new Scanner(System.in);
        Scanner sc= new Scanner(System.in);


        System.out.println("Quel type de personne souhaitez vous ajouter ? 1 = Prof // 2 = Eleve :");
        int type_perso = scan.nextInt();

        if (type_perso==1) {
            System.out.println("Vous souhaitez ajouter un prof");

            System.out.println("Quel est le nom du professeur : ");
            String nom_prof = sc.nextLine();
            System.out.println("Quel est le prénom du professeur : ");
            String prenom_prof = sc.nextLine();
            String type = "prof";
            Personne prof = new Personne(nom_prof, prenom_prof, type);
            PersonneDao prof_dao =new PersonneDao(nouvelleCo);



            if (prof == null) {
                System.out.println("Le nouveau prof n'a pas pu être créé");
                return 0;
            } else
                prof_dao.create (prof);
                int id=prof_dao.recup_gdID();
                System.out.println("identifiant est : "+id);


            System.out.println("Dans quelle matière ce professeur pratiquera ?");
            System.out.println("1=Francais, 2=Geographie, 3=Histoire, 4=Maths, 5=Anglais");
            int id_matiere = scan.nextInt();

            System.out.println("Quelle est le niveau des élèves à qui il enseignera ?");
            System.out.println("1=CP, 2=CE1, 3=CE2, 4=CM1, 5=CM2");
            int id_classe = scan.nextInt();

            prof.setIdClasse(id_classe);
            prof.setIdMatiere(id_matiere);

            prof_dao.ajouter_enseignement(prof,id);
            prof_dao.update_prof(prof);

            System.out.println("Le nouveau professeur " + prenom_prof + " " + nom_prof + " a été crée !");
            System.out.println("L'identifiant du prof à retenir : "+id);

            return id;//prof_dao.recup_idprof(nom_prof);

        }
        else if (type_perso==2){
            System.out.println("Vous souhaitez ajouter une élève");

            System.out.println("Quel est le nom de l'élève : ");
            String nom_eleve = sc.nextLine();
            System.out.println("Quel est le prénom de l'élève : ");
            String prenom_eleve = sc.nextLine();
            System.out.println("Quel est le niveau de l'élève : (1 = CP // 2 = CE1 // 3=CE2 // 4 = CM1 // 5 = CM2");
            int classe = scan.nextInt();

            String type = "eleve";

            Personne eleve = new Personne(nom_eleve, prenom_eleve, type);
            eleve.setIdClasse(classe);


            if (eleve == null) {
                System.out.println("Le nouvel élève n'a pas pu être créé");
                return 0;
            } else
                System.out.println("Le nouvel élève " + prenom_eleve + " " + nom_eleve + " a été crée !");
                perso_test.create(eleve);
                perso_test.update(eleve);
                int id=perso_test.recup_gdID();

            return id;

        }
        else {
            System.out.println("Vous n'avez pas séléctionné une option valable, ");
            return 0;
        }



        }




    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }


    public int getIdClasse(){return this.idClasse; }
    }


    
    

