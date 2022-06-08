package hhs.Schermen;

import hhs.proj2_klas6_groep6d.CO2;
import hhs.proj2_klas6_groep6d.Persoon;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.*;

public class ZakelijkeReisText{
    public void setText(ChoiceBox choicebox, Text autoPuntenText, Text regionaalPuntenText, Text tramPuntenText, Text fietsPuntenText,
                           Text text, double km, boolean elektrisch, Object arg, Persoon loggedIn) {
        String punten = String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer(km, arg.toString(), elektrisch));
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
    }
}
