package hhs.controllersAndScreens;

import hhs.proj2_klas6_groep6d.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class RegisterScherm {

    protected static Scene scene;
    protected static Stage stage;

    public void start() throws Exception {
        if (stage == null) {
            stage = new Stage();
        }
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("register.fxml"));
        scene = new Scene(fxmlLoader.load(), 700, 530);

        stage.setTitle("Register");
        stage.getIcons().add(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("images/logoT.png"))));
        stage.setScene(scene);
        stage.show();
    }
}
