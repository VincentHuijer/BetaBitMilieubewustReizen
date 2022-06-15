package hhs.proj2_klas6_groep6d;

import hhs.controllersAndScreens.LoginScherm;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {//Applicatie kan gestart worden vanaf LoginScherm class

    @Override
    public void start(Stage stage) throws Exception {
        LoginScherm loginScherm = new LoginScherm();
        loginScherm.start(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}