package hhs.controllersAndScreens;

import hhs.proj2_klas6_groep6d.Gebruikers;
import hhs.proj2_klas6_groep6d.Persoon;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController {
    private Gebruikers gebruikers = new Gebruikers();

    @FXML
    Button loginKnop,registerKnop;
    @FXML
    TextField gebruikersnaamField,wachtwoordField,MedID;
    @FXML
    Text errorText;

    @FXML
    public void onLoginClick() throws Exception {
        if(gebruikersnaamField.getText().equals("") || wachtwoordField.getText().equals("")){
            errorText.setText("Vul alle velden in!");
        }
        for(Persoon gebruiker : gebruikers.getGebruikers()){
            if(auth(gebruiker, wachtwoordField.getText(), gebruikersnaamField.getText(),Integer.parseInt(MedID.getText()))){
                errorText.setText("");
                Stage stage = (Stage) loginKnop.getScene().getWindow();
                stage.close();
                ReisSysteemScherm reisSysteemScherm = new ReisSysteemScherm();
                reisSysteemScherm.setLoggedIn(gebruiker);
                reisSysteemScherm.start();
            }
        }
        errorText.setText("Account wordt niet herkend!");
    }
    public boolean auth(Persoon gebruiker, String password, String username, int MedID){
        return gebruiker.getUsername().equals(username) && gebruiker.getWachtwoord().equals(password) && gebruiker.getId() == MedID;
    }

    @FXML
    public void onRegisterClick() throws Exception { //registreer knop in het login scherm.
        Stage stage = (Stage) registerKnop.getScene().getWindow();
        stage.close();
        RegisterScherm registerScherm = new RegisterScherm();
        registerScherm.start();
    }

}
