package hhs.controllersAndScreens;

import hhs.proj2_klas6_groep6d.Gebruiker;
import hhs.proj2_klas6_groep6d.Main;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ReisSysteemScherm extends Application {
    private static Gebruiker loggedIn;

    ReisSysteemScherm(Gebruiker loggedIn){
        this.loggedIn = loggedIn;
    }
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("reisSysteem.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 530);

        stage.setTitle("ReisSysteem");
        stage.setScene(scene);
        stage.show();
    }
}
