package Controleur;

import DAO.*;
import Modele.Classe;
import Modele.Discipline;
import Modele.Personne;
import java.sql.SQLException;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modele.Connexion;

public class Main {



    public static void main(String[] args) throws SQLException {
        
        
        try {
            //connexion à la database
            Connexion nouvelleCo = new Connexion("localhost", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        

        Classe classe_cp = new Classe(1,"CP",100,2019);
        Classe classe_ce1 = new Classe(2,"CE1",100,2019);
        Classe classe_ce2 = new Classe(3,"CE2",100,2019);
        Classe classe_cm1 = new Classe(4,"CM1",100,2019);
        Classe classe_cm2 = new Classe(5,"CM2",100,2019);
        //Creation premiere discipline
        Discipline discipline_test = new Discipline(10,"maths");








    }
}
