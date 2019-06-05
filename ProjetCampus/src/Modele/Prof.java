/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Thomas
 */
public class Prof extends Personne{
    Discipline discipline;
    Scanner scan = new Scanner(System.in);
      
    public Prof() {
    }

    public Prof(int id, String nom, String prenom, Discipline discipline) {
        super (id, nom, prenom);
        this.discipline = discipline;
    }
    
    public static void lire_info()
    {
        Discipline discipline;
    String url = "jbdc::mysql://localhost/ecole";
    String login = "root";
    String password = "";
    Connection cn = null;
    Statement st = null;
    ResultSet rs =null; 
    

    }
    public void ajouterEleve(Classe cp, Classe ce1, Classe ce2, Classe cm1, Classe cm2)
    {
        Scanner scan = new Scanner(System.in);
        Scanner sc= new Scanner(System.in);


//AJOUTER UN ELEVE PAR SCAN
        System.out.println("Mettez 1000 pour id eleve :");
        int ideleve = scan.nextInt();

        System.out.println("Quel est le nom de cet élève");
        String nom_eleve = sc.nextLine();

        System.out.println("Quel est le prénom de cet élève");
        String prenom_eleve = sc.nextLine();

        System.out.println("Quel est le niveau de l'élève ? (CP=1, CE1=2, CE2=3,CM1=4,CM2=5)");
        int niveau = scan.nextInt();
        String nom_classe="";
        Eleve eleve_test = null;

        if (niveau==1){
            eleve_test=new Eleve(ideleve,nom_eleve,prenom_eleve,cp);
            nom_classe=cp.getnom();
        }
        else if (niveau==2){
            eleve_test=new Eleve(ideleve,nom_eleve,prenom_eleve,ce1);
            nom_classe=ce1.getnom();
        }
        else if (niveau==3){
            eleve_test=new Eleve(ideleve,nom_eleve,prenom_eleve,ce2);
            nom_classe=ce2.getnom();
        }
        else if (niveau==4){
            eleve_test=new Eleve(ideleve,nom_eleve,prenom_eleve,cm1);
            nom_classe=cm1.getnom();
        }
        else if(niveau==5){
            eleve_test=new Eleve(ideleve,nom_eleve,prenom_eleve,cm2);
            nom_classe=cm2.getnom();
        }


        if (eleve_test == null){
            System.out.println("l'élève n'a pas été créé");

        }
        else{
            System.out.println("L'élève "+prenom_eleve+" "+nom_eleve+" a été crée. Elle a été mise dans la classe : "+nom_classe);
        }

        //AJOUT DES INFORMATIONS DANS LA BDD

    }
}
