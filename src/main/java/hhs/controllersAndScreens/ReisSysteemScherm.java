package hhs.controllersAndScreens;

import hhs.proj2_klas6_groep6d.Gebruiker;
import hhs.proj2_klas6_groep6d.Main;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class ReisSysteemScherm implements Observer {
    private static Gebruiker loggedIn;
    private static Scene scene;
    private static Stage stage;

    public void start() throws Exception {
        if(stage == null){
            stage = new Stage();
        }

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("reisSysteem.fxml"));
        scene = new Scene(fxmlLoader.load(), 700, 530);
        Text welkomText = (Text) scene.lookup("#welkomText");
        welkomText.setText("Welkom " + loggedIn.getUsername());
        Text punten = (Text) scene.lookup("#puntensaldoText");
        punten.setText(String.format("%.0f PUNTEN", loggedIn.getPunten().getAantalPunten()));
        stage.setTitle("ReisSysteem");
        stage.setScene(scene);
        stage.show();
    }
    public void setLoggedIn(Gebruiker gebruiker){
        loggedIn = gebruiker;
    }

    @Override
    public void update(Observable o, Object arg) {
        Text text = (Text) scene.lookup("#berekenPuntenText");
        Text autoPuntenText = (Text) scene.lookup("#autoPuntenText");
        Text regionaalPuntenText = (Text) scene.lookup("#regionaalPuntenText");
        Text tramPuntenText = (Text) scene.lookup("#tramPuntenText");
        Text fietsPuntenText = (Text) scene.lookup("#fietsPuntenText");
        TextField textField = (TextField) scene.lookup("#kmTextField");
        double km;
        if(textField.getText().equals("")){
            km = 0;
        }else{
            km = Double.parseDouble(textField.getText());
        }
        String punten = String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer(km, arg.toString()));
        text.setText(punten);
        autoPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer(km, "Auto")));
        regionaalPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer(km, "RegionaalOV")));
        tramPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer(km, "Tram")));
        fietsPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer(km, "Fiets")));
    }
}
