package sample.AjoutNotion;

import Logique.Quiz;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.awt.*;

import static sample.Utilitaires.*;

public class AjoutNotionController {

    @FXML private javafx.scene.control.TextField notionName = new javafx.scene.control.TextField();
    @FXML private ListView<String> viewIntitule = new ListView<>();
    @FXML private ListView<String> viewType = new ListView<>();
    @FXML private javafx.scene.control.Label error1 = new Label();

    @FXML private void initialize(){
        notionName.setText("Donnez un nom à la notion");
    }

    @FXML public void allerCreerQuestion() throws Exception{
        Stage stage = new Stage();
        Parent ajoutQuestion = FXMLLoader.load(getClass().getResource("../AjoutQuestion/AjoutQuestion.fxml"));
        Scene scene = new Scene(ajoutQuestion);

        stage.setTitle("Création d'une nouvelle question");
        stage.setScene(scene);
        currentStage=stage;
        stage.show();
    }

    @FXML public void actualiser(){
        viewIntitule.getItems().clear();
        viewType.getItems().clear();
        viewIntitule.getItems().addAll(listeQuestionsNotion.getItems());
        viewType.getItems().addAll(listeTypesQuestionsNotion.getItems());
    }

    @FXML public void valider(){
        error1.setText("");
        if( (notionName.getText().equals(""))==false && (notionName.getText().equals("Donnez un nom à la notion"))== false) {
             nouvelleNotion.setNom(notionName.getText());

            nouvelleFormation.ajouterNotion(nouvelleNotion);
            listeNotionsFormation.getItems().add(nouvelleNotion.getNom());
        }

        else
            error1.setText("Vérifiez bien que les informations sont correctes");
    }

}
