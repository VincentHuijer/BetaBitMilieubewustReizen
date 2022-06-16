package hhs.controllersAndScreens;

import hhs.proj2_klas6_groep6d.GebruikersOpslag;
import hhs.proj2_klas6_groep6d.Gebruiker;
import hhs.proj2_klas6_groep6d.MenuKnoppen;
import hhs.proj2_klas6_groep6d.Persoon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.*;

public class ScorebordController implements Initializable {
    Persoon gebruiker = ScorebordScherm.getLoggedIn();
    ObservableList<Persoon> alleGebruikersScorebord = FXCollections.observableArrayList();

    @FXML
    Button logoutKnop,beloningKnop,reisSchermKnop,overzichtKnop;

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
    private TableColumn<Gebruiker, String> Totaal_KM = new TableColumn<>("Totaal KM");

    @FXML
    public void onOverzichtKnopClick() throws Exception { // Opent overzicht scherm
        MenuKnoppen.onOverzichtKnopClick(gebruiker, overzichtKnop);
    }

    @FXML
    public void onBeloningKnopClick() throws Exception {
        MenuKnoppen.onBeloningKnopClick(gebruiker, beloningKnop);
    }

    @FXML
    public void onReisSchermKnopClick() throws Exception {
        MenuKnoppen.onReisSchermKnopClick(gebruiker, reisSchermKnop);
    }

    @FXML
    public void onLogoutKnopClick() throws Exception {
        MenuKnoppen.onLogoutKnopClick(logoutKnop);
    }

    public void fillList(){
        alleGebruikersScorebord.clear();
        GebruikersOpslag gebruikersOpslag = new GebruikersOpslag();
        alleGebruikersScorebord.addAll(gebruikersOpslag.getGebruikers());
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

        Old.setText("CO2 " + maanden[month - 1] + " (kg)");
        Current.setText("CO2 " + maanden[month] + " (kg)");
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
