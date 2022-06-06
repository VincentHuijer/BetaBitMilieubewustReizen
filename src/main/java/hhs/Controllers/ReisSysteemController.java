package hhs.Controllers;

import hhs.Schermen.*;
import hhs.proj2_klas6_groep6d.Gebruiker;
import hhs.proj2_klas6_groep6d.Punten;
import hhs.proj2_klas6_groep6d.Reis;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ReisSysteemController extends Observable implements Initializable{
    ReisSysteemScherm reisSysteemScherm = new ReisSysteemScherm();
    Gebruiker gebruiker = reisSysteemScherm.getLoggedIn();
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
    @FXML
    CheckBox woonwerkCheck;
    @FXML
    CheckBox zakelijkCheck;
    @FXML
    Button addReisKnop;
    @FXML
    Text berekenPuntenText;
    @FXML
    TextField kmTextField;
    @FXML
    Button scorebordKnop;
    @FXML
    Button overzichtKnop;

    @FXML
    public void onOverzichtKnopClick() throws Exception { // Opent overzicht scherm
        OverzichtScherm overzichtScherm = new OverzichtScherm();
        overzichtScherm.setLoggedIn(gebruiker);
        Stage stage = (Stage) overzichtKnop.getScene().getWindow();
        stage.close();
        overzichtScherm.start();
    }

    public void onScorebordKnopClick() throws Exception { // Opent scorebord scherm
        ScorebordScherm scorebordScherm = new ScorebordScherm();
        scorebordScherm.setLoggedIn(gebruiker);
        Stage stage = (Stage) scorebordKnop.getScene().getWindow();
        stage.close();
        scorebordScherm.start();
    }

    public void onReisKnopClick(){ // Maakt een reis aan die aan de gebruiker wordt toegevoegd op het moment dat hij/zij een reis toevoegt. Geeft ook de juiste hoeveelheid punten aan gebruiker.
        Reis reis = null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        Gebruiker gebruiker = reisSysteemScherm.getLoggedIn();
        Punten puntenGebruiker = gebruiker.getPunten();
        double km;
        double punten = 0;
        if (kmTextField.getText().equals("")) {
            km = 0;
        } else {
            km = Double.parseDouble(kmTextField.getText());
        }
        boolean elektrisch = false;
        if (elektrischeAutoCheck.isSelected()) {
            elektrisch = true;
        }
        if(woonwerkCheck.isSelected()){
            punten = gebruiker.getPunten().berekenAantalPuntenWoonWerkVerkeer(100, km, vervoersMiddel, elektrisch);
            reis = new Reis(new Date(dtf.format(now)), punten, km, vervoersMiddel);
        }else if(zakelijkCheck.isSelected()){
            punten = gebruiker.getPunten().berekenAantalPuntenZakelijkVerkeer(km, vervoersMiddel, elektrisch);
            reis = new Reis(new Date(dtf.format(now)), punten, km, vervoersMiddel);
        }
        gebruiker.getAlleReizen().add(reis);
        gebruiker.berekenTotaalKM();
        puntenGebruiker.addPunten(punten);
        setChanged();
        notifyObservers(vervoersMiddel);
    }

    public void onWoonwerkClick(){ // Toepassing observer pattern
        zakelijkCheck.setSelected(!woonwerkCheck.isSelected());
        setChanged();
        notifyObservers(vervoersMiddel);
    }

    public void onZakelijkClick(){ // Toepassing observer pattern
        woonwerkCheck.setSelected(!zakelijkCheck.isSelected());
        setChanged();
        notifyObservers(vervoersMiddel);
    }

    public void onElektrischeAutoCheckBoxClick(){
        onTextChanged();
    }

    @FXML
    public void onBeloningKnopClick() throws Exception { // Opent beloning scherm. Als gebruiker een admin is opent het het admin scherm voor beloningen.
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
    public void onLogoutClick() throws Exception { // Logt gebruiker uit.
        Stage stage = (Stage) logoutKnop.getScene().getWindow();
        LoginScherm loginScherm = new LoginScherm();
        loginScherm.start(new Stage());
        stage.close();
    }
    @FXML
    public void onTextChanged(){ // Toepassing observer pattern
        String vervoer = vervoersMiddel;
        setChanged();
        notifyObservers(vervoer);
    }

    @FXML public void onKnopClick(ActionEvent event){ // Kiezen van gebruikt vervoersmiddel.
        Node node = (Node) event.getSource() ;
        String data = (String) node.getUserData();

        String vervoer  = data;
        vervoersMiddel = data;

        setChanged();
        notifyObservers(vervoer);

        Button button = (Button) event.getTarget();
        changeColors(button);
    }

    @FXML
    public void changeColors(Button clickButton){ // Veranderen kleur knoppen bij kiezen.
        Stage scene = (Stage) logoutKnop.getScene().getWindow();

        ArrayList<Button> buttons = new ArrayList<>();

        Button autoButton = (Button) scene.getScene().lookup("#autoKnop");
        Button regionaalOVButton = (Button) scene.getScene().lookup("#regionaalKnop");
        Button tramButton = (Button) scene.getScene().lookup("#tramKnop");
        Button lopenButton = (Button) scene.getScene().lookup("#fietsKnop");

        buttons.add(autoButton);
        buttons.add(regionaalOVButton);
        buttons.add(tramButton);
        buttons.add(lopenButton);

        String styling = "";

        for (Button b: buttons){
            if(b == clickButton){
                styling += "-fx-border-color: #63D13C;";
            }else{
                styling += "-fx-border-color: #FFFFFF;";
            }

            styling += "-fx-background-color: #FFFFFF; -fx-border-radius: 4;";
            b.setStyle(styling);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addObserver(reisSysteemScherm);
    } // Toevoegen observer aan reissysteemscherm.
}
