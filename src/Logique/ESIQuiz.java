package Logique;

import java.io.Serializable;
import java.util.TreeMap;

public class ESIQuiz implements Serializable {
    private static int idFormateur=1;
    private static int idApprenant=1;

    public TreeMap<String, Formateur> getListeFormateurs() {
        return listeFormateurs;
    }

    public void setListeFormateurs(TreeMap<String, Formateur> listeFormateurs) {
        this.listeFormateurs = listeFormateurs;
    }

    public TreeMap<Integer, Apprenant> getListeApprenants() {
        return listeApprenants;
    }

    public void setListeApprenants(TreeMap<Integer, Apprenant> listeApprenants) {
        this.listeApprenants = listeApprenants;
    }

    public TreeMap<String,Formateur> listeFormateurs = new TreeMap<String, Formateur>();
    public TreeMap<Integer,Apprenant> listeApprenants = new TreeMap<Integer, Apprenant>();

    public void ajouterFormateur(Formateur formateur){
        listeFormateurs.put(formateur.getCompte().getLogin(),formateur);
        //idFormateur++;
    }

    public void supprimerFormateur(String login){
        listeFormateurs.remove(login);
    }

    public void ajouterApprenant(Apprenant apprenant){
        listeApprenants.put(idApprenant,apprenant);
        idApprenant++;
    }

    public void supprimerApprenant(int idApprenant){listeApprenants.remove(idApprenant);}

    public int getIdDernierFormateur(){return idFormateur-1;}
    public int getIdDernierApprenant(){return idApprenant-1;}

}
