package hhs.controllersAndScreens;

import hhs.proj2_klas6_groep6d.Gebruiker;
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

    public void onReisschermKnop() throws Exception {
        Stage stage = (Stage) reisschermKnop.getScene().getWindow();
        Gebruiker gebruiker = beloningAdminScherm.getLoggedIn();
        stage.close();
        ReisSysteemScherm reisSysteemScherm = new ReisSysteemScherm();
        reisSysteemScherm.setLoggedIn(gebruiker);
        reisSysteemScherm.start();
    }

    public void onLogoutClick() throws Exception {
        Stage stage = (Stage) logoutKnop.getScene().getWindow();
        LoginScherm loginScherm = new LoginScherm();
        loginScherm.start(new Stage());
        stage.close();
    }

    public void onConfirm(ActionEvent event){
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

    public void setDisabled(){
        int size = alleRewards.size();
        if(size == 0){
            confirm2.setDisable(true);
            confirm3.setDisable(true);
            confirm4.setDisable(true);
            confirm5.setDisable(true);
            confirm6.setDisable(true);
        }else if(size ==1){
            confirm2.setDisable(false);
            confirm3.setDisable(true);
            confirm4.setDisable(true);
            confirm5.setDisable(true);
            confirm6.setDisable(true);
        }else if(size ==2){
            confirm2.setDisable(false);
            confirm3.setDisable(false);
            confirm4.setDisable(true);
            confirm5.setDisable(true);
            confirm6.setDisable(true);
        }else if(size ==3){
            confirm2.setDisable(false);
            confirm3.setDisable(false);
            confirm4.setDisable(false);
            confirm5.setDisable(true);
            confirm6.setDisable(true);
        }else if(size ==4){
            confirm2.setDisable(false);
            confirm3.setDisable(false);
            confirm4.setDisable(false);
            confirm5.setDisable(false);
            confirm6.setDisable(true);
        }else{
            confirm2.setDisable(false);
            confirm3.setDisable(false);
            confirm4.setDisable(false);
            confirm5.setDisable(false);
            confirm6.setDisable(false);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
        setDisabled();
    }
}
