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



    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        

        Connexion nouvelleCo = new Connexion("ecole", "root", "");
  
        
        
        
        Classe classe = new Classe("Bleue", 505, 2019);
        
        classe.ajoutClasse(nouvelleCo);







    }
}
