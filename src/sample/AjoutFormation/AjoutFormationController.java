package sample.AjoutFormation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static sample.Utilitaires.*;

public class AjoutFormationController {

    @FXML private TextField nomFormation = new TextField();
    @FXML private DatePicker dateOuv = new DatePicker();
    @FXML private DatePicker dateFermeture = new DatePicker();
    @FXML private TextField description = new TextField();
    @FXML private ChoiceBox<String> listeNotions = new ChoiceBox<>();
    @FXML private Label error = new Label();

    @FXML private void initialize(){
        nomFormation.setText("Veuillez donner un nom à la formation");
        description.setText("Veuillez donner une description à la formation");
    }

    @FXML public void allerCreerNotion() throws Exception{
        Stage stage = new Stage();
        Parent ajoutNotion = FXMLLoader.load(getClass().getResource("../AjoutNotion/AjoutNotion.fxml"));
        Scene scene = new Scene(ajoutNotion);

        stage.setTitle("Création d'une nouvelle notion");
        stage.setScene(scene);
        currentStage=stage;
        stage.show();
    }

    @FXML public void actualiser(){
        listeNotions.getItems().clear();
        listeNotions.getItems().setAll(listeNotionsFormation.getItems());
    }

    @FXML public void valider(){
        error.setText("");
        if( !(nomFormation.getText().equals("")) && !(nomFormation.getText().equals("Veuillez donner un nom à la formation"))
                && !(description.getText().equals("")) && !(description.getText().equals("Veuillez donner une description à la formation"))
                    && dateOuv.getValue()!= null && dateFermeture.getValue()!=null
                        && dateOuv.getValue().isBefore(dateFermeture.getValue())
                            && listeNotions.getItems()!=null){

            nouvelleFormation.setNom(nomFormation.getText());
            nouvelleFormation.setDateDebut(java.sql.Date.valueOf(dateOuv.getValue()));
            nouvelleFormation.setDateFin(java.sql.Date.valueOf(dateFermeture.getValue()));


            formateur.getFormations().add(nouvelleFormation);
            listeNotions.getItems().setAll(listeNotionsFormation.getItems());
            listeFormationsFormateur.getItems().add(nouvelleFormation.getNom());
        }

        else
            error.setText("Vérifiez bien que toutes les informations sont correctes");


    }


}
