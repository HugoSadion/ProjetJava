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
    public void ajouterEleve()
    {
        int idEleve;
        int idClasse;
        String nom_eleve;
        String prenom_eleve;
        
        System.out.println("Choisissez l'identifiant du nouvel élève");
        idEleve = scan.nextInt();
        System.out.println("Quel est le nom de cet élève");
        nom_eleve = scan.nextLine();
        System.out.println("Quel est le prénom de cet élève");
        prenom_eleve = scan.nextLine();
        System.out.println("Associez lui une classe (par identifiant)");
        idClasse = scan.nextInt();

        Classe classe = new Classe(idClasse, "CP3", "ESILV", 2019);
        Eleve eleve = new Eleve(idEleve, nom_eleve, prenom_eleve,classe);
                
        if (idEleve==eleve.ID)
        {
            eleve.classe.ID=idClasse;
        }
        System.out.println("L'eleve n" + eleve.ID + "est dans la classe n"+eleve.classe.ID);
    }
}
