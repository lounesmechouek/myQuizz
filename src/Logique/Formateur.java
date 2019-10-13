package Logique;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Formateur extends Utilisateur implements Serializable {

    private ArrayList<Formation> formations = new ArrayList<Formation>();
    private int idFormateur;

    public Formateur(){}

    public Formateur(Compte compte, String nom, String prenom) {
        super(compte, nom, prenom);
    }

    public Formateur(ArrayList<Formation> formations, Compte compte, String nom, String prenom){
        super(compte,nom,prenom);
        this.formations=formations;
    }

    public ArrayList<Formation> getFormations(){return formations;}
    public void setFormations(ArrayList<Formation> formations){this.formations = formations;}

    public int getID(){return idFormateur;}
    public void setID(int idFormateur){this.idFormateur=idFormateur;}


    //***************************    METHODES PUBLIQUES    **********************************

    public boolean ajouterApprenant(Apprenant apprenant, Formation formation){
        if( (formation.getApprenants()).contains(apprenant) || formation == null || apprenant == null )
            return false;

        else {
            (formation.getApprenants()).add(apprenant);
            return true;
        }

    }

    //****************************
    public boolean supprimerApprenant(Apprenant apprenant, Formation formation){
        if( !((formation.getApprenants()).contains(apprenant)) || formation == null || apprenant == null )
            return false;

        else{
            (formation.getApprenants()).remove(apprenant);
            return true;
        }
    }

    //****************************
    public boolean modifierApprenant(Apprenant apprenant, int numModif, Object nouvelleValeur){

        if(apprenant!=null && numModif>0 && numModif<7 && nouvelleValeur!=null) {
            switch (numModif) {
                case 1: //Changement de nom
                    apprenant.setNom((String) nouvelleValeur);
                    break;

                case 2: //Changement de prénom
                    apprenant.setPrenom((String) nouvelleValeur);
                    break;

                case 3: //Changement de login
                    (apprenant.getCompte()).setLogin((String) nouvelleValeur);
                    break;

                case 4: //Changement de mot de passe
                    ((apprenant).getCompte()).setMotDePasse((String) nouvelleValeur);
                    break;

                case 5: //Changement de date de naissance
                    (apprenant).setDateDeNaissance((Date) nouvelleValeur);
                    break;

                case 6: //Changement d'adresse
                    (apprenant).setAdresse((String) nouvelleValeur);
                    break;

               /* case 7: //Apporter une modification dans un Quiz
                    System.out.println("Veuillez préciser qu'elle modification apporter sur le Quiz");
                    Scanner a = new Scanner(System.in);
                    int numModifQuiz = a.nextInt();

                    ((Quiz) nouvelleValeur).modifierQuiz(numModifQuiz, nouvelleValeur); //La modification sera apportée selon le type.

                    break;*/
            }
            return true;
        }

        else
            return false;
    }

    //****************************
    public boolean ajouterNotion(Notion notion, Formation formation){
        if(notion != null && formation != null) {
            boolean resul = formation.ajouterNotion(notion);
            return (resul);
        }

        else
            return false;
    }

    //****************************
    public void ajouterQuestion (Question question,Notion notion, Formation formation){
        if(formation != null && notion != null && question != null){
            formation.ajouterQuestion(notion,question);

        }
    }

    //****************************
    public boolean visualiseQuiz(Quiz quiz){
        //Fonction d'affichage.

        Scanner a = new Scanner(System.in);
        System.out.println("Voulez-vous valider le quiz ?");

        String s = a.nextLine();

        if(s=="o")
            return true;
        else
            return false;
    }

    //****************************
    public boolean validerQuiz(Quiz quiz, Formation formation){
        if(visualiseQuiz(quiz) && !((formation.getQuizs()).contains(quiz)) && formation != null && quiz != null ) {
            (formation.getQuizs()).add(quiz);
            return true;
        }

        else
            return false;
    }

    //****************************
    @Override
    public boolean equals(Object obj){
        return( ((Formateur) obj).getCompte().getLogin()== this.getCompte().getLogin());
    }

    @Override
    public String toString(){
        return (this.getNom() + " " + this.getPrenom());
    }

}
