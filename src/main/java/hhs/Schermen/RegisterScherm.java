package hhs.Schermen;

import hhs.proj2_klas6_groep6d.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegisterScherm extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("register.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 530);
        stage.setTitle("Register");
        stage.setScene(scene);
        stage.show();
    }
}
