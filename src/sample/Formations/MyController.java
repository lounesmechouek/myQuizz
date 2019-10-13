package sample.Formations;
import Logique.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Utilitaires;

import java.util.Date;

import static sample.Utilitaires.*;


public class MyController {

    private Utilitaires test = new Utilitaires();

    @FXML private ChoiceBox<String> listeFormation = new ChoiceBox<>();
    @FXML private TableView<Quiz> tableQuiz = new TableView<>();
    @FXML private TableColumn<Quiz, String> colonneNom;
    @FXML private TableColumn<Quiz, Date> colonneDateDebut;
    @FXML private TableColumn<Quiz, Date> colonneDateFin;
    @FXML private Button creerQuiz = new Button();
    @FXML private Button maj = new Button();
    @FXML private Button creerFormation = new Button();
    @FXML private Button affichQuiz = new Button();

    public ChoiceBox<String> getListFormation(){ return listeFormation;}

    /**
     * La méthode initialize permettra d'initialiser tous les composants de la fenêtre
     */
    @FXML
    private void initialize(){
        ObservableList<String> liste = getListeFormations();
        listeFormation.setItems(liste);

        colonneNom.setCellValueFactory(new PropertyValueFactory<Quiz, String>("nom"));
        colonneDateDebut.setCellValueFactory(new PropertyValueFactory<Quiz, Date>("date_ouverture"));
        colonneDateFin.setCellValueFactory(new PropertyValueFactory<Quiz, Date>("date_expiration"));

        tableQuiz.setVisible(false);
        creerQuiz.setVisible(false);
        maj.setVisible(false);
    }

    /**
     * getListeFormations renverra une ObservableList qui servira à la méthode "initialize".
     * Grâce à cette valeur de retour on pourra initialiser la ChoiceBox.
     * Il faut enlever le message "Aucune formation trouvée" à l'ajout d'une formation.
     */
    public ObservableList<String> getListeFormations(){
        ObservableList<String> liste = FXCollections.observableArrayList();

        if(formateur.getFormations().isEmpty()){
            liste.add("Aucune formation trouvée");}


        else{
            for(Formation elt : formateur.getFormations()){
                liste.add(elt.getNom());
            }}

        return liste;
    }

    /**
     * Cette méthode permet le remplissage de la table des Quizs de la formation.
     */
    @FXML
    public void affichageQuizs(){
        int cpt=0;
        Boolean continuer = true;
        ObservableList<Quiz> liste = FXCollections.observableArrayList();

        if (listeFormation.getValue() != "Aucune formation trouvée" && listeFormation.getValue() != null){
                for( Formation form : formateur.getFormations()){
                     cpt++;
                     if(form.getNom().equals(listeFormation.getValue())){
                         for(Quiz qz : form.getQuizs())
                             liste.add(qz);
                         break;
                     }
                }
                valeurFormation=listeFormation.getValue();
                positionFormation=cpt;
                tableQuiz.setItems(liste);

                creerQuiz.setVisible(true);
                tableQuiz.setVisible(true);
                maj.setVisible(true);
        }
    }

    /**
     * En cas d'appui sur le bouton "Ajouter Quiz"
     * @throws Exception
     */
    @FXML
    public void allerCreerQuiz() throws Exception{
        Stage stage = new Stage();
        Parent ajoutQuiz = FXMLLoader.load(getClass().getResource("../AjoutQuiz/ajouterQuiz.fxml"));
        Scene scene = new Scene(ajoutQuiz);



        stage.setTitle("Création d'un nouveau quiz");
        stage.setScene(scene);
        currentStage=stage;
        stage.show();
    }

    /**
     * En cas d'appui sur le bouton "Ajouter Formation"
     */

    @FXML
    public void allerCreerFormation() throws Exception{
        Stage stage = new Stage();
        Parent ajoutFormation = FXMLLoader.load(getClass().getResource("../AjoutFormation/AjoutFormation.fxml"));
        Scene scene = new Scene(ajoutFormation);

        stage.setTitle("Création d'une nouvelle formation");
        stage.setScene(scene);
        currentStage=stage;
        stage.show();
    }

    /**
     * Actualisation de la liste des formations
     */
    @FXML public void actualiser(){
        listeFormation.getItems().clear();
        listeFormation.getItems().setAll(listeFormationsFormateur.getItems());
    }


}
