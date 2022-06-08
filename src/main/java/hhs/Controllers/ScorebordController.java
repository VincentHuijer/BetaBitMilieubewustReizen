package hhs.Controllers;

import hhs.Schermen.*;
import hhs.proj2_klas6_groep6d.Bedrijf;
import hhs.proj2_klas6_groep6d.Gebruiker;
import hhs.proj2_klas6_groep6d.Persoon;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.net.URL;
import java.util.*;

public class ScorebordController implements Initializable {
    ScorebordScherm scorebordScherm = new ScorebordScherm();
    Persoon gebruiker = scorebordScherm.getLoggedIn();
    ObservableList<Persoon> alleGebruikersScorebord = FXCollections.observableArrayList();

    @FXML
    Button logoutKnop;
    @FXML
    Button beloningKnop;
    @FXML
    Button reisSchermKnop;
    @FXML
    private TableView<Persoon> tableView = new TableView<>();
    @FXML
    private TableColumn<Gebruiker, String> Gebruikersnaam = new TableColumn<>("Gebruikersnaam");
    @FXML
    private TableColumn<Gebruiker, Double> Punten = new TableColumn<>("Punten");
    @FXML
    private TableColumn<Gebruiker, Double> Old = new TableColumn<>("CO2 Old");
    @FXML
    private TableColumn<Gebruiker, Double> Current = new TableColumn<>("CO2 Current");
    @FXML
    private TableColumn<Gebruiker, Double> Totaal_KM = new TableColumn<>("Totaal KM");
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

    public void onBeloningKnopClick() throws Exception {
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

    public void onReisSchermKnopClick() throws Exception {
        Stage stage = (Stage) reisSchermKnop.getScene().getWindow();
        stage.close();
        ReisSysteemScherm reisSysteemScherm = new ReisSysteemScherm();
        reisSysteemScherm.setLoggedIn(gebruiker);
        reisSysteemScherm.start();
    }

    public void onLogoutKnopClick() throws Exception {
        Stage stage = (Stage) logoutKnop.getScene().getWindow();
        LoginScherm loginScherm = new LoginScherm();
        loginScherm.start(new Stage());
        stage.close();
    }

    public void fillList(){
        alleGebruikersScorebord.clear();
        Bedrijf bedrijf = new Bedrijf();
        for(int i =0; i<bedrijf.getGebruikers().size(); i++){
                alleGebruikersScorebord.add(bedrijf.getGebruikers().get(i));
        }
        for(int j = 0; j<alleGebruikersScorebord.size(); j++){
            if(alleGebruikersScorebord.get(j).isAdmin()){
                alleGebruikersScorebord.remove(j);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        update();
        String[] maanden = {"Jan", "Feb", "Maa", "Apr", "Mei", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dec"};
        int month = new Date().getMonth();

        Old.setText("CO2 " + maanden[month - 1]);
        Current.setText("CO2 " + maanden[month]);
    }

    public void update() {
        fillList();
        Gebruikersnaam.setCellValueFactory(new PropertyValueFactory<>("username"));
        Punten.setCellValueFactory(new PropertyValueFactory<>("Monthpunten"));
        Old.setCellValueFactory(new PropertyValueFactory<>("OldMonthco2Uitstoot"));
        Current.setCellValueFactory(new PropertyValueFactory<>("Monthco2Uitstoot"));
        Totaal_KM.setCellValueFactory(new PropertyValueFactory<>("MonthtotaalKm"));
        tableView.getItems().setAll(alleGebruikersScorebord);
    }
}
