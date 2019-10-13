package Logique;

import java.io.Serializable;
import java.util.*;

public class QCM extends Question implements Cloneable, Serializable {


    public void setPropositions(ArrayList<Proposition> propositions) {
        this.propositions = propositions;
    }

    private ArrayList<Proposition> propositions ;
    private int nbr_reponses_choisies ;
    public ArrayList<Proposition> getPropositions() {
        return propositions;
    }
    public QCM(){}

    public QCM(String enonce,Type_question type)
    {
        super(enonce,type);
        propositions = new ArrayList<Proposition>();

    }
    public QCM(String enonce,ArrayList<Proposition> propositions,Type_question type )
    {
        super(enonce,type);
       this.propositions = propositions;

    }
public void repondre()
{
    /*Parcourt la liste des propositions pour que l’apprenant choisir les propositions qu’il voit vraies. */
    Scanner sc = new Scanner(System.in);
    for (Proposition p:propositions
         ) {
        System.out.println(p.getEnonce()+" :  true/false ?");

        boolean c = sc.nextBoolean();

       if(c==true)    { p.setChoisie(true);entamee = true ; nbr_reponses_choisies++;}
       else if(c==false) {p.setChoisie(false);entamee = true ;}
          }


}

public void evaluer() throws Exception
{
    double d = propositions.size();
    double pourcentagePropos = 1/d ;
   // System.out.println(d);
    // parcourt la liste des propositions et voir si l'apprenant a choisi les bonnes // en suivant la methode d'evaluation expliquee
    if(entamee==false){throw new Exception();}
    else {
        for (Proposition p : propositions
        ) {
            if (((p.Valeur_de_verite() == true) && (p.isChoisie() == true)) || ((p.Valeur_de_verite() == false) && (p.isChoisie() == false))) {
                taux_de_reussit =  taux_de_reussit + (pourcentagePropos);
            }
            else if (((p.Valeur_de_verite() == true) && (p.isChoisie() == false)) || ((p.Valeur_de_verite() == false) && (p.isChoisie() == true))) {
                  taux_de_reussit = taux_de_reussit -(pourcentagePropos);
            }
            if ( this.taux_de_reussit < 0) {
                taux_de_reussit = 0;
            }
        }
    }
}
    public void visualiser()
    {
        System.out.println("enonce :"+this.getEnonce());
        System.out.println("nbr réponses choisies par apprenant :"+nbr_reponses_choisies);
    }
public void remplacer(QCM question,ArrayList<Proposition> propositions)
{

}
    @Override
    protected Object clone() throws CloneNotSupportedException {
        QCM clone = null;
        try
        {
            clone = (QCM) super.clone();
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
