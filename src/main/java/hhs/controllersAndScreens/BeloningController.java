package hhs.controllersAndScreens;

import hhs.proj2_klas6_groep6d.Gebruiker;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BeloningController {
    BeloningScherm beloningScherm = new BeloningScherm();
    @FXML
    Button reisschermKnop;
    @FXML
    Button logoutKnop;

    @FXML
    public void onReisSchermKnop() throws Exception {
        Stage stage = (Stage) reisschermKnop.getScene().getWindow();
        Gebruiker gebruiker = beloningScherm.getLoggedIn();
        stage.close();
        ReisSysteemScherm reisSysteemScherm = new ReisSysteemScherm();
        reisSysteemScherm.setLoggedIn(gebruiker);
        reisSysteemScherm.start();
    }

    @FXML
    public void onLogoutClick() throws Exception {
        Stage stage = (Stage) logoutKnop.getScene().getWindow();
        LoginScherm loginScherm = new LoginScherm();
        loginScherm.start(new Stage());
        stage.close();
    }
}
