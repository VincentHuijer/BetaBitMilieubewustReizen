package hhs.Controllers;

import hhs.Schermen.*;
import hhs.proj2_klas6_groep6d.Bedrijf;
import hhs.proj2_klas6_groep6d.Gebruiker;
import hhs.proj2_klas6_groep6d.Reis;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class OverzichtController implements Initializable {
    OverzichtScherm overzichtScherm = new OverzichtScherm();
    Gebruiker gebruiker = overzichtScherm.getLoggedIn();
    ObservableList<Gebruiker> alleGebruikersScorebord = FXCollections.observableArrayList();

    @FXML
    Button logoutKnop;
    @FXML
    Button reisSchermKnop;
    @FXML
    Button beloningKnop;
    @FXML
    Button scorebordKnop;

    @FXML
    Text currentCO2;
    @FXML
    Text currentPunten;
    @FXML
    Text currentKM;

    @FXML
    Text oldCO2;
    @FXML
    Text oldPunten;
    @FXML
    Text oldKM;

    public void init(){
        Date date = new Date();
        int lastMonth = date.getMonth();
        int currentMonth = lastMonth + 1;

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

        Stats currentMonthStats = getMonthStats(currentMonth, alleGebruikersScorebord);
        Stats lastMonthStats = getMonthStats(lastMonth, alleGebruikersScorebord);

        currentCO2.setText(currentMonthStats.uitstoot + " g");
        currentPunten.setText(currentMonthStats.punten + "");
        currentKM.setText(currentMonthStats.km + " KM");

        oldCO2.setText(lastMonthStats.uitstoot + " g");
        oldPunten.setText(lastMonthStats.punten + "");
        oldKM.setText(lastMonthStats.km + " KM");
    }

    public Stats getMonthStats(int month, ObservableList<Gebruiker> alleGebruikersScorebord){
        Stats stats = new Stats();

        for(Gebruiker user: alleGebruikersScorebord){
            for(Reis trip: user.getAlleReizen()){
                if((trip.getDate().getMonth() + 1) == month){
                    stats.km += trip.getAfstand();
                    stats.uitstoot += trip.getCO2().getUitstoot();
                    stats.punten += trip.getPunten();
                }
            }
        }

        return stats;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        init();
    }

    @FXML
    public void onReisSchermKnopClick() throws Exception { // Opent reis scherm.
        Stage stage = (Stage) reisSchermKnop.getScene().getWindow();
        Gebruiker gebruiker = overzichtScherm.getLoggedIn();
        stage.close();
        ReisSysteemScherm reisSysteemScherm = new ReisSysteemScherm();
        reisSysteemScherm.setLoggedIn(gebruiker);
        reisSysteemScherm.start();
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
    public void onScorebordKnopClick() throws Exception { // Opent scorebord scherm
        ScorebordScherm scorebordScherm = new ScorebordScherm();
        scorebordScherm.setLoggedIn(gebruiker);
        Stage stage = (Stage) scorebordKnop.getScene().getWindow();
        stage.close();
        scorebordScherm.start();
    }

    @FXML
    public void onLogoutClick() throws Exception { // Logt gebruiker uit.
        Stage stage = (Stage) logoutKnop.getScene().getWindow();
        LoginScherm loginScherm = new LoginScherm();
        loginScherm.start(new Stage());
        stage.close();
    }
}

class Stats{
    public double uitstoot;
    public double punten;
    public double km;
}