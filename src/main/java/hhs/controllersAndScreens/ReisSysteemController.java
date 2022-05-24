package hhs.controllersAndScreens;

import hhs.proj2_klas6_groep6d.Gebruiker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class ReisSysteemController extends Observable implements Initializable{
    ReisSysteemScherm reisSysteemScherm = new ReisSysteemScherm();
    private String vervoersMiddel = "Auto";
    @FXML
    Button logoutKnop;
    @FXML
    Text puntensaldoText;
    @FXML
    Button autoKnop;
    @FXML
    Button regionaalKnop;
    @FXML
    Button tramKnop;
    @FXML
    Button fietsKnop;
    @FXML
    Button beloningKnop;
    @FXML
    CheckBox elektrischeAutoCheck;

    public void onElektrischeAutoCheckBoxClick(){
        onTextChanged();
    }

    @FXML
    public void onBeloningKnopClick() throws Exception {
        Gebruiker gebruiker = reisSysteemScherm.getLoggedIn();
        Stage stage = (Stage) beloningKnop.getScene().getWindow();
        stage.close();
        BeloningScherm beloningScherm = new BeloningScherm();
        beloningScherm.setLoggedIn(gebruiker);
        beloningScherm.start();
    }

    @FXML
    public void onLogoutClick() throws Exception {
        Stage stage = (Stage) logoutKnop.getScene().getWindow();
        LoginScherm loginScherm = new LoginScherm();
        loginScherm.start(new Stage());
        stage.close();
    }
    @FXML
    public void onTextChanged(){
        String vervoer = vervoersMiddel;
        setChanged();
        notifyObservers(vervoer);
    }
    @FXML
    public void onAutoKnopClick(){
        vervoersMiddel = "Auto";
        setChanged();
        notifyObservers(vervoersMiddel);
    }
    @FXML
    public void onRegionaalKnopClick(){
        vervoersMiddel = "RegionaalOV";
        setChanged();
        notifyObservers(vervoersMiddel);
    }
    @FXML
    public void onTramKnopClick(){
        vervoersMiddel = "Tram";
        setChanged();
        notifyObservers(vervoersMiddel);
    }
    @FXML
    public void onFietsKnopClick(){
        vervoersMiddel = "Fiets";
        setChanged();
        notifyObservers(vervoersMiddel);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addObserver(reisSysteemScherm);
    }
}
