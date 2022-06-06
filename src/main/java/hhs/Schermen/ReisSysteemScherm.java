package hhs.Schermen;

import hhs.proj2_klas6_groep6d.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class ReisSysteemScherm implements Observer {
    protected static Gebruiker loggedIn;
    protected static Scene scene;
    protected static Stage stage;

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

//        DatePicker datePicker = (DatePicker) scene.lookup("#datePicker");
//        datePicker.setValue(LocalDate.now());
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
                autoPuntenText.setText(String.format("%.0f gram CO2", new CO2(km, "Auto").getUitstoot()));
                regionaalPuntenText.setText(String.format("%.0f gram CO2", new CO2(km, "RegionaalOV").getUitstoot()));
                tramPuntenText.setText(String.format("%.0f gram CO2", new CO2(km, "Tram").getUitstoot()));
                fietsPuntenText.setText(String.format("%.0f gram CO2", new CO2(km, "Fiets").getUitstoot()));
            }

            Double puntenDouble = loggedIn.getPunten().berekenAantalPuntenWoonWerkVerkeer(100, km, arg.toString(), elektrisch);
            new WoonWerkReis(new Date(),puntenDouble,km,arg.toString(), loggedIn);

        } else if (zakelijk.isSelected()) {
            punten = String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer(km, arg.toString(), elektrisch));
            text.setText(punten);

            if (choicebox.getValue().toString().equalsIgnoreCase("punten")) {
                autoPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer(km, "Auto", elektrisch)));
                regionaalPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer(km, "RegionaalOV", elektrisch)));
                tramPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer(km, "Tram", elektrisch)));
                fietsPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer(km, "Fiets", elektrisch)));
            } else {
                autoPuntenText.setText(String.format("%.0f gram CO2", new CO2(km, "Auto").getUitstoot()));
                regionaalPuntenText.setText(String.format("%.0f gram CO2", new CO2(km, "RegionaalOV").getUitstoot()));
                tramPuntenText.setText(String.format("%.0f gram CO2", new CO2(km, "Tram").getUitstoot()));
                fietsPuntenText.setText(String.format("%.0f gram CO2", new CO2(km, "Fiets").getUitstoot()));
            }
            if (arg.toString().equalsIgnoreCase("auto")) {
                new ZakelijkeReis().alternatiefZakelijkVerkeer("regionaalOV", km, elektrisch, arg);
            } else if (arg.toString().equalsIgnoreCase("RegionaalOV")) {
                new ZakelijkeReis().alternatiefZakelijkVerkeer("tram", km, elektrisch, arg);
            } else if (arg.toString().equalsIgnoreCase("Tram")) {
                alternatief.setText("");
            }
        }
    }
}

