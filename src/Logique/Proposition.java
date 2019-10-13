package Logique;

import java.io.Serializable;

public class Proposition implements  Cloneable, Serializable {
    public String getEnonce() {
        return enonce;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    private  String enonce ;

    public boolean Valeur_de_verite() {
        return valeur_de_verite;
    }

    public void setValeur_de_verite(boolean valeur_de_verite) {
        this.valeur_de_verite = valeur_de_verite;
    }

    private boolean valeur_de_verite ;

    public boolean isChoisie() {
        return choisie;
    }

    public void setChoisie(boolean choisie) {
        this.choisie = choisie;
    }

    private boolean choisie ;
    public Proposition(String enonce,boolean valeur_de_verite)
    {
        this.enonce = enonce ;
        this.valeur_de_verite = valeur_de_verite ;
    }
    public void choisir()
    {
        choisie = true ;
    }
    public void decocher()
    {choisie = false; }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Proposition clone = null;
        try
        {
            clone = (Proposition) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException(e);
        }
        return clone;
    }

}
