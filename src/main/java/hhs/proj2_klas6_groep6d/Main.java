package hhs.proj2_klas6_groep6d;

import hhs.controllersAndScreens.LoginScherm;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application{

    public static void main(String[] args) throws Exception {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        LoginScherm loginScherm = new LoginScherm();
        loginScherm.start(new Stage());
    }
}