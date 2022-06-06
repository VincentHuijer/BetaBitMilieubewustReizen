package hhs.Schermen;

import hhs.proj2_klas6_groep6d.Gebruiker;
import hhs.proj2_klas6_groep6d.Main;
import hhs.proj2_klas6_groep6d.RewardsList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BeloningAdminScherm {

    private static RewardsList rewardsList = BeloningScherm.getRewardsList();
    private static Gebruiker loggedIn;
    private static Scene scene;
    private static Stage stage;
    public void start() throws Exception {
        if(stage == null){
            stage = new Stage();
        }

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("beloningenStore_admin.fxml"));
        scene = new Scene(fxmlLoader.load(), 700, 530);
        Text welkomText = (Text) scene.lookup("#welkomText");
        welkomText.setText("Welkom " + loggedIn.getUsername());
        stage.setTitle("BeloningenAdmin");
        stage.setScene(scene);
        stage.show();
    }

    public static void setLoggedIn(Gebruiker loggedIn) {
        BeloningAdminScherm.loggedIn = loggedIn;
    }

    public static Gebruiker getLoggedIn() {
        return loggedIn;
    }

    public static RewardsList getRewardsList() {
        return rewardsList;
    }
}
