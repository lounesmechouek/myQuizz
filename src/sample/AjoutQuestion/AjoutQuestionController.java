package sample.AjoutQuestion;

import Logique.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.awt.*;

import static sample.Utilitaires.*;

public class AjoutQuestionController {

    @FXML private javafx.scene.control.TextField enonce = new javafx.scene.control.TextField();
    @FXML private ChoiceBox<String> type = new ChoiceBox<>();
    @FXML private javafx.scene.control.Label error2 = new Label();

    @FXML private void initialize(){
        enonce.setText("Veuillez entrer un énoncé");
        ObservableList<String> liste = FXCollections.observableArrayList();
        liste.addAll("QCM", "QCU", "QO");

        type.setItems(liste);
    }

    @FXML public void valider(){
        error2.setText("");
        if(!(enonce.getText().equals("")) && !(enonce.getText().equals("Veuillez entrer un énoncé"))
                && type.getValue()!=null){


            if(type.getValue().equals("QO")){
                nouvelleQuestionOuverte.setType(Type_question.QO);
                nouvelleQuestionOuverte.setEnonce(enonce.getText());
                nouvelleNotion.getQuestions().add(nouvelleQuestionOuverte);
                listeQuestionsNotion.getItems().add(nouvelleQuestionOuverte.getEnonce());
                listeTypesQuestionsNotion.getItems().add("QO");

            }
            else{
                if (type.getValue().equals("QCU")){
                    nouvelleQuestionCU.setType(Type_question.QCU);
                    nouvelleQuestionCU.setEnonce(enonce.getText());
                    nouvelleNotion.getQuestions().add(nouvelleQuestionCU);
                    listeQuestionsNotion.getItems().add(nouvelleQuestionCU.getEnonce());
                    listeTypesQuestionsNotion.getItems().add("QCU");}
                else if(type.getValue().equals("QCM")){
                    nouvelleQuestionCM.setType(Type_question.QCM);
                    nouvelleQuestionCM.setEnonce(enonce.getText());
                    nouvelleNotion.getQuestions().add(nouvelleQuestionCM);
                    listeQuestionsNotion.getItems().add(nouvelleQuestionCM.getEnonce());
                    listeTypesQuestionsNotion.getItems().add("QCM");
                }
            }

            currentStage.close();

        }
        else
            error2.setText("Vérifiez bien que les informations sont correctes");

    }



}
