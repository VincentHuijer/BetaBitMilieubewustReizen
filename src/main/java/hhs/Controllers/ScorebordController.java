package hhs.Controllers;

import hhs.Schermen.*;
import hhs.proj2_klas6_groep6d.Bedrijf;
import hhs.proj2_klas6_groep6d.Gebruiker;
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
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class ScorebordController implements Initializable {
    ScorebordScherm scorebordScherm = new ScorebordScherm();
    Gebruiker gebruiker = scorebordScherm.getLoggedIn();
    ObservableList<Gebruiker> alleGebruikersScorebord = FXCollections.observableArrayList();

    @FXML
    Button logoutKnop;
    @FXML
    Button beloningKnop;
    @FXML
    Button reisSchermKnop;
    @FXML
    private TableView<Gebruiker> tableView = new TableView<>();
    @FXML
    private TableColumn<Gebruiker, String> Gebruikersnaam = new TableColumn<>("Gebruikersnaam");
    @FXML
    private TableColumn<Gebruiker, Double> Punten = new TableColumn<>("Punten");
    @FXML
    private TableColumn<Gebruiker, Double> CO2_Uitstoot = new TableColumn<>("CO2 Uitstoot");
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
    }

    public void update() {
        fillList();
        Gebruikersnaam.setCellValueFactory(new PropertyValueFactory<>("username"));
        Punten.setCellValueFactory(new PropertyValueFactory<>("Monthpunten"));
        CO2_Uitstoot.setCellValueFactory(new PropertyValueFactory<>("Monthco2Uitstoot"));
        Totaal_KM.setCellValueFactory(new PropertyValueFactory<>("MonthtotaalKm"));
        tableView.getItems().setAll(alleGebruikersScorebord);
    }
}
