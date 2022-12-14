package hhs.controllersAndScreens;

import hhs.proj2_klas6_groep6d.BerekenPunten;
import hhs.proj2_klas6_groep6d.CO2;
import hhs.proj2_klas6_groep6d.Persoon;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.*;

public class ZakelijkeReisText{
    public void setText(ChoiceBox choicebox, Text autoPuntenText, Text regionaalPuntenText, Text tramPuntenText, Text fietsPuntenText,
                           Text text, double km, boolean elektrisch, Object arg, Persoon loggedIn) {
        String punten = String.format("%.0f Punten", BerekenPunten.berekenAantalPuntenZakelijkVerkeer(km, arg.toString(), elektrisch));
        text.setText(punten);
        if (choicebox.getValue().toString().equalsIgnoreCase("punten")) {
            autoPuntenText.setText(String.format("%.0f Punten", BerekenPunten.berekenAantalPuntenZakelijkVerkeer(km, "Auto", elektrisch)));
            regionaalPuntenText.setText(String.format("%.0f Punten", BerekenPunten.berekenAantalPuntenZakelijkVerkeer(km, "RegionaalOV", elektrisch)));
            tramPuntenText.setText(String.format("%.0f Punten", BerekenPunten.berekenAantalPuntenZakelijkVerkeer(km, "Tram", elektrisch)));
            fietsPuntenText.setText(String.format("%.0f Punten", BerekenPunten.berekenAantalPuntenZakelijkVerkeer(km, "Fiets", elektrisch)));
        } else {
            autoPuntenText.setText(String.format("%.1f kg CO2", new CO2(km,"auto", elektrisch).getUitstoot() / 1000));
            regionaalPuntenText.setText(String.format("%.1f kg CO2", new CO2(km,"regionaalOV", elektrisch).getUitstoot() / 1000));
            tramPuntenText.setText(String.format("%.1f kg CO2", new CO2(km,"tram", elektrisch).getUitstoot() / 1000));
            fietsPuntenText.setText(String.format("%.1f kg CO2", new CO2(km,"fiets", elektrisch).getUitstoot() / 1000));
        }
    }
}
