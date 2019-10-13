package sample;

import Logique.Formateur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Logique.*;
import sample.Connexion.LoginController;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.TreeMap;

import static sample.Utilitaires.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        final String filepath="C:\\Users\\Lounes\\Desktop\\TP_BEN_MESSAOUD_MECHOUEK_GRAPHIQUE\\Interface_Formateur\\src\\fichiers\\EsiQuiz";
       // ESIQuiz esiQuiz = new ESIQuiz();
        ESIQuiz esiQuiz = (ESIQuiz) ReadObjectFromFile(filepath);
      /*//Création du formateur...
        Compte compteFormateur = new Compte("admin","admin");

        Formateur formateur1 = new Formateur();

        formateur1.setCompte(compteFormateur);
        formateur1.setNom("Ben Messaoud");
        formateur1.setPrenom("Issam");
        esiQuiz.ajouterFormateur(formateur1);
        System.out.println(esiQuiz.listeFormateurs.firstKey());
        //esiQuiz.listeFormateurs.put(formateur1.getCompte().getLogin(),formateur1);
        /*-----------------------*/
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Connexion/Login.fxml"));
        Parent root = loader.load();
        LoginController controller = loader.<LoginController>getController();
        controller.setEsiQuiz(esiQuiz);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("miseEnForme.css").toExternalForm());
        primaryStage.setTitle("ESI Quiz");
        primaryStage.setScene(scene);
        currentStage=primaryStage;
        //changement du style de la fenetre
        scene.setFill(Color.TRANSPARENT);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();


    }
    public Object ReadObjectFromFile(String filepath) {

        try {

            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            System.out.println("l'objet est lu à partir du fichier");
            objectIn.close();
            return obj;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
