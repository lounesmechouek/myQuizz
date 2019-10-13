package Logique;

import java.io.Serializable;

public class Utilisateur implements Serializable {
    private Compte compte ;
    private String nom;
    private String prenom;

    public Utilisateur(){}
    public Utilisateur(Compte compte, String nom, String prenom){
        this.compte=new Compte();
        this.nom=nom;
        this.prenom=prenom;
    }

    public Compte getCompte(){return compte;}
    public String getPrenom(){return prenom;}
    public String getNom(){return nom;}

    public void setNom(String nom){this.nom=nom;}
    public void setPrenom(String prenom){this.prenom=prenom;}
    public void setCompte(Compte compte){this.compte=compte;}

    public boolean authentifier(String login, String motDePasse){
        System.out.println("+++"+getCompte().getLogin()+"++");
        if ( (login == getCompte().getLogin()) && (motDePasse == getCompte().getMotDePasse()) )
            return true;

        else{
            if( (login == getCompte().getLogin()) && (motDePasse != getCompte().getMotDePasse()))
                System.out.println("Mot de passe incorrect !");

            else{
                if( (login != getCompte().getLogin()))
                    System.out.println("Nom d'Utilisateur inexistant !");
            }
            return false;

        }
    }

}
