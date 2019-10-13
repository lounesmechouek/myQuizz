package Logique;

import java.io.Serializable;
import java.util.*;

public class QCU extends Question implements Serializable {


    public void setPropositions(ArrayList<Proposition> propositions) {
        this.propositions = propositions;
    }

    private ArrayList<Proposition> propositions ;
    private int nbr_propositions_choisies ; // ne depasse pas 1
    private int indice_reponse_choisie = -1;
    public QCU(String enonce,ArrayList<Proposition> propositions,Type_question type) {
        super(enonce,type);
        this.propositions = propositions;
    }
    public ArrayList<Proposition> getPropositions() {
        return propositions;
    }

    public QCU(){}

    public void repondre()
    {
        int i =0 ;
        Scanner sc = new Scanner(System.in);
       while(nbr_propositions_choisies == 0)
       {
           System.out.println(propositions.get(i).getEnonce()+" true(vrai) ou false(faux) ?");

           boolean c = sc.nextBoolean();

           if(c==true)   { propositions.get(i).setChoisie(true);indice_reponse_choisie = i;entamee = true; nbr_propositions_choisies++ ; }

       }

       }

    public void changer_réponse()
    {
        if(entamee==true)
        {
            indice_reponse_choisie =-1;
            nbr_propositions_choisies=0;
            repondre();
        }
    }


    public void evaluer() throws Exception
    {
        if(entamee==false){throw new Exception();}
        else {
       if(propositions.get(indice_reponse_choisie).Valeur_de_verite()==true){ taux_de_reussit=1;}
       else {taux_de_reussit=0;}
        }

    }
    public void visualiser()
    {
        System.out.println("enonce :"+this.getEnonce());
        System.out.println("réponse apprenant :"+propositions.get(indice_reponse_choisie));
    }
    public void remplacer(Question question)
    {

    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        QCU clone = null;
        try
        {
            clone = (QCU) super.clone();
            ArrayList<Proposition> propositionsCopie = new ArrayList<Proposition>();
            for (Proposition p:propositions
            ) {
                propositionsCopie.add((Proposition) p.clone());
            }
            clone.setPropositions(propositionsCopie);
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException(e);
        }
        return clone;
    }
}
