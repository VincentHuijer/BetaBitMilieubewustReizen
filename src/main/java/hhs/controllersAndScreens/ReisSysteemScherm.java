package hhs.controllersAndScreens;

import hhs.proj2_klas6_groep6d.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

public class ReisSysteemScherm implements Observer {
    protected static Persoon loggedIn;
    protected static Scene scene;
    protected static Stage stage;

    public void start() throws Exception {
        if (stage == null) {
            stage = new Stage();
        }

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("reisSysteem.fxml"));
        scene = new Scene(fxmlLoader.load(), 700, 530);
        Text welkomText = (Text) scene.lookup("#welkomText");
        welkomText.setText("Welkom " + loggedIn.displayName());
        Text punten = (Text) scene.lookup("#puntensaldoText");
        punten.setText(String.format("%.0f PUNTEN", loggedIn.getPunten().getAantalPunten()));

        ChoiceBox viewSwitch = (ChoiceBox) scene.lookup("#viewSwitch");

        viewSwitch.setValue("Punten");
        viewSwitch.getItems().add("CO2");
        viewSwitch.getItems().add("Punten");

        DatePicker datePicker = (DatePicker) scene.lookup("#datePicker");
        datePicker.setValue(LocalDate.now());

        Text alternatief = (Text) scene.lookup("#AlternatieveText");
        alternatief.setText("Vul een waarde in");

        Text autoPuntenText = (Text) scene.lookup("#autoPuntenText");
        Text regionaalPuntenText = (Text) scene.lookup("#regionaalPuntenText");
        Text tramPuntenText = (Text) scene.lookup("#tramPuntenText");
        Text fietsPuntenText = (Text) scene.lookup("#fietsPuntenText");

        autoPuntenText.setText("0 Punten");
        regionaalPuntenText.setText("0 Punten");
        tramPuntenText.setText("0 Punten");
        fietsPuntenText.setText("0 Punten");

        stage.setTitle("Reis Toevoegen");
        stage.getIcons().add(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("images/logoT.png"))));
        stage.setScene(scene);
        stage.show();
    }

    public void setLoggedIn(Persoon gebruiker) {
        loggedIn = gebruiker;
    }

    public Persoon getLoggedIn() {
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
        if (woonWerk.isSelected()) {
            double puntenDouble = BerekenPunten.berekenAantalPuntenWoonWerkVerkeer(100, km, arg.toString(), elektrisch);
            new WoonWerkReisText().setText(choicebox, autoPuntenText, regionaalPuntenText, tramPuntenText, fietsPuntenText, text, km, elektrisch, arg, loggedIn);
            new WoonWerkReis(new Date(),puntenDouble,km,arg.toString(), loggedIn, elektrisch).kiesAlternatiefVervoer(alternatief, km, elektrisch, arg);
        } else if (zakelijk.isSelected()) {
            double puntenDouble = BerekenPunten.berekenAantalPuntenWoonWerkVerkeer(100, km, arg.toString(), elektrisch);
            new ZakelijkeReisText().setText(choicebox,autoPuntenText,regionaalPuntenText,tramPuntenText,fietsPuntenText,text,km,elektrisch,arg,loggedIn);
            new ZakelijkeReis(new Date(), puntenDouble, km, arg.toString() ,loggedIn, elektrisch).kiesAlternatiefVervoer(alternatief, km, elektrisch, arg);
        }
    }
}