package hhs.Schermen;

import hhs.proj2_klas6_groep6d.CO2;
import hhs.proj2_klas6_groep6d.Gebruiker;
import hhs.proj2_klas6_groep6d.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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

        ChoiceBox viewSwitch = (ChoiceBox) scene.lookup("#viewSwitch");

        viewSwitch.setValue("Punten");
        viewSwitch.getItems().add("CO2");
        viewSwitch.getItems().add("Punten");

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
    public void update(Observable o, Object arg) { // Zorgt ervoor dat de gebruiker de juiste hoeveelheid punten en de juiste informatie te zien krijgt als hij/zij een bepaalde hoeveelheid kilometers invult.
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

        ChoiceBox choicebox = (ChoiceBox) scene.lookup("#viewSwitch");

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

            if (choicebox.getValue().toString().equalsIgnoreCase("punten")) {
                autoPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenWoonWerkVerkeer(100, km, "Auto", elektrisch)));
                regionaalPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenWoonWerkVerkeer(100, km, "RegionaalOV", elektrisch)));
                tramPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenWoonWerkVerkeer(100, km, "Tram", elektrisch)));
                fietsPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenWoonWerkVerkeer(100, km, "Fiets", elektrisch)));
            } else {
                double uitstoot = new CO2(km).getUitstoot();
                autoPuntenText.setText(String.format("%.0f gram CO2", uitstoot));
                regionaalPuntenText.setText(String.format("%.0f gram CO2", uitstoot));
                tramPuntenText.setText(String.format("%.0f gram CO2", uitstoot));
                fietsPuntenText.setText(String.format("%.0f gram CO2", uitstoot));
            }

            if (arg.toString().equalsIgnoreCase("auto")) {
                alternatiefWoonWerkVerkeer("regionaalOV", km, elektrisch, arg);
            } else if (arg.toString().equalsIgnoreCase("RegionaalOV")) {
                alternatiefWoonWerkVerkeer("tram", km, elektrisch, arg);

            } else if (arg.toString().equalsIgnoreCase("Tram")) {
                alternatief.setText("");

            }
        } else if (zakelijk.isSelected()) {
            punten = String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer(km, arg.toString(), elektrisch));
            text.setText(punten);

            if (choicebox.getValue().toString().equalsIgnoreCase("punten")) {
                autoPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer(km, "Auto", elektrisch)));
                regionaalPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer(km, "RegionaalOV", elektrisch)));
                tramPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer(km, "Tram", elektrisch)));
                fietsPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer(km, "Fiets", elektrisch)));
            } else {
                double uitstoot = new CO2(km).getUitstoot();
                autoPuntenText.setText(String.format("%.0f gram CO2", uitstoot));
                regionaalPuntenText.setText(String.format("%.0f gram CO2", uitstoot));
                tramPuntenText.setText(String.format("%.0f gram CO2", uitstoot));
                fietsPuntenText.setText(String.format("%.0f gram CO2", uitstoot));
            }
            if (arg.toString().equalsIgnoreCase("auto")) {
                alternatiefZakelijkVerkeer("regionaalOV", km, elektrisch, arg);
            } else if (arg.toString().equalsIgnoreCase("RegionaalOV")) {
                alternatiefZakelijkVerkeer("tram", km, elektrisch, arg);
            } else if (arg.toString().equalsIgnoreCase("Tram")) {
                alternatief.setText("");
            }
        }
    }

    public void alternatiefWoonWerkVerkeer(String vervoersmiddel, double km, boolean elektrisch, Object arg) { //Zet tekst neer om gebruiker op de hoogte te stellen van een betere optie die meer punten oplevert
        Text alternatief = (Text) scene.lookup("#AlternatieveText");
        alternatief.setText("Voor meer punten kunt u met de duurzamere optie gaan want dan krijgt u "
                + (loggedIn.getPunten().berekenAantalPuntenWoonWerkVerkeer(100, km, vervoersmiddel, elektrisch) - loggedIn.getPunten().berekenAantalPuntenWoonWerkVerkeer(100, km, arg.toString(), elektrisch))
                + " punten meer.");
    }

    public void alternatiefZakelijkVerkeer(String vervoersmiddel, double km, boolean elektrisch, Object arg) { //Zet tekst neer om gebruiker op de hoogte te stellen van een betere optie die meer punten oplevert
        Text alternatief = (Text) scene.lookup("#AlternatieveText");
        alternatief.setText("Voor meer punten kunt u met de duurzamere optie gaan want dan krijgt u "
                + (loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer(km, vervoersmiddel, elektrisch) - loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer(km, arg.toString(), elektrisch))
                + " punten meer.");
    }
}

