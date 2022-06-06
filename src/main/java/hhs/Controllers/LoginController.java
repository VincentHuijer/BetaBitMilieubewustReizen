package hhs.Controllers;

import hhs.Schermen.RegisterScherm;
import hhs.Schermen.ReisSysteemScherm;
import hhs.proj2_klas6_groep6d.Bedrijf;
import hhs.proj2_klas6_groep6d.Gebruiker;
import hhs.proj2_klas6_groep6d.Persoon;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    Button loginKnop;
    @FXML
    Button registerKnop;
    @FXML
    TextField gebruikersnaamField;
    @FXML
    TextField wachtwoordField;
    @FXML
    Text errorText;



    @FXML
    public void onLoginClick() throws Exception {
        if(gebruikersnaamField.getText().equals("") || wachtwoordField.getText().equals("")){
            errorText.setText("Vul alle velden in!");
        }
        Bedrijf bedrijf = new Bedrijf();
        for(Persoon gebruiker : bedrijf.getGebruikers()){
            if(gebruiker.getUsername().equals(gebruikersnaamField.getText()) && gebruiker.getWachtwoord().equals(wachtwoordField.getText())){
                errorText.setText("");
                Stage stage = (Stage) loginKnop.getScene().getWindow();
                stage.close();
                ReisSysteemScherm reisSysteemScherm = new ReisSysteemScherm();
                reisSysteemScherm.setLoggedIn(gebruiker);
                reisSysteemScherm.start();
            }
        }
        errorText.setText("Verkeerd wachtwoord of gebruikersnaam!");
    }

    @FXML
    public void onRegisterClick() throws Exception {
        Stage stage = (Stage) registerKnop.getScene().getWindow();
        stage.close();
        RegisterScherm registerScherm = new RegisterScherm();
        registerScherm.start(new Stage());
    }

}
