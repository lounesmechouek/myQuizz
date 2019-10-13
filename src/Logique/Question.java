package Logique;

import java.io.Serializable;

public abstract class Question implements Cloneable , Serializable {
    private String enonce ;
    protected boolean entamee ; //Mise à true dans la méthode répondre () (l’apprenant doit saisir une réponse pour que la
    //question sera considérée entamée), utile pour calculer le taux d’accomplissement d’un quiz.
    private Type_question type;
    protected double taux_de_reussit;

    public String getEnonce() {
        return enonce;
    }

    public Question(){}



    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public boolean isEntamée() {
        return entamee;
    }

    public void setEntamée(boolean entamee) {
        this.entamee = entamee;
    }

    public Type_question getType() {
        return type;
    }

    public void setType(Type_question type) {
        this.type = type;
    }

    public double getTaux_de_reussit() {
       return taux_de_reussit;
    }

    public void setTaux_de_reussit(double taux_de_reussit) {
        this.taux_de_reussit = taux_de_reussit;
    }

    public Question(String enonce,Type_question type)
    {this.enonce  =enonce ; this.type = type ;}
   // abstract void repondre();
    //abstract void remplacer(Question question);
     abstract void evaluer() throws Exception;
      abstract  void visualiser();
      abstract void repondre();
      protected Object clone() throws CloneNotSupportedException{
          Question clone = null;
          try
          {
              clone = (Question) super.clone();
          }
          catch (CloneNotSupportedException e)
          {
              throw new RuntimeException(e);
          }
          return clone;
      }

      @Override
    public boolean equals(Object o) {
        if(o instanceof Question){
            Question other = (Question) o;
            return enonce.equals(other.getEnonce());
        }

        return false;
    }

    @Override
    public int hashCode() {
        return enonce.hashCode();
    }

}
