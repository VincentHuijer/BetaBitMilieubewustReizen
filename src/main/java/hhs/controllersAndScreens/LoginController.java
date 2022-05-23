package hhs.controllersAndScreens;

import hhs.proj2_klas6_groep6d.Bedrijf;
import hhs.proj2_klas6_groep6d.Gebruiker;
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
    public void onLoginClick(){
        if(gebruikersnaamField.getText().equals("") || wachtwoordField.getText().equals("")){
            errorText.setText("Please fill in all fields!");
        }
        Bedrijf bedrijf = new Bedrijf();
        for(Gebruiker gebruiker : bedrijf.getGebruikers()){
            if(gebruiker.getUsername().equals(gebruikersnaamField.getText()) && gebruiker.getWachtwoord().equals(wachtwoordField.getText())){
                System.out.println("Logged in!");
                errorText.setText("");
                return;
            }
        }
        errorText.setText("Wrong username or password!");
    }

    @FXML
    public void onRegisterClick() throws Exception {
        Stage stage = (Stage) registerKnop.getScene().getWindow();
        stage.close();
        RegisterScherm registerScherm = new RegisterScherm();
        registerScherm.start(new Stage());
    }

}
