package hhs.Schermen;

import hhs.proj2_klas6_groep6d.Gebruiker;
import hhs.proj2_klas6_groep6d.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScorebordScherm {
    private static Gebruiker loggedIn;
    private static Scene scene;
    private static Stage stage;

    public void start() throws Exception {
        if (stage == null) {
            stage = new Stage();
        }

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("scorebord.fxml"));
        scene = new Scene(fxmlLoader.load(), 700, 530);
        String css = this.getClass().getResource("hhs/proj2_klas6_groep6d/css/scorebord.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("Scorebord");
        stage.setScene(scene);
        stage.show();
    }

    public static void setLoggedIn(Gebruiker loggedIn) {
        ScorebordScherm.loggedIn = loggedIn;
    }

    public static Gebruiker getLoggedIn() {
        return loggedIn;
    }
}
