package hhs.controllersAndScreens;

import hhs.proj2_klas6_groep6d.Gebruiker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ReisSysteemController implements Initializable {

    @FXML
    Button logoutKnop;
    @FXML
    Text puntensaldoText;

    @FXML
    public void puntenSaldoStart(){
        System.out.println(puntensaldoText.getText());
        //puntensaldoText.setText(gebruiker.getPunten().getAantalPunten() + "");
    }

    @FXML
    public void onLogoutClick() throws Exception {
        Stage stage = (Stage) logoutKnop.getScene().getWindow();
        LoginScherm loginScherm = new LoginScherm();
        loginScherm.start(new Stage());
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        puntenSaldoStart();
    }
}
