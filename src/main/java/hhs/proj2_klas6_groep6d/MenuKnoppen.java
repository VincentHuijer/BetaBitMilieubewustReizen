package hhs.proj2_klas6_groep6d;

import hhs.Schermen.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class MenuKnoppen { //JavaFX class voor de knoppen in het menu.

    @FXML
    public static void onOverzichtKnopClick(Persoon gebruiker, Button overzichtKnop) throws Exception { // Opent overzicht scherm
        OverzichtScherm overzichtScherm = new OverzichtScherm();
        overzichtScherm.setLoggedIn(gebruiker);
        Stage stage = (Stage) overzichtKnop.getScene().getWindow();
        stage.close();
        overzichtScherm.start();
    }

    @FXML
    public static void onBeloningKnopClick(Persoon gebruiker, Button beloningKnop) throws Exception {
        Stage stage = (Stage) beloningKnop.getScene().getWindow();
        stage.close();
        if(!gebruiker.isAdmin()) {
            BeloningScherm beloningScherm = new BeloningScherm();
            beloningScherm.setLoggedIn(gebruiker);
            beloningScherm.start();
        }
        else if(gebruiker.isAdmin()){
            BeloningAdminScherm beloningAdminScherm = new BeloningAdminScherm();
            beloningAdminScherm.setLoggedIn(gebruiker);
            beloningAdminScherm.start();
        }
    }

    @FXML
    public static void onReisSchermKnopClick(Persoon gebruiker, Button reisSchermKnop) throws Exception {
        Stage stage = (Stage) reisSchermKnop.getScene().getWindow();
        stage.close();
        ReisSysteemScherm reisSysteemScherm = new ReisSysteemScherm();
        reisSysteemScherm.setLoggedIn(gebruiker);
        reisSysteemScherm.start();
    }

    @FXML
    public static void onLogoutKnopClick(Button logoutKnop) throws Exception {
        Stage stage = (Stage) logoutKnop.getScene().getWindow();
        LoginScherm loginScherm = new LoginScherm();
        loginScherm.start(new Stage());
        stage.close();
    }

    @FXML
    public static void onScorebordKnopClick(Persoon gebruiker, Button scorebordKnop) throws Exception { // Opent scorebord scherm
        ScorebordScherm scorebordScherm = new ScorebordScherm();
        scorebordScherm.setLoggedIn(gebruiker);
        Stage stage = (Stage) scorebordKnop.getScene().getWindow();
        stage.close();
        scorebordScherm.start();
    }
}
