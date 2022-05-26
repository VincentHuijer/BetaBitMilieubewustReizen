package hhs.controllersAndScreens;

import hhs.proj2_klas6_groep6d.Gebruiker;
import hhs.proj2_klas6_groep6d.RewardsList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

public class BeloningController extends Observable implements Initializable {
    BeloningScherm beloningScherm = new BeloningScherm();
    RewardsList rewardsList = beloningScherm.getRewardsList();
    Gebruiker gebruiker = beloningScherm.getLoggedIn();
    @FXML
    Button reisschermKnop;
    @FXML
    Button logoutKnop;
    @FXML
    Button beloning1Knop;

    public void onBeloning1KnopClick(){
        double prijsInPunten = rewardsList.getRewardsLijst().get(0).getPunten();
        if(gebruiker.getPunten().getAantalPunten() >= prijsInPunten){
            gebruiker.getPunten().removePunten(prijsInPunten);
            setChanged();
            notifyObservers();
        }
        else{
            return;
        }
    }

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addObserver(beloningScherm);
    }
}
