/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import DAO.EvaluationDao;

import java.util.*;
import java.sql.*;


/**
 *
 * @author Thomas
 */
public class Evaluation {
    int ID;
    int IdMatiere;
    int IdEleve;
    int note;

    Scanner scan = new Scanner(System.in);
    Scanner sc= new Scanner(System.in);

    public Evaluation(){
    }

    public Evaluation(int IdMatiere, int ideleve, int note)
    {
        IdEleve=ideleve;
        this.IdMatiere = IdMatiere;
        this.note = note;
    }

    public int getIdDetailBulletin(){
        return this.IdMatiere;
    }

    public int getIdEleve(){
        return this.IdEleve;
    }

    public int getNote(){
        return this.note;
    }


    public void noter (EvaluationDao eval_test){
        System.out.println("-----Ajout nouvelle note-----");
        System.out.println("Choissiez une matière : 1=Francais, 2=Geographie, 3=Histoire, 4=Maths, 5=Anglais");
        int detail = scan.nextInt();
        System.out.println("Quelle note voulez vous mettre ? ");
        int note = scan.nextInt();
         System.out.println("A quelle élève voulez vous mettre cette note ? (par identifiant)");
        int ideleve = scan.nextInt();

        Evaluation new_eval = new Evaluation(detail,ideleve,note);

        if (new_eval==null){
            System.out.println("Note non rentrée");

        }
        else
            eval_test.create(new_eval);
            System.out.println("La note a bien été prise en compte");
    }
}
