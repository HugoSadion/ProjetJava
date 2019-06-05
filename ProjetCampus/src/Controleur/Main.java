package Controleur;

import Modele.Classe;
import Modele.Discipline;
import Modele.Eleve;
import Modele.Prof;
import jdbcv2018.SSHTunnel;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        Classe classe_cp = new Classe(1,"CP",100,2019);
        Classe classe_ce1 = new Classe(2,"CE1",100,2019);
        Classe classe_ce2 = new Classe(3,"CE2",100,2019);
        Classe classe_cm1 = new Classe(4,"CM1",100,2019);
        Classe classe_cm2 = new Classe(5,"CM2",100,2019);
        //Creation premiere discipline
        Discipline discipline_test = new Discipline(10,"maths");
        Prof prof_test=new Prof(1100,"Laville","Jade",discipline_test);

        prof_test.ajouterEleve(classe_cp,classe_ce1, classe_ce2,classe_cm1, classe_cm2);







    }
}
