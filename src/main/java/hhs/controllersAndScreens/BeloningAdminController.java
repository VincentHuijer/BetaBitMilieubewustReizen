package hhs.controllersAndScreens;

import hhs.proj2_klas6_groep6d.MenuKnoppen;
import hhs.proj2_klas6_groep6d.Persoon;
import hhs.proj2_klas6_groep6d.Rewards;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BeloningAdminController implements Initializable {
    ArrayList<Rewards> alleRewards = BeloningAdminScherm.getRewardsList().getRewardsLijst();
    Persoon gebruiker = BeloningAdminScherm.getLoggedIn();

    @FXML
    TextField beloning1TF,beloning2TF, beloning3TF,beloning4TF,beloning5TF,beloning6TF;
    TextField[] beloningTextFields;

    @FXML
    TextField beloning1TFP,beloning2TFP,beloning3TFP, beloning4TFP,beloning5TFP, beloning6TFP;
    TextField[] beloningPuntenTextFields;

    @FXML
    Button confirm1,confirm2,confirm3,confirm4,confirm5,confirm6;
    Button[] confirmButtons;

    @FXML
    Button delete1,delete2,delete3,delete4,delete5,delete6;
    Button[] deleteButtons;

    @FXML
    Button scorebordKnop,overzichtKnop,logoutKnop,reisschermKnop;

    @FXML
    public void onOverzichtKnopClick() throws Exception { // Opent overzicht scherm
        MenuKnoppen.onOverzichtKnopClick(gebruiker, overzichtKnop);
    }

    public void onScorebordKnopClick() throws Exception { // Opent scorebord scherm
        MenuKnoppen.onScorebordKnopClick(gebruiker, scorebordKnop);
    }

    public void onReisschermKnop() throws Exception { // Opent reis scherm
        MenuKnoppen.onReisSchermKnopClick(gebruiker, reisschermKnop);
    }

    public void onLogoutClick() throws Exception { // Logt gebruiker uit
        MenuKnoppen.onLogoutKnopClick(logoutKnop);
    }

    public void onDelete(ActionEvent event) { //Verwijdert reward waarbij op "verwijderen" is geklikt en schuift alle rewards op zodat alles netjes achter elkaar is gevuld.
        Node node = (Node) event.getSource();
        String data = (String) node.getUserData();
        int rewardNummer = Integer.parseInt(data);

        alleRewards.remove(rewardNummer - 1);
        refresh();
    }

    public void onConfirm(ActionEvent event) { //Voegt ingevulde reward toe aan arraylist met rewards.
        Node node = (Node) event.getSource();
        String data = (String) node.getUserData();
        int rewardNummer = Integer.parseInt(data);

        rewardNummer -= 1;

        if (alleRewards.size() >= (rewardNummer + 1)) {
            Rewards reward = new Rewards(beloningTextFields[rewardNummer].getText(), "", 1, Double.parseDouble(beloningPuntenTextFields[rewardNummer].getText()));
            alleRewards.set(rewardNummer, reward);
        }

        if (alleRewards.size() < (rewardNummer + 1)){
            Rewards reward = new Rewards(beloningTextFields[rewardNummer].getText(), "", 1, Double.parseDouble(beloningPuntenTextFields[rewardNummer].getText()));
            alleRewards.add(rewardNummer, reward);
        }

        setDisabled();
    }

    public void setDisabled() { // Zet knoppen die op dat moment niet te gebruiken zijn uit. Je kan dan niet op ze klikken. Dit voorkomt errors.
        int size = alleRewards.size();

        for(int i = 0 ; i < 6; i++){
            deleteButtons[i].setDisable(true);
            confirmButtons[i].setDisable(true);
        }

        confirmButtons[0].setDisable(false);

        for(int i = 0 ; i < size; i++){
            deleteButtons[i].setDisable(false);
            confirmButtons[i].setDisable(false);

            if(i != 5){
               confirmButtons[i + 1].setDisable(false);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        deleteButtons = new Button[]{delete1, delete2, delete3, delete4, delete5, delete6};
        beloningTextFields = new TextField[]{beloning1TF, beloning2TF, beloning3TF, beloning4TF, beloning5TF, beloning6TF};
        beloningPuntenTextFields = new TextField[]{beloning1TFP, beloning2TFP, beloning3TFP, beloning4TFP, beloning5TFP, beloning6TFP};
        confirmButtons = new Button[]{confirm1, confirm2, confirm3, confirm4, confirm5, confirm6};

        generate();
        setDisabled();
    }

    public void refresh() {
        clear();
        generate();
        setDisabled();
    }

    public void clear() {//Maakt alle velden in admin scherm leeg.

        for(int i = 0; i < beloningTextFields.length; i++){
            beloningTextFields[i].setText("");
            beloningPuntenTextFields[i].setText("");
        }
    }

    public void generate() {// Genereert alle rewards die in de arraylist zitten en laat ze zien in het admin scherm.
        int size = alleRewards.size();
        if (size >= 6) {
            System.out.println("Er zitten meer dan 6 rewards in de reward lijst. @BeloningAdminController");
        }

        for (int i = 0; i < size; i++) {
            beloningTextFields[i].setText(alleRewards.get(i).getNaam());
            beloningPuntenTextFields[i].setText(String.format("%.0f", alleRewards.get(i).getPunten()));
        }
    }
}
