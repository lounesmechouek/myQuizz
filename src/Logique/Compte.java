package Logique;

import java.io.Serializable;

public class Compte implements Serializable {
    private String login;
    private String motDePasse;

    public Compte(){}

    public Compte(String login, String motDePasse) {
        this.login = login;
        this.motDePasse = motDePasse;
    }

    public String getLogin(){return login;}
    public String getMotDePasse(){return  motDePasse;}

    public void setLogin(String login){this.login=login;}
    public void setMotDePasse(String motDePasse){this.motDePasse=motDePasse;}
}
