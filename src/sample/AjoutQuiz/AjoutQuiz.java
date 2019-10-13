package sample.AjoutQuiz;

import Logique.Formation;
import Logique.Notion;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import static sample.Utilitaires.*;

public class AjoutQuiz {

    @FXML private TextField nomQuiz = new TextField();
    @FXML private DatePicker dateOuv = new DatePicker();
    @FXML private DatePicker dateFerm = new DatePicker();
    @FXML private ListView<String> listNot = new ListView<>();
    @FXML private Button VisuQuiz = new Button();
    @FXML private Label erreur = new Label();
    @FXML private Button validQuiz = new Button();

    /**
     * Initialisation de la fenêtre.
     */
    @FXML private void initialize(){

        nomQuiz.setText("Veuillez entrer le nom du quiz");

        ObservableList<String> liste = FXCollections.observableArrayList();

        for (Formation form : formateur.getFormations()){
            if(form.getNom().equals(valeurFormation)){
                for(Notion not : form.getNotions()){
                    liste.add(not.getNom());
                }
            }
        }
        listNot.getItems().setAll(liste);
        listNot.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    /**
     * Ouverture de la fenêtre de visualisation du Quiz
     */
    public void allerVisualisation() throws Exception{

        if ( !(nomQuiz.getText().equals("Veuillez entrer le nom du quiz"))
                && !(nomQuiz.getText().equals(""))
                    && (dateOuv.getValue()!=null) && (dateFerm.getValue()!=null)
                        && (dateOuv.getValue().isBefore(dateFerm.getValue()))
                            && (listNot.getSelectionModel().getSelectedItems().isEmpty() == false)){


            //Les attributs statiques de "Utilitaires" nous aideront à remplir l'aperçu du quiz.
            nameQuiz=nomQuiz.getText();
            dateOuverture=dateOuv;
            dateFin=dateFerm;
            listeNotions=listNot;


            Stage stage = new Stage();
            Parent visuQuiz = FXMLLoader.load(getClass().getResource("../ValiderQuiz/ValiderQuiz.fxml"));
            Scene scene = new Scene(visuQuiz);

            stage.setTitle("Visualisation Quiz");
            stage.setScene(scene);
            currentStage=stage;
            stage.show();}

        else
            erreur.setText("Veillez bien à remplir tous les champs et séléctionner au moins une notion");


    }
}
