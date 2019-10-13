package Logique;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class QO extends Question implements Cloneable, Serializable {

    private ArrayList<String> reponsesVraies;
    private String reponseApprenant;
    //******************
    public QO(){}
    public QO(String enonce, ArrayList<String> reponsesVraies,Type_question type) {
        super(enonce,type);
        this.reponsesVraies = reponsesVraies;
    }

    //******************
    public void setReponsesVraies(ArrayList<String> reponsesVraies){this.reponsesVraies=reponsesVraies;}

    //******************
    public void repondre() {
        /*Affecte la réponse de l’apprenant à l’attribut ‘réponse_apprenant*/
        Scanner sc = new Scanner(System.in);
        String reponseApprenant = sc.nextLine();
       this.reponseApprenant = reponseApprenant ;
       entamee = true;
    }

    //******************
    public void changerReponse()
    {reponseApprenant= ""; entamee=false;repondre();}


    //******************
    public void evaluer() throws Exception {
        if(entamee == false){throw new Exception();}
        else {
            if(reponsesVraies.contains(reponseApprenant)){ taux_de_reussit=1;}
        }
    }
    //******************
    public void visualiser()
    {
        System.out.println("enonce :"+this.getEnonce());
        System.out.println("réponse apprenant :"+this.reponseApprenant);
    }

    //******************
    public void remplacer(Question question)
    {

    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        QO clone = null;
        try
        {
            clone = (QO) super.clone();
            clone.setReponsesVraies((ArrayList<String>) reponsesVraies.clone() );
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException(e);
        }
        return clone;
    }
}

