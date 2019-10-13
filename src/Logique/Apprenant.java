package Logique;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Apprenant extends Utilisateur implements Comparable<Apprenant>{
    private Date dateDeNaissance;
    private String adresse;
    private ArrayList<Quiz> quizs = new ArrayList<Quiz>();
    private int idApprenant;

    //************************ CONSTRUCTEURS / GETTERS ****************************

    public Apprenant(){}


    // "compte" doit être généré à l'aide de genererInfosConnexion avant d'appeler le constructeur d'Apprenant.
    public Apprenant(Compte compte, String nom, String prenm, Date dateDeNaissance , String adresse, ArrayList<Quiz> quizs) {
        super(compte, nom, prenm);
        this.adresse = adresse;
        this.dateDeNaissance = dateDeNaissance;
        this.quizs=quizs;
    }
    public Date getDateNaissance(){return dateDeNaissance;}
    public void setDateDeNaissance(Date dateDeNaissance){this.dateDeNaissance = dateDeNaissance;}

    public String getAdresse(){return adresse;}
    public void setAdresse(String adresse){this.adresse=adresse;}

    public ArrayList<Quiz> getQuizs(){return quizs;}
    public void setQuizs(ArrayList<Quiz> quizs){this.quizs=quizs;}

    public int getIdApprenant() {
        return idApprenant;
    }

    public void setIdApprenant(int idApprenant) {
        this.idApprenant = idApprenant;
    }

    //************************          METHODES        ***************************
    public Compte genererInfosConnexion(String nom, String prenm, Date dateDeNaissance){
        //Génération du login et du mot de passe :
        char[] prenom = prenm.toCharArray();
        String login = prenom[1]+nom;
        String motDePasse = nom+dateDeNaissance.toString();

        Compte compte = new Compte(login,motDePasse);
        return compte;
    }

    //************************
    public boolean ajouterQuiz(Quiz quiz){
        if(quiz==null)
            return false;

        else{
            quizs.add(quiz);
            return true;
        }

    }

    //*********************
    public void consulterActivite(){
        for(Quiz parcours : quizs){

            if(parcours.getEtat() == Etat_du_Quiz.EVALUE){
                System.out.println("Quiz : "+ parcours.getNom());
                System.out.println("Etat : "+ parcours.getEtat());
                System.out.println("Pourcentage de réussite : "+ parcours.getTaux_reussite_apprenant());
                System.out.println("************************************************");
            }

            else if(parcours.getEtat() == Etat_du_Quiz.NON_ACCOMPLI ||
                        parcours.getEtat() == Etat_du_Quiz.ACCOMPLI ||
                            parcours.getEtat() == Etat_du_Quiz.EXPIRE){

                System.out.println("Quiz : "+ parcours.getNom());
                System.out.println("Etat : "+ parcours.getEtat());
                System.out.println("Taux d'accomplissement : "+ parcours.getTauxAccomplissement());
                System.out.println("************************************************");
            }

        }

    }

    //*******************************************
    public double getTauxReussiteMoyen(){
        double moy=0;
        double nbQuizs= quizs.size();
        for(Quiz parcours : quizs){
            if(parcours.getEtat() == Etat_du_Quiz.EVALUE){
                moy+=parcours.getTaux_reussite_apprenant();
            }

        }
        System.out.println(moy);
        return moy = (moy/nbQuizs);
    }

    //*******************************************
    @Override
    public int compareTo(Apprenant o){
        return Double.compare(this.getTauxReussiteMoyen(),o.getTauxReussiteMoyen());

    }
}

