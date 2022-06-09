package hhs.Controllers;

import hhs.Schermen.*;
import hhs.proj2_klas6_groep6d.*;
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
    Persoon gebruiker = overzichtScherm.getLoggedIn();
    ObservableList<Persoon> alleGebruikersScorebord = FXCollections.observableArrayList();

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

    @FXML
    Text currentMonthTitle;
    @FXML
    Text lastMonthTitle;

    public void init(){
        Date date = new Date();
        int lastMonth = date.getMonth();
        int currentMonth = lastMonth + 1;

        String[] maanden = {"Januari", "Februari", "Maart", "April", "Mei", "Juni", "Juli", "Augustus", "September", "Oktober", "November", "December"};

        currentMonthTitle.setText(maanden[currentMonth - 1].toUpperCase());
        lastMonthTitle.setText(maanden[lastMonth - 1].toUpperCase());

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

        currentCO2.setText(String.format("%.2f g",currentMonthStats.uitstoot));
        currentPunten.setText(String.format("%.0f",currentMonthStats.punten));
        currentKM.setText(String.format("%.1f KM",currentMonthStats.km));

        oldCO2.setText(String.format("%.2f g",lastMonthStats.uitstoot));
        oldPunten.setText(String.format("%.0f",lastMonthStats.punten));
        oldKM.setText(String.format("%.1f KM",lastMonthStats.km));
    }

    public Stats getMonthStats(int month, ObservableList<Persoon> alleGebruikersScorebord){
        Stats stats = new Stats();

        for(Persoon user: alleGebruikersScorebord){
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
        MenuKnoppen.onReisSchermKnopClick(gebruiker, reisSchermKnop);
    }

    @FXML
    public void onBeloningKnopClick() throws Exception { // Opent beloning scherm. Als gebruiker een admin is opent het het admin scherm voor beloningen.
        MenuKnoppen.onBeloningKnopClick(gebruiker, beloningKnop);
    }

    @FXML
    public void onScorebordKnopClick() throws Exception { // Opent scorebord scherm
        MenuKnoppen.onScorebordKnopClick(gebruiker, scorebordKnop);
    }

    @FXML
    public void onLogoutClick() throws Exception { // Logt gebruiker uit.
        MenuKnoppen.onLogoutKnopClick(logoutKnop);
    }
}

class Stats{
    public double uitstoot;
    public double punten;
    public double km;
}