package sample.Inscription;

import Logique.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class InscriptionController {
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
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Label messageCnx;

    @FXML
    private PasswordField password1;

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
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    void valider(ActionEvent event) {

      if(esiQuiz.listeFormateurs.containsKey(username.getText()))
      {
          messageCnx.setText("ce compte déja existe !");
          messageCnx.setTextFill(Color.RED);
      }
      else
      {
          Compte compteFormateur = new Compte(username.getText(),password.getText());

          Formateur formateur1 = new Formateur();

          formateur1.setCompte(compteFormateur);
          formateur1.setNom(nom.getText());
          formateur1.setPrenom(prenom.getText());
          esiQuiz.ajouterFormateur(formateur1);
          messageCnx.setText("compte crée avec succés !");
          messageCnx.setTextFill(Color.GREEN);
      }
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
