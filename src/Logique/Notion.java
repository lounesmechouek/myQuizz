package Logique;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Notion implements Cloneable, Serializable {
    private String nom ;
    private HashSet<Question> questions = new HashSet<>();
    private int nbr_de_question ;/*Un entier saisi par le formateur, il indique le nombre de questions qui vont apparaître pour l’apprenant dans le quiz si la notion est déjà choisie*/

    public Notion(){};

    public Notion(String nom, HashSet<Question> questions,int nbr_de_question) {
        this.nom = nom;
        this.questions = questions;
        this.nbr_de_question =nbr_de_question;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public HashSet<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(HashSet<Question> questions) {
        this.questions = questions;
    }

    public int getNbr_de_question() {
        return nbr_de_question;
    }

    public void setNbr_de_question(int nbr_de_question) {
        this.nbr_de_question = nbr_de_question;
    }


    public void ajouter_question(Question question)
    {
        questions.add(question);
    }
    public void supprimer_question(Question question)
    {
        questions.remove(question);
    }
    public void remplacer_question(Question questionA,Question questionB) throws Exception
    {
        if(questionA.getType() != questionB.getType()){throw new Exception();}
        else {
            questions.remove(questionA);
            questions.add(questionB);
        }

    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Notion clone = null;
        try
        {
            clone = (Notion) super.clone();
            HashSet<Question> questionsCopie = new HashSet<Question>();
            for (Question q: questions
                 ) {
                questionsCopie.add((Question) q.clone());
            }
            clone.setQuestions(questionsCopie);
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException(e);
        }
        return clone;
    }


}

