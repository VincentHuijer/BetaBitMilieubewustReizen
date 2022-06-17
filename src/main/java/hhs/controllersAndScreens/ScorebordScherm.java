package hhs.controllersAndScreens;

import hhs.proj2_klas6_groep6d.Main;
import hhs.proj2_klas6_groep6d.Persoon;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Date;
import java.util.Objects;

public class ScorebordScherm {
    private static Persoon loggedIn;
    private static Scene scene;
    private static Stage stage;

    public void start() throws Exception {
        if (stage == null) {
            stage = new Stage();
        }

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("scorebord.fxml"));
        scene = new Scene(fxmlLoader.load(), 700, 530);
        Text welkomText = (Text) scene.lookup("#welkomText");
        welkomText.setText("Welkom " + loggedIn.displayName());
        Text punten = (Text) scene.lookup("#puntensaldoText");
        punten.setText(String.format("%.0f PUNTEN", loggedIn.getPunten().getAantalPunten()));

        String[] maanden = {"Januari", "Februari", "Maart", "April", "Mei", "Juni", "Juli", "Augustus", "September", "Oktober", "November", "December"};
        Text scorebordTitel = (Text) scene.lookup("#scorebordTitel");
        scorebordTitel.setText("OVERZICHT - " + maanden[new Date().getMonth()].toUpperCase());

        stage.setTitle("Scorebord");
        stage.getIcons().add(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("images/logoT.png"))));
        stage.setScene(scene);
        stage.show();
    }

    public static void setLoggedIn(Persoon loggedIn) {
        ScorebordScherm.loggedIn = loggedIn;
    }

    public static Persoon getLoggedIn() {
        return loggedIn;
    }
}
