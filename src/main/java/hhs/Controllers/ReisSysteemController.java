package hhs.Controllers;

import hhs.Schermen.*;
import hhs.proj2_klas6_groep6d.*;
import hhs.proj2_klas6_groep6d.Persoon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ReisSysteemController extends Observable implements Initializable{
    ReisSysteemScherm reisSysteemScherm = new ReisSysteemScherm();
    Persoon gebruiker = reisSysteemScherm.getLoggedIn();
    private String vervoersMiddel = "Auto";
    double punten = 0;
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
    DatePicker datePicker;

    @FXML
    public void onOverzichtKnopClick() throws Exception { // Opent overzicht scherm
        MenuKnoppen.onOverzichtKnopClick(gebruiker, overzichtKnop);
    }

    @FXML
    public void onBeloningKnopClick() throws Exception {
        MenuKnoppen.onBeloningKnopClick(gebruiker, beloningKnop);
    }

    @FXML
    public void onLogoutClick() throws Exception {
        MenuKnoppen.onLogoutKnopClick(logoutKnop);
    }

    public void onScorebordKnopClick() throws Exception { // Opent scorebord scherm
        MenuKnoppen.onScorebordKnopClick(gebruiker, scorebordKnop);
    }

    public void onReisKnopClick(){ // Maakt een reis aan die aan de gebruiker wordt toegevoegd op het moment dat hij/zij een reis toevoegt. Geeft ook de juiste hoeveelheid punten aan gebruiker.
        Reis reis = null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        Persoon gebruiker = reisSysteemScherm.getLoggedIn();
        Punten puntenGebruiker = gebruiker.getPunten();
        double km;
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
            punten = BerekenPunten.berekenAantalPuntenWoonWerkVerkeer(100, km, vervoersMiddel, elektrisch);
            reis = new Reis(new Date(dtf.format(datePicker.getValue())), punten, km, vervoersMiddel, gebruiker, elektrisch);
        }else if(zakelijkCheck.isSelected()){
            punten = BerekenPunten.berekenAantalPuntenZakelijkVerkeer(km, vervoersMiddel, elektrisch);
            reis = new Reis(new Date(dtf.format(datePicker.getValue())), punten, km, vervoersMiddel, gebruiker, elektrisch);
        }
        gebruiker.getAlleReizen().add(reis);
        gebruiker.berekenTotaalKM();
        puntenGebruiker.addPunten(punten);
        setChanged();
        notifyObservers(vervoersMiddel);
        changeAddReisKnopKleur(gebruiker.getPunten().getAantalPunten());
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
    public void changeColors(Button clickButton) { // Veranderen kleur knoppen bij kiezen.
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

        for (Button b : buttons) {
            if (b == clickButton) {
                styling += "-fx-border-color: #63D13c;";
            } else {
                styling += "-fx-border-color: #ffffff;";
            }
            styling += "-fx-background-color: #ffffff; -fx-border-radius: 5;";
            b.setStyle(styling);
        }
    }

    public String changeAddReisKnopKleur(double punten){
        String styling = "";
        if (punten < 1000) {
                    styling += "-fx-background-color: #63D13c;";
            addReisKnop.setStyle(styling);
                } else if (punten >= 1000 && gebruiker.getPunten().getAantalPunten()  < 3000) {
                    styling = "-fx-background-color: #0033ff;";
                    addReisKnop.setStyle(styling);
                }
        else {
            styling = "-fx-background-color: #ff4400;";
            addReisKnop.setStyle(styling);
        }
        return styling;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addObserver(reisSysteemScherm);
    } // Toevoegen observer aan reissysteemscherm.
}
