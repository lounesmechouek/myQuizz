package sample;

import Logique.*;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.TreeMap;

public class Utilitaires {
    public static Stage currentStage = new Stage();
    public static String valeurFormation;
    public static int positionFormation;
    public static String nameQuiz;

    public static Formation nouvelleFormation = new Formation();
    public static Notion nouvelleNotion = new Notion();
    public static QO nouvelleQuestionOuverte = new QO();
    public static QCM nouvelleQuestionCM = new QCM();
    public static QCU nouvelleQuestionCU = new QCU();



    @FXML
    public static ListView<String> listeQuestionsNotion = new ListView<>();
    @FXML
    public static ListView<String> listeTypesQuestionsNotion = new ListView<>();
    @FXML
    public static ChoiceBox<String> listeNotionsFormation = new ChoiceBox<>();
    @FXML
    public static ChoiceBox<String> listeFormationsFormateur = new ChoiceBox<>();

    @FXML
    public static DatePicker dateOuverture = new DatePicker();
    @FXML
    public static DatePicker dateFin = new DatePicker();
    @FXML
    public static ListView<String> listeNotions = new ListView<>();

    public static Formateur formateur = new Formateur();

/*
    //Création du formateur...
    public static Compte compteFormateur = new Compte("Issam","BMID");
    public static  Formateur formateur1 = new Formateur(compteFormateur,"Ben messaoud","Issam");
    public static ESIQuiz esiQuiz = new ESIQuiz();
    esiQuiz.listeFormateurs.put(formateur1.getCompte().getLogin(),formateur1);*/


}