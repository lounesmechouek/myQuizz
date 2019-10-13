package Logique;

import java.io.Serializable;
import java.util.*;

public class Formation  implements Serializable {
    private String nom;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private ArrayList<Apprenant> apprenants = new ArrayList<Apprenant>();
    private ArrayList<Notion> notions = new ArrayList<Notion>();
    private ArrayList<Quiz> quizs = new ArrayList<Quiz>();

    //*******************
    public Formation(){};

    public Formation(String nom, String description, Date dateDebut,
                     Date dateFin,ArrayList<Apprenant> apprenants, ArrayList<Notion> notions
            ,ArrayList<Quiz> quizs){

        this.nom=nom; this.description=description; this.dateDebut=dateDebut;
        this.dateFin=dateFin; this.apprenants=apprenants; this.notions=notions;
        this.quizs=quizs;
    }

    public ArrayList<Apprenant> getApprenants(){return this.apprenants;}
    public void setApprenants(ArrayList<Apprenant> apprenants){this.apprenants=apprenants;}

    public ArrayList<Quiz> getQuizs(){return this.quizs;}
    public void setQuizs(ArrayList<Quiz> quizs){this.quizs=quizs;}

    public ArrayList<Notion> getNotions(){return notions;}
    public void setNotions(ArrayList<Notion> notions){this.notions=notions;}

    public String getNom(){return nom;}
    public void setNom(String nom){this.nom=nom;}

    public String getDescription(){return description;}
    public void setDescription(String description){this.description=description;}

    public Date getDateDebut(){return dateDebut;}
    public void setDateDebut(Date dateDebut){this.dateDebut=dateDebut;}

    public Date getDateFin(){return dateFin;}
    public void setDateFin(Date dateFin){this.dateFin=dateFin;}

    //*******************
    public boolean ajouterNotion(Notion notion){
        if( (notions.contains(notion)) || notion == null )
            return false;
        else{
            notions.add(notion);
            return true;
        }
    }

    //*******************
    public void ajouterQuestion(Notion notion, Question question){
        if(notion != null && question != null)
            notion.ajouter_question(question);

    }

    //*******************
    public void classerApprenants(){
        Collections.sort(apprenants);
        Collections.reverse(apprenants);
    }



}
