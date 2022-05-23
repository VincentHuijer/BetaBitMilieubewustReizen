package hhs.controllersAndScreens;

import hhs.proj2_klas6_groep6d.*;
import hhs.proj2_klas6_groep6d.Gebruiker;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisterController {
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
            errorText.setText("Please fill in all fields!");
        }else if(!wachtwoordField.getText().equals(herhaalField.getText())){
            errorText.setText("Passwords don't match!");
        }
        else{
            Bedrijf bedrijf = new Bedrijf();
            for(Gebruiker gebruiker : bedrijf.getGebruikers()){
                if(gebruiker.getUsername().equals(gebruikersnaamField.getText())){
                    errorText.setText("Username already exists!");
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
