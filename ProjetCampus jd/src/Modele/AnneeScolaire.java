/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import DAO.AnneeScolaireDao;
import DAO.EvaluationDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Thomas
 */
public class AnneeScolaire {
    int ID;
    int moyenne_classe;
    int moyenne_matiere;
    int moyenne_prof;
    int moyenne_classe_matiere;
    
    public AnneeScolaire()
    {
        
    }
    
    public void setMoyenne_classe(int moyenne_classe){this.moyenne_classe=moyenne_classe;}
    public void setMoyenne_matiere(int moyenne_matiere){this.moyenne_matiere=moyenne_matiere;}
    public void setMoyenne_prof(int moyenne_prof){this.moyenne_prof=moyenne_prof;}
    public void setMoyenne_classe_matiere(int moyenne_classe_matierey){this.moyenne_classe_matiere=moyenne_classe_matiere;}

    public int getId() {
        return this.ID;
    }
    public int getMoyenne_classe(){return this.moyenne_classe;}
    public int getMoyenne_matiere(){return this.moyenne_matiere;}
    public int getMoyenne_prof(){return this.moyenne_prof;}
    public int getMoyenne_classe_matiere(){return this.moyenne_classe_matiere;}

    public void etude_matiere(EvaluationDao evaluationDao, Connexion connect){

        Scanner scan = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

        System.out.println("De quelle matière voulez-vous l'étude ?  1=Francais, 2=Geographie, 3=Histoire, 4=Maths, 5=Anglais");
        int matiere = scan.nextInt();

        AnneeScolaireDao anneeScolaireDao = new AnneeScolaireDao(connect);

        System.out.println("La moyenne de cette matière est : "+anneeScolaireDao.recup_moyenne_classe(connect,matiere));


    }


}
