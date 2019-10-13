package sample.ValiderQuiz;

import Logique.Formation;
import Logique.Notion;
import Logique.Question;
import Logique.Quiz;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;

import static sample.Utilitaires.*;


public class ValiderQuizController {

    private ObservableList<String> listeDesNotions = FXCollections.observableArrayList();
    private ObservableList<String> listeDesQuestions = FXCollections.observableArrayList();
    private ObservableList<String> listeDesTypes = FXCollections.observableArrayList();

    @FXML private Label nomQuiz;
    @FXML private Label dateOuv;
    @FXML private Label dateFerm;
    @FXML private ListView<String> viewNotion = new ListView<>();
    @FXML private ListView<String> viewQuestion = new ListView<>();
    @FXML private ListView<String> viewType = new ListView<>();



    @FXML
    private void initialize(){
        nomQuiz.setText(nameQuiz);
        dateOuv.setText(dateOuverture.getValue().toString());
        dateFerm.setText(dateFin.getValue().toString());



        for(Formation form : formateur.getFormations()){
            if(valeurFormation==form.getNom()){
                for(Notion notion : form.getNotions()){
                    if(listeNotions.getSelectionModel().getSelectedItems().contains(notion.getNom())) {
                        for (Question quest : notion.getQuestions()) {
                            listeDesNotions.add(notion.getNom());
                            listeDesQuestions.add(quest.getEnonce());
                            listeDesTypes.add(quest.getType().toString());
                        }
                    }
                }
                break;
            }
        }

        viewNotion.getItems().addAll(listeDesNotions);
        viewQuestion.getItems().addAll(listeDesQuestions);
        viewType.getItems().addAll(listeDesTypes);

    }

    /**
     * Fonction de validation du Quiz
     */

    public void validerQuiz(){

        Quiz quiz = new Quiz();
        quiz.setNom(nameQuiz);
        quiz.setDate_expiration( java.sql.Date.valueOf(dateFin.getValue()) );
        quiz.setDate_ouverture( java.sql.Date.valueOf(dateOuverture.getValue()) );


        ArrayList<Notion> notions = new ArrayList<>();

        for(Formation form : formateur.getFormations()){
            if(valeurFormation==form.getNom()){
                for(Notion notion : form.getNotions()){
                    if(listeNotions.getSelectionModel().getSelectedItems().contains(notion.getNom())) {
                        notions.add(notion);
                    }
                }
                quiz.setNotions(notions);
                form.getQuizs().add(quiz);
                break;
            }
        }

        currentStage.close();
    }

    /**
     * Fonction d'annulation
     */

    public void annuler(){currentStage.close();}

}
