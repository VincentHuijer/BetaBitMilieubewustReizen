package hhs.controllersAndScreens;

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
    Button logoutKnop,autoKnop,regionaalKnop,tramKnop,fietsKnop,beloningKnop;

    @FXML
    Text puntensaldoText,berekenPuntenText;
    @FXML
    CheckBox elektrischeAutoCheck,woonwerkCheck,zakelijkCheck;
    @FXML
    Button addReisKnop,scorebordKnop,overzichtKnop;
    @FXML
    TextField kmTextField;
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
        //Zodra een reis is toegevoegd, wordt de observer op de hoogte gesteld.
        //Op deze manier worden de punten van de gebruiker meteen geupdate.
        changeAddReisKnopKleur(gebruiker.getPunten().getAantalPunten());
    }

    public void onWoonwerkClick(){ // Toepassing observer pattern
        zakelijkCheck.setSelected(!woonwerkCheck.isSelected());
        setChanged();
        notifyObservers(vervoersMiddel);
        //Zodra er op woon werk verkeer is geklikt zal de punten berekening worden aangepast op basis van de formule
        //voor woon werk verkeer. De observer wordt hiervan op de hoogte gesteld.
    }

    public void onZakelijkClick(){ // Toepassing observer pattern
        woonwerkCheck.setSelected(!zakelijkCheck.isSelected());
        setChanged();
        notifyObservers(vervoersMiddel);
        //Hier geldt hetzelfde als hierboven bij woon werk verkeer.
    }

    public void onElektrischeAutoCheckBoxClick(){
        onTextChanged();
    }

    @FXML
    public void onTextChanged(){ // Toepassing observer pattern
        String vervoer = vervoersMiddel;
        setChanged();
        notifyObservers(vervoer);
        //Zodra het aantal kilometers dat een gebruiker invult gewijzigd wordt, wordt de observer op de hoogte gesteld.
        //De hoeveelheid punten die bij de verschillende opties staat worden dan aangepast.
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
        //Zodra een bepaald vervoersmiddel is geselecteerd, wordt de observer op de hoogte gesteld en zal de puntenberekening
        //Die overeenkomt met dat vervoersmiddel worden uitgevoerd. De hoeveelheid punten die de gebruiker zal krijgen wordt dan
        //op het scherm getoond.
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
    public String generateReisKnopKleur(double punten){
        String styling = "";
        if(punten < 1000){
            styling = "-fx-background-color: #63D13c;";
        }else if(punten >= 1000 && punten < 3000){
            styling = "-fx-background-color: #0033ff;";
        }else if(punten >= 3000){
            styling = "-fx-background-color: #ff4400;";
        }
        return styling;
    }
    public void changeAddReisKnopKleur(double punten){
        addReisKnop.setStyle(generateReisKnopKleur(punten));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        changeAddReisKnopKleur(gebruiker.getPunten().getAantalPunten());
        addObserver(reisSysteemScherm);
    } // Toevoegen observer aan reissysteemscherm.
}
