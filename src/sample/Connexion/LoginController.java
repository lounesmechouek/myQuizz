package sample.Connexion;
import static sample.Utilitaires.*;

import Logique.ESIQuiz;
import Logique.Formateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Inscription.InscriptionController;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    double x= 0;
    double y=0;

    public ESIQuiz getEsiQuiz() {
        return esiQuiz;
    }

    public void setEsiQuiz(ESIQuiz esiQuiz) {
        this.esiQuiz = esiQuiz;
    }

    ESIQuiz esiQuiz = new ESIQuiz();
    final String filepath="C:\\Users\\Lounes\\Desktop\\TP_BEN_MESSAOUD_MECHOUEK_GRAPHIQUE\\Interface_Formateur\\src\\fichiers\\EsiQuiz";
    @FXML
    void dragged(MouseEvent event) {
Node node = (Node) event.getSource();
Stage stage = (Stage) node.getScene().getWindow();
        stage.setX(event.getScreenX()-x);
        stage.setY(event.getScreenY()-y);
    }

    @FXML
    void pressed(MouseEvent event) {
     x = event.getSceneX() ;
     y = event.getSceneY() ;
    }



    // bouton pour fermer la fenetre oû il y aura le sauvegarde de l'état du programme

    @FXML
    private void closeButtonAction(MouseEvent event){
        // get a handle to the stage
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        // do what you have to do
        // sauvegarde des données :
        WriteObjectToFile(esiQuiz);
        stage.close();
    }

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;
    @FXML
    private Label messageCnx;
    @FXML
    void connecter(ActionEvent event) {
         messageCnx.setText("");
         if(username.getText().equals("") || password.getText().equals(""))
        {
            messageCnx.setText("veuillez remplir tous les champs SVP !");
            messageCnx.setTextFill(Color.RED);
        }
        else {
        if(esiQuiz.listeFormateurs.containsKey(username.getText()) == true)
        {
           Formateur formateu = esiQuiz.getListeFormateurs().get(username.getText());
          boolean authen = formateu.getCompte().getMotDePasse().equals(password.getText());
            messageCnx.setText("connection avec succès");
            messageCnx.setTextFill(Color.GREEN);

          if (authen == true) {
              formateur = formateu;
              Stage stage = new Stage();
              try {
                  Parent formations = FXMLLoader.load(getClass().getResource("../Formations/sample.fxml"));
                  Scene scene = new Scene(formations);
                  stage.setTitle("Gestion des formations");
                  stage.setScene(scene);
                  currentStage=stage;
                  stage.show();
              } catch (IOException e) {
                  e.printStackTrace();
              }

          }
          else {
              messageCnx.setText("mot de passe erroné !");
              messageCnx.setTextFill(Color.RED);
          }

        }
        else
        {
             messageCnx.setText("Compte non existant !");
             messageCnx.setTextFill(Color.RED);
        }
    }
    }
    @FXML
    void inscrire(ActionEvent event) {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Inscription/Inscription.fxml"));
            Parent inscriptions = loader.load();
            InscriptionController controller = loader.<InscriptionController>getController();
            controller.setEsiQuiz(esiQuiz);
            Scene scene = new Scene(inscriptions);
            stage.setTitle("Inscription");
            stage.setScene(scene);
            currentStage=stage;
            //changement du style de la fenetre
            scene.setFill(Color.TRANSPARENT);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void WriteObjectToFile(Object serObj) {

        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("l'objet est bien sauvegardé dans le fichier");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
