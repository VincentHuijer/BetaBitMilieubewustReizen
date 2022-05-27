package hhs.controllersAndScreens;

import hhs.proj2_klas6_groep6d.Gebruiker;
import hhs.proj2_klas6_groep6d.Rewards;
import hhs.proj2_klas6_groep6d.RewardsList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;

public class BeloningController extends Observable implements Initializable {
    BeloningScherm beloningScherm = new BeloningScherm();
    RewardsList rewardsList = beloningScherm.getRewardsList();
    Gebruiker gebruiker = beloningScherm.getLoggedIn();
    ArrayList<Rewards> alleRewards = beloningScherm.getRewardsList().getRewardsLijst();
    @FXML
    Button reisschermKnop;
    @FXML
    Button logoutKnop;
    @FXML
    Button beloning1Knop;
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
    public void onBeloningKnopClick(ActionEvent event){
        Node node = (Node) event.getSource();
        String data = (String) node.getUserData();
        int rewardNummer = Integer.parseInt(data);
        claimReward(rewardNummer); //Nummer is gelijk aan knopnummer. Links boven is 1, rechts boven 2 etc.
    }

    private void claimReward(int nummer){
        double prijsInPunten = rewardsList.getRewardsLijst().get(nummer-1).getPunten();
        if(gebruiker.getPunten().getAantalPunten() >= prijsInPunten){
            gebruiker.getPunten().removePunten(prijsInPunten);
            setChanged();
            notifyObservers();
        }
        else{
            return;
        }
    }

    @FXML
    public void onReisSchermKnop() throws Exception {
        Stage stage = (Stage) reisschermKnop.getScene().getWindow();
        Gebruiker gebruiker = beloningScherm.getLoggedIn();
        stage.close();
        ReisSysteemScherm reisSysteemScherm = new ReisSysteemScherm();
        reisSysteemScherm.setLoggedIn(gebruiker);
        reisSysteemScherm.start();
    }

    @FXML
    public void onLogoutClick() throws Exception {
        Stage stage = (Stage) logoutKnop.getScene().getWindow();
        LoginScherm loginScherm = new LoginScherm();
        loginScherm.start(new Stage());
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addObserver(beloningScherm);
        int size = alleRewards.size();
        for(int i =0; i<6; i++){
            if(i==0 && size>0){
                naam1.setText(alleRewards.get(i).getNaam());
                punt1.setText(String.format("%.0f Punten", alleRewards.get(i).getPunten()));
                beloning1Knop.setDisable(false);
            }else if(i==1 && size>1){
                naam2.setText(alleRewards.get(i).getNaam());
                punt2.setText(String.format("%.0f Punten", alleRewards.get(i).getPunten()));
                beloning2Knop.setDisable(false);
            }else if(i==2 && size>2){
                naam3.setText(alleRewards.get(i).getNaam());
                punt3.setText(String.format("%.0f Punten", alleRewards.get(i).getPunten()));
                beloning3Knop.setDisable(false);
            }else if(i==3 && size>3){
                naam4.setText(alleRewards.get(i).getNaam());
                punt4.setText(String.format("%.0f Punten", alleRewards.get(i).getPunten()));
                beloning4Knop.setDisable(false);
            }else if(i==4 && size>4){
                naam5.setText(alleRewards.get(i).getNaam());
                punt5.setText(String.format("%.0f Punten", alleRewards.get(i).getPunten()));
                beloning5Knop.setDisable(false);
            }else if(i==5 && size>5){
                naam6.setText(alleRewards.get(i).getNaam());
                punt6.setText(String.format("%.0f Punten", alleRewards.get(i).getPunten()));
                beloning6Knop.setDisable(false);
            }else if(i==0 && size<1){
                naam1.setText("N/A");
                punt1.setText("N/A");
                beloning1Knop.setDisable(true);
            }else if(i==1 && size<2){
                naam2.setText("N/A");
                punt2.setText("N/A");
                beloning2Knop.setDisable(true);
            }else if(i==2 && size<3){
                naam3.setText("N/A");
                punt3.setText("N/A");
                beloning3Knop.setDisable(true);
            }else if(i==3 && size<4){
                naam4.setText("N/A");
                punt4.setText("N/A");
                beloning4Knop.setDisable(true);
            }else if(i==4 && size<5){
                naam5.setText("N/A");
                punt5.setText("N/A");
                beloning5Knop.setDisable(true);
            }else if(i==5 && size<6){
                naam6.setText("N/A");
                punt6.setText("N/A");
                beloning6Knop.setDisable(true);
            }
        }
    }
}
