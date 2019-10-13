package Logique;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Quiz implements Cloneable, Serializable {
    private String nom ;

    public void setNom(String nom) {
        this.nom = nom;
    }

    private Date date_ouverture;

    public void setDateOuverture(Date date){
        this.date_ouverture=date;
    }

    public void setDateExpiration(Date date){
        this.date_expiration=date;
    }


    private Date date_expiration;

    private ArrayList<Notion> notions = new ArrayList<Notion>()  ;
private boolean quizOuvert;
    public Etat_du_Quiz getEtat() {
        setEtat();
        return etat;

    }


    public double getTauxAccomplissement() {
        return tauxAccomplissement;
    }

    public void setTauxAccomplissement() {
        int nbrQuestionsTotal =0;
        int nbrQuestionsEntamee = 0 ;
        for (Notion n:notions
        ) {
            HashSet<Question> q = n.getQuestions();
            nbrQuestionsTotal += q.size();
            for (Question ques: q
            ) {
                if (ques.isEntamée()){nbrQuestionsEntamee++;}
            }
        }

        this.tauxAccomplissement= nbrQuestionsEntamee*100/nbrQuestionsTotal;
    }

    public boolean setEtat() {
        if(etat != Etat_du_Quiz.EVALUE) {
            // verification si le quiz est expiré :x
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date dateCourante = new Date();
            if (date_expiration.before(dateCourante)) {
                etat = Etat_du_Quiz.EXPIRE;
                return false;
            }
            // verification si le quiz est accompli à 100%
            int nbrQuestionsTotal =0;
            int nbrQuestionsEntamee = 0 ;
            for (Notion n:notions
            ) {
                HashSet<Question> q = n.getQuestions();
                nbrQuestionsTotal += q.size();
                for (Question ques: q
                     ) {
                if (ques.isEntamée()){nbrQuestionsEntamee++;}
                }
            }
            if (nbrQuestionsEntamee==nbrQuestionsTotal){etat = Etat_du_Quiz.ACCOMPLI;tauxAccomplissement=100;}
            else {tauxAccomplissement= nbrQuestionsEntamee*100/nbrQuestionsTotal;}

        }
        return true;
    }
    public void setEtat(Etat_du_Quiz etat) {
        this.etat = etat ;
    }

    public  Etat_du_Quiz etat = Etat_du_Quiz.NON_ACCOMPLI ;
     public double taux_reussite_apprenant=0 ;
     public double tauxAccomplissement=0 ;
   public Quiz(){}

    public Quiz(String nom, Date date_ouverture, Date date_expiration, ArrayList<Notion> notions) {
        this.nom = nom;
        this.date_ouverture = date_ouverture;
        this.date_expiration = date_expiration;
        this.notions = notions;
    }

    public double getTaux_reussite_apprenant() {
        return taux_reussite_apprenant;
    }

    public void setTaux_reussite_apprenant(double taux_reussite_apprenant) {
        this.taux_reussite_apprenant = taux_reussite_apprenant;
    }

    //****************************
    public String getNom(){return nom;}
    public Date getDate_ouverture(){return date_ouverture;}
    public Date getDate_expiration(){return date_expiration;}
    public ArrayList<Notion> getNotions(){return notions;}

    //****************************
    public void modifer_titre(String titre) throws Exception{
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dateCourante = new Date();
        if (dateCourante.before(date_ouverture)) {
            this.nom = titre;
        }else {throw  new Exception();}
    }

    //****************************
    public void modifier_dates(Date ouverture,Date expiration)throws Exception{
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dateCourante = new Date();
        if (dateCourante.before(date_ouverture)) {
            this.date_ouverture = date_ouverture;
            this.date_expiration = date_expiration;
        }else {throw  new Exception();}

    }

    //****************************
    public void supprimerQuestion(Notion notion,Question question) throws Exception{
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dateCourante = new Date();
        if (dateCourante.before(date_ouverture)) {
            if(notions.contains(notion))
            {notion.getQuestions().remove(question);}
        }else {throw new Exception();}
    }

    //****************************
    public void ajouter_question(Notion notion,Question question) throws Exception{
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dateCourante = new Date();
        if (dateCourante.before(date_ouverture)) {
            if(notions.contains(notion))
            {notion.getQuestions().add(question);}
        }else {throw new Exception();}

        }


    //****************************
    public void changer_question(Notion notion,Question avant,Question apres){

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dateCourante = new Date();
        if (dateCourante.before(date_ouverture)) {
            if(notions.contains(notion))
            {
                {notion.getQuestions().remove(avant);}
                notion.getQuestions().add(apres);

            }
        }
    }


    //****************************
    public void visualiser_quiz(){
        System.out.println("Nom "+nom);
        System.out.println("Date ouverture : "+date_ouverture.toString());
        System.out.println("Date expiration : "+date_expiration.toString());
        System.out.println("Etat : "+etat.toString());
        System.out.println("Notions & questions :");
        for (Notion n:notions
             ) {
            HashSet<Question> questions = n.getQuestions();
            for (Question q:questions
                 ) {
              q.visualiser();
            }
        }
    }
    public void afficher_quiz(){}


    public void repondre(){
       setEtat();
       if(etat != Etat_du_Quiz.EVALUE && etat != Etat_du_Quiz.EXPIRE)
       {
        for (Notion n:notions
             ) {
            System.out.println("Notion : "+n.getNom());
            HashSet<Question> questions = n.getQuestions();
            for (Question q:questions
                 ) {
                System.out.println(q.getType().toString()+" : "+q.getEnonce());
               q.repondre();

            }
        }}
    }
    public void evaluer() throws Exception{
       setEtat();
       if(etat != Etat_du_Quiz.ACCOMPLI) {throw new Exception();}
       else
       {
       int nbrQuestionsTotal =0;
       double tauxReussitTotal =0;
        for (Notion n:notions
             )
            nbrQuestionsTotal += n.getQuestions().size();
       // appliquons la formule donnée pour évaluer le quiz :
//
        for (Notion n: notions
             ) {
           HashSet<Question> ques = n.getQuestions();
            for (Question q: ques
                 ) {
                q.evaluer();
                tauxReussitTotal+=q.getTaux_de_reussit();
              //  System.out.println(tauxReussitTotal);
            }
        }
       etat = Etat_du_Quiz.EVALUE;
          // System.out.println(taux_reussite_apprenant);
           //System.out.println(nbrQuestionsTotal);
        taux_reussite_apprenant = tauxReussitTotal*100/nbrQuestionsTotal ;}
       }
    public void ajouter_notion(Notion notion){}
    public void supprimer_notion(Notion notion){}
    /*-------------getters and setters -------------------*/
    public void setDate_ouverture(Date date_ouverture) {
        this.date_ouverture = date_ouverture;
    }

    public void setDate_expiration(Date date_expiration) {
        this.date_expiration = date_expiration;
    }

    public void setNotions(ArrayList<Notion> notions) {
        this.notions = notions;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Quiz clone = null;
        try
        {
            clone = (Quiz) super.clone();

            //Copy new date object to cloned method
            // cloner les dates ---> n'est pas nécessaires : la meme date pour toutes les copies d'un quiz
           // clone.setDate_ouverture((Date) this.getDate_ouverture().clone());
           // clone.setDate_expiration((Date) this.getDate_expiration().clone());
            /// cloner la liste des notions :
            ArrayList<Notion> NotionsListClone = new ArrayList<>();

            for (Notion n:notions
                 ) {
                NotionsListClone.add((Notion) n.clone());
            }
            clone.setNotions(NotionsListClone);
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException(e);
        }
        return clone;
    }



}
