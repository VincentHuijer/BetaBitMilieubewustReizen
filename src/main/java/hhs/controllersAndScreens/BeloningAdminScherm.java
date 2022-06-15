package hhs.controllersAndScreens;

import hhs.proj2_klas6_groep6d.Main;
import hhs.proj2_klas6_groep6d.Persoon;
import hhs.proj2_klas6_groep6d.RewardsList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BeloningAdminScherm {

    private static RewardsList rewardsList = BeloningScherm.getRewardsList();
    private static Persoon loggedIn;
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


        stage.setTitle("Beloningen - Admin");
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("images/logoT.png")));
        stage.setScene(scene);
        stage.show();
    }

    public static void setLoggedIn(Persoon loggedIn) {
        BeloningAdminScherm.loggedIn = loggedIn;
    }

    public static Persoon getLoggedIn() {
        return loggedIn;
    }

    public static RewardsList getRewardsList() {
        return rewardsList;
    }
}
