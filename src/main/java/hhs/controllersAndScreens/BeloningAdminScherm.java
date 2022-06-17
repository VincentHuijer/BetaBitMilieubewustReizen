package hhs.controllersAndScreens;

import hhs.proj2_klas6_groep6d.Main;
import hhs.proj2_klas6_groep6d.Persoon;
import hhs.proj2_klas6_groep6d.RewardsList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Objects;

public class BeloningAdminScherm {

    private static final RewardsList rewardsList = BeloningScherm.getRewardsList();
    private static Persoon loggedIn;
    private static Stage stage;
    public void start() throws Exception {
        if(stage == null){
            stage = new Stage();
        }

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("beloningenStore_admin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 530);
        Text welkomText = (Text) scene.lookup("#welkomText");
        welkomText.setText("Welkom " + loggedIn.displayName());


        stage.setTitle("Beloningen - Admin");
        stage.getIcons().add(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("images/logoT.png"))));
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
