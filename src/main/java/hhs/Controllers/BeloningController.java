package hhs.Controllers;

import hhs.Schermen.*;
import hhs.proj2_klas6_groep6d.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;

public class BeloningController extends Observable implements Initializable {
    BeloningScherm beloningScherm = new BeloningScherm();
    RewardsList rewardsList = beloningScherm.getRewardsList();
    Persoon gebruiker = beloningScherm.getLoggedIn();
    ArrayList<Rewards> alleRewards = beloningScherm.getRewardsList().getRewardsLijst();
    @FXML
    Button reisschermKnop;
    @FXML
    Button logoutKnop;
    @FXML
    Text naam1;
    @FXML
    Text naam2;
    @FXML
    Text naam3;
    @FXML
    Text naam4;
    @FXML
    Text naam5;
    @FXML
    Text naam6;

    @FXML
    Text[] namen;

    @FXML
    Text punt1;
    @FXML
    Text punt2;
    @FXML
    Text punt3;
    @FXML
    Text punt4;
    @FXML
    Text punt5;
    @FXML
    Text punt6;

    @FXML
    Text[] punten;

    @FXML
    Button beloning1Knop;
    @FXML
    Button beloning2Knop;
    @FXML
    Button beloning3Knop;
    @FXML
    Button beloning4Knop;
    @FXML
    Button beloning5Knop;
    @FXML
    Button beloning6Knop;
    @FXML
    Button scorebordKnop;
    @FXML
    Button overzichtKnop;

    @FXML
    Button[] knoppen;

    @FXML
    public void onOverzichtKnopClick() throws Exception { // Opent overzicht scherm
        MenuKnoppen.onOverzichtKnopClick(gebruiker, overzichtKnop);
    }

    @FXML
    public void onScorebordKnopClick() throws Exception { // Opent scorebord scherm
        MenuKnoppen.onScorebordKnopClick(gebruiker, scorebordKnop);
    }

    @FXML
    public void onBeloningKnopClick(ActionEvent event) { // Geeft gekozen reward door aan claimreward methode.
        Node node = (Node) event.getSource();
        String data = (String) node.getUserData();
        int rewardNummer = Integer.parseInt(data);
        claimReward(rewardNummer); //Nummer is gelijk aan knopnummer. Links boven is 1, rechts boven 2 etc.
    }

    @FXML
    private void claimReward(int nummer) { //Controleert of gebruiker genoeg punten heeft. Zo ja, dan koopt de gebruiker deze reward.
        double prijsInPunten = rewardsList.getRewardsLijst().get(nummer - 1).getPunten();
        if (claimRewardCheck(nummer)) {
            nummer = nummer - 1;

            Button knop = knoppen[nummer];
            knop.setText("GEKOCHT");
            knop.setDisable(true);

            gebruiker.getPunten().removePunten(prijsInPunten);
            setChanged();
            notifyObservers();
        } else {
            return;
        }
    }

    public boolean claimRewardCheck(int nummer) {
        double prijsInPunten = rewardsList.getRewardsLijst().get(nummer - 1).getPunten();
        if (gebruiker.getPunten().getAantalPunten() >= prijsInPunten) {
            return true;
        } else {
            return false;
        }
    }

    @FXML
    public void onReisSchermKnop() throws Exception { // Opent reis scherm.
        MenuKnoppen.onReisSchermKnopClick(gebruiker, reisschermKnop);
    }

    @FXML
    public void onLogoutClick() throws Exception { // Logt gebruiker uit.
        MenuKnoppen.onLogoutKnopClick(logoutKnop);
    }

    private void refresh() { // Herlaad alle rewards en vult de velden die erbij horen in.
        int size = alleRewards.size();

        for (int i = 0; i < 6; i++) {
            if(size > i){
                namen[i].setText(alleRewards.get(i).getNaam());
                punten[i].setText(String.format("%.0f Punten", alleRewards.get(i).getPunten()));
                knoppen[i].setDisable(false);
            }

            if(size < (i + 1)){
                namen[i].setText("N/A");
                punten[i].setText("N/A");
                knoppen[i].setDisable(true);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { // Toevoegen observer aan beloningscherm om aantal punten gebruiker live te updaten.
        addObserver(beloningScherm);

        namen = new Text[]{naam1, naam2, naam3, naam4, naam5, naam6};
        punten = new Text[]{punt1, punt2, punt3, punt4, punt5, punt6};
        knoppen = new Button[]{beloning1Knop, beloning2Knop, beloning3Knop, beloning4Knop, beloning5Knop, beloning6Knop};

        refresh();
    }
}
