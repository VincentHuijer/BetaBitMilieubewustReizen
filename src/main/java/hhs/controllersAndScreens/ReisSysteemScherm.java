package hhs.controllersAndScreens;

import hhs.proj2_klas6_groep6d.Gebruiker;
import hhs.proj2_klas6_groep6d.Main;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
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
        if (stage == null) {
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

    public void setLoggedIn(Gebruiker gebruiker) {
        loggedIn = gebruiker;
    }

    public Gebruiker getLoggedIn() {
        return loggedIn;
    }

    @Override
    public void update(Observable o, Object arg) {
        Text text = (Text) scene.lookup("#berekenPuntenText");
        Text alternatief = (Text) scene.lookup("#AlternatieveText");
        Text autoPuntenText = (Text) scene.lookup("#autoPuntenText");
        Text regionaalPuntenText = (Text) scene.lookup("#regionaalPuntenText");
        Text tramPuntenText = (Text) scene.lookup("#tramPuntenText");
        Text fietsPuntenText = (Text) scene.lookup("#fietsPuntenText");
        TextField textField = (TextField) scene.lookup("#kmTextField");
        CheckBox woonWerk = (CheckBox) scene.lookup("#woonwerkCheck");
        CheckBox zakelijk = (CheckBox) scene.lookup("#zakelijkCheck");
        Text puntensaldo = (Text) scene.lookup("#puntensaldoText");
        puntensaldo.setText(String.format("%.0f PUNTEN", loggedIn.getPunten().getAantalPunten()));
        double km;
        if (textField.getText().equals("")) {
            km = 0;
        } else {
            km = Double.parseDouble(textField.getText());
        }
        boolean elektrisch = false;
        CheckBox elektrischeCheck = (CheckBox) scene.lookup("#elektrischeAutoCheck");
        if (elektrischeCheck.isSelected()) {
            elektrisch = true;
        }
        String punten;
        if (woonWerk.isSelected()) {
            //Hier nog code maken om te bepalen hoe ver van werk de medewerker woont die verst weg woont.
            punten = String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenWoonWerkVerkeer(100, km, arg.toString(), elektrisch));
            text.setText(punten);
            autoPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenWoonWerkVerkeer(100, km, "Auto", elektrisch)));
            regionaalPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenWoonWerkVerkeer(100, km, "RegionaalOV", elektrisch)));
            tramPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenWoonWerkVerkeer(100, km, "Tram", elektrisch)));
            fietsPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenWoonWerkVerkeer(100, km, "Fiets", elektrisch)));

            alternatief.setText("Voor meer punten kunt u met de duurzamere optie gaan want dan krijgt u "
                    + (loggedIn.getPunten().berekenAantalPuntenWoonWerkVerkeer(100, km, arg.toString(), elektrisch) - loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer(km, arg.toString(), elektrisch))
                    + " punten meer.");

        } else if (zakelijk.isSelected()) {
            punten = String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer(km, arg.toString(), elektrisch));
            text.setText(punten);
            autoPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer(km, "Auto", elektrisch)));
            regionaalPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer(km, "RegionaalOV", elektrisch)));
            tramPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer(km, "Tram", elektrisch)));
            fietsPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer(km, "Fiets", elektrisch)));

            alternatief.setText("Voor meer punten kunt u met de duurzamere optie gaan want dan krijgt u\n "
                    + (loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer( km, arg.toString(), elektrisch) - loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer(km, arg.toString(), elektrisch))
                    + " punten meer.");

        }
    }
}

