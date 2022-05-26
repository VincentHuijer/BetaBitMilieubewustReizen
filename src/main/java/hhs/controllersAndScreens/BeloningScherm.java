package hhs.controllersAndScreens;

import hhs.proj2_klas6_groep6d.Gebruiker;
import hhs.proj2_klas6_groep6d.Main;
import hhs.proj2_klas6_groep6d.Rewards;
import hhs.proj2_klas6_groep6d.RewardsList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class BeloningScherm implements Observer {
    private static RewardsList rewardsList = new RewardsList();
    private static Gebruiker loggedIn;
    private static Scene scene;
    private static Stage stage;
    public void start() throws Exception {
        if(rewardsList.getRewardsLijst().size() == 0){
            ArrayList<Rewards> toAdd = new ArrayList<>();
            toAdd.add(new Rewards("Appel", "Is een appel", 1, 100));
            toAdd.add(new Rewards("Peer", "Is een peer", 2, 125));
            rewardsList.addRewards(toAdd);
        }
        if(stage == null){
            stage = new Stage();
        }

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("beloningenStore.fxml"));
        scene = new Scene(fxmlLoader.load(), 700, 530);
        Text welkomText = (Text) scene.lookup("#welkomText");
        welkomText.setText("Welkom " + loggedIn.getUsername());
        Text punten = (Text) scene.lookup("#puntensaldoText");
        punten.setText(String.format("%.0f PUNTEN", loggedIn.getPunten().getAantalPunten()));
        stage.setTitle("Beloningen");
        stage.setScene(scene);
        stage.show();
    }
    public void setLoggedIn(Gebruiker gebruiker){
        loggedIn = gebruiker;
    }

    public static Gebruiker getLoggedIn() {
        return loggedIn;
    }

    public static RewardsList getRewardsList() {
        return rewardsList;
    }

    @Override
    public void update(Observable o, Object arg) {
        Text puntensaldo = (Text) scene.lookup("#puntensaldoText");
        puntensaldo.setText(String.format("%.0f PUNTEN", loggedIn.getPunten().getAantalPunten()));
    }
}
