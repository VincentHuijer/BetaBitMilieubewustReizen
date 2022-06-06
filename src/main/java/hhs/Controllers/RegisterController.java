package hhs.Controllers;

import hhs.Schermen.LoginScherm;
import hhs.Schermen.ScorebordScherm;
import hhs.proj2_klas6_groep6d.*;
import hhs.proj2_klas6_groep6d.Gebruiker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

public class RegisterController{
    @FXML
    Button registerKnop;
    @FXML
    TextField voornaamField;
    @FXML
    TextField achternaamField;
    @FXML
    TextField gebruikersnaamField;
    @FXML
    PasswordField wachtwoordField;
    @FXML
    PasswordField herhaalField;
    @FXML
    TextField MedIDField;
    @FXML
    Text errorText;


    @FXML
    public void onRegisterClick() throws Exception {
        if(voornaamField.getText().equals("") || achternaamField.getText().equals("") || gebruikersnaamField.getText().equals("") ||
        wachtwoordField.getText().equals("") || herhaalField.getText().equals("") || MedIDField.getText().equals("")){
            errorText.setText("Vul alle velden in!");
        }else if(!wachtwoordField.getText().equals(herhaalField.getText())){
            errorText.setText("Wachtwoorden komen niet overeen!");
        }
        else{
            Bedrijf bedrijf = new Bedrijf();
            for(Gebruiker gebruiker : bedrijf.getGebruikers()){
                if(gebruiker.getUsername().equals(gebruikersnaamField.getText())){
                    errorText.setText("Gebruikersnaam bestaat al!");
                    return;
                }
            }
            errorText.setText("");
            Gebruiker gebruiker = new Gebruiker(gebruikersnaamField.getText(), wachtwoordField.getText(), voornaamField.getText(), achternaamField.getText());
            bedrijf.addGebruiker(gebruiker);
            LoginScherm loginScherm = new LoginScherm();
            Stage stage = (Stage) registerKnop.getScene().getWindow();
            stage.close();
            loginScherm.start(new Stage());
        }
    }

}
