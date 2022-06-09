package hhs.Controllers;

import hhs.Schermen.*;
import hhs.proj2_klas6_groep6d.Gebruiker;
import hhs.proj2_klas6_groep6d.MenuKnoppen;
import hhs.proj2_klas6_groep6d.Persoon;
import hhs.proj2_klas6_groep6d.Rewards;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BeloningAdminController implements Initializable {
    BeloningAdminScherm beloningAdminScherm = new BeloningAdminScherm();
    ArrayList<Rewards> alleRewards = beloningAdminScherm.getRewardsList().getRewardsLijst();
    Persoon gebruiker = beloningAdminScherm.getLoggedIn();
    @FXML
    TextField beloning1TF;
    @FXML
    TextField beloning2TF;
    @FXML
    TextField beloning3TF;
    @FXML
    TextField beloning4TF;
    @FXML
    TextField beloning5TF;
    @FXML
    TextField beloning6TF;
    @FXML
    TextField beloning1TFP;
    @FXML
    TextField beloning2TFP;
    @FXML
    TextField beloning3TFP;
    @FXML
    TextField beloning4TFP;
    @FXML
    TextField beloning5TFP;
    @FXML
    TextField beloning6TFP;
    @FXML
    Button confirm1;
    @FXML
    Button confirm2;
    @FXML
    Button confirm3;
    @FXML
    Button confirm4;
    @FXML
    Button confirm5;
    @FXML
    Button confirm6;
    @FXML
    Button logoutKnop;
    @FXML
    Button reisschermKnop;
    @FXML
    Button delete1;
    @FXML
    Button delete2;
    @FXML
    Button delete3;
    @FXML
    Button delete4;
    @FXML
    Button delete5;
    @FXML
    Button delete6;
    @FXML
    Button scorebordKnop;
    @FXML
    Button overzichtKnop;

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

    public void onDelete(ActionEvent event){ //Verwijdert reward waarbij op "verwijderen" is geklikt en schuift alle rewards op zodat alles netjes achter elkaar is gevuld.
        Node node = (Node) event.getSource();
        String data = (String) node.getUserData();
        int rewardNummer = Integer.parseInt(data);
        if(rewardNummer == 1){
            alleRewards.remove(0);
            refresh();
        }else if(rewardNummer == 2){
            alleRewards.remove(1);
            refresh();
        }else if(rewardNummer == 3){
            alleRewards.remove(2);
            refresh();
        }else if(rewardNummer == 4){
            alleRewards.remove(3);
            refresh();
        }else if(rewardNummer == 5){
            alleRewards.remove(4);
            refresh();
        }else if(rewardNummer == 6){
            alleRewards.remove(5);
            refresh();
        }
    }

    public void onConfirm(ActionEvent event){ //Voegt ingevulde reward toe aan arraylist met rewards.
        Node node = (Node) event.getSource() ;
        String data = (String) node.getUserData();
        int rewardNummer = Integer.parseInt(data);
        if(rewardNummer == 1 && alleRewards.size()>=1){
            Rewards reward1 = new Rewards(beloning1TF.getText(), "", 1, Double.parseDouble(beloning1TFP.getText()));
            alleRewards.set(rewardNummer-1, reward1);
        }else if(rewardNummer == 2 && alleRewards.size()>=2){
            Rewards reward2 = new Rewards(beloning2TF.getText(), "", 1, Double.parseDouble(beloning2TFP.getText()));
            alleRewards.set(rewardNummer-1, reward2);
        }else if(rewardNummer == 3 && alleRewards.size()>=3){
            Rewards reward3 = new Rewards(beloning3TF.getText(), "", 1, Double.parseDouble(beloning3TFP.getText()));
            alleRewards.set(rewardNummer-1, reward3);
        }else if(rewardNummer == 4 && alleRewards.size()>=4){
            Rewards reward4 = new Rewards(beloning4TF.getText(), "", 1, Double.parseDouble(beloning4TFP.getText()));
            alleRewards.set(rewardNummer-1, reward4);
        }else if(rewardNummer == 5 && alleRewards.size()>=5){
            Rewards reward5 = new Rewards(beloning5TF.getText(), "", 1, Double.parseDouble(beloning5TFP.getText()));
            alleRewards.set(rewardNummer-1, reward5);
        }else if (rewardNummer == 6 && alleRewards.size()>=6){
            Rewards reward6 = new Rewards(beloning6TF.getText(), "", 1, Double.parseDouble(beloning6TFP.getText()));
            alleRewards.set(rewardNummer-1, reward6);
        }else if(rewardNummer == 1 && alleRewards.size()<1){
            Rewards reward1 = new Rewards(beloning1TF.getText(), "", 1, Double.parseDouble(beloning1TFP.getText()));
            alleRewards.add(rewardNummer-1, reward1);
        }else if(rewardNummer == 2 && alleRewards.size()<2){
            Rewards reward2 = new Rewards(beloning2TF.getText(), "", 1, Double.parseDouble(beloning2TFP.getText()));
            alleRewards.add(rewardNummer-1, reward2);
        }else if(rewardNummer == 3 && alleRewards.size()<3){
            Rewards reward3 = new Rewards(beloning3TF.getText(), "", 1, Double.parseDouble(beloning3TFP.getText()));
            alleRewards.add(rewardNummer-1, reward3);
        }else if(rewardNummer == 4 && alleRewards.size()<4){
            Rewards reward4 = new Rewards(beloning4TF.getText(), "", 1, Double.parseDouble(beloning4TFP.getText()));
            alleRewards.add(rewardNummer-1, reward4);
        }else if(rewardNummer == 5 && alleRewards.size()<5){
            Rewards reward5 = new Rewards(beloning5TF.getText(), "", 1, Double.parseDouble(beloning5TFP.getText()));
            alleRewards.add(rewardNummer-1, reward5);
        }else if (rewardNummer == 6 && alleRewards.size()<6){
            Rewards reward6 = new Rewards(beloning6TF.getText(), "", 1, Double.parseDouble(beloning6TFP.getText()));
            alleRewards.add(rewardNummer-1, reward6);
        }
        setDisabled();
    }

    public void setDisabled(){ // Zet knoppen die op dat moment niet te gebruiken zijn uit. Je kan dan niet op ze klikken. Dit voorkomt errors.
        int size = alleRewards.size();
        if(size == 0){
            delete2.setDisable(true);
            delete3.setDisable(true);
            delete4.setDisable(true);
            delete5.setDisable(true);
            delete6.setDisable(true);
            confirm2.setDisable(true);
            confirm3.setDisable(true);
            confirm4.setDisable(true);
            confirm5.setDisable(true);
            confirm6.setDisable(true);
        }else if(size ==1){
            delete2.setDisable(true);
            delete3.setDisable(true);
            delete4.setDisable(true);
            delete5.setDisable(true);
            delete6.setDisable(true);
            confirm2.setDisable(false);
            confirm3.setDisable(true);
            confirm4.setDisable(true);
            confirm5.setDisable(true);
            confirm6.setDisable(true);
        }else if(size ==2){
            delete2.setDisable(false);
            delete3.setDisable(true);
            delete4.setDisable(true);
            delete5.setDisable(true);
            delete6.setDisable(true);
            confirm2.setDisable(false);
            confirm3.setDisable(false);
            confirm4.setDisable(true);
            confirm5.setDisable(true);
            confirm6.setDisable(true);
        }else if(size ==3){
            delete2.setDisable(false);
            delete3.setDisable(false);
            delete4.setDisable(true);
            delete5.setDisable(true);
            delete6.setDisable(true);
            confirm2.setDisable(false);
            confirm3.setDisable(false);
            confirm4.setDisable(false);
            confirm5.setDisable(true);
            confirm6.setDisable(true);
        }else if(size ==4){
            delete2.setDisable(false);
            delete3.setDisable(false);
            delete4.setDisable(false);
            delete5.setDisable(true);
            delete6.setDisable(true);
            confirm2.setDisable(false);
            confirm3.setDisable(false);
            confirm4.setDisable(false);
            confirm5.setDisable(false);
            confirm6.setDisable(true);
        }else if(size ==5){
            delete2.setDisable(false);
            delete3.setDisable(false);
            delete4.setDisable(false);
            delete5.setDisable(false);
            delete6.setDisable(true);
            confirm2.setDisable(false);
            confirm3.setDisable(false);
            confirm4.setDisable(false);
            confirm5.setDisable(false);
            confirm6.setDisable(false);
        }else{
            delete2.setDisable(false);
            delete3.setDisable(false);
            delete4.setDisable(false);
            delete5.setDisable(false);
            delete6.setDisable(false);
            confirm2.setDisable(false);
            confirm3.setDisable(false);
            confirm4.setDisable(false);
            confirm5.setDisable(false);
            confirm6.setDisable(false);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        generate();
        setDisabled();
    }
    public void refresh(){
        clear();
        generate();
        setDisabled();
    }
    public void clear(){//Maakt alle velden in admin scherm leeg.
        beloning1TF.setText("");
        beloning1TFP.setText("");
        beloning2TF.setText("");
        beloning2TFP.setText("");
        beloning3TF.setText("");
        beloning3TFP.setText("");
        beloning4TF.setText("");
        beloning4TFP.setText("");
        beloning5TF.setText("");
        beloning5TFP.setText("");
        beloning6TF.setText("");
        beloning6TFP.setText("");
    }
    public void generate(){// Genereert alle rewards die in de arraylist zitten en laat ze zien in het admin scherm.
        int size = alleRewards.size();
        if(size >= 6){
            System.out.println("Er zitten meer dan 6 rewards in de reward lijst. @BeloningAdminController");
        }
        for(int i = 0; i<size; i++){
            if (i==0){
                beloning1TF.setText(alleRewards.get(i).getNaam());
                beloning1TFP.setText(String.format("%.0f", alleRewards.get(i).getPunten()));
            }
            else if(i==1){
                beloning2TF.setText(alleRewards.get(i).getNaam());
                beloning2TFP.setText(String.format("%.0f", alleRewards.get(i).getPunten()));
            }
            else if(i==2){
                beloning3TF.setText(alleRewards.get(i).getNaam());
                beloning3TFP.setText(String.format("%.0f", alleRewards.get(i).getPunten()));

            }
            else if(i==3){
                beloning4TF.setText(alleRewards.get(i).getNaam());
                beloning4TFP.setText(String.format("%.0f", alleRewards.get(i).getPunten()));

            }
            else if(i==4){
                beloning5TF.setText(alleRewards.get(i).getNaam());
                beloning5TFP.setText(String.format("%.0f", alleRewards.get(i).getPunten()));

            }
            else if(i==5){
                beloning6TF.setText(alleRewards.get(i).getNaam());
                beloning6TFP.setText(String.format("%.0f", alleRewards.get(i).getPunten()));

            }

        }
    }
}
