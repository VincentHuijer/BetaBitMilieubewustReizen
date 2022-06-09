package hhs.Schermen;

import hhs.proj2_klas6_groep6d.CO2;
import hhs.proj2_klas6_groep6d.Persoon;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;

public class WoonWerkReisText {
    public void setText(ChoiceBox choicebox, Text autoPuntenText, Text regionaalPuntenText, Text tramPuntenText, Text fietsPuntenText,
                           Text text, double km, boolean elektrisch, Object arg, Persoon loggedIn){
        String punten = String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenWoonWerkVerkeer(100, km, arg.toString(), elektrisch));
        text.setText(punten);

        if (choicebox.getValue().toString().equalsIgnoreCase("punten")) {
            autoPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenWoonWerkVerkeer(100, km, "Auto", elektrisch)));
            regionaalPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenWoonWerkVerkeer(100, km, "RegionaalOV", elektrisch)));
            tramPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenWoonWerkVerkeer(100, km, "Tram", elektrisch)));
            fietsPuntenText.setText(String.format("%.0f Punten", loggedIn.getPunten().berekenAantalPuntenWoonWerkVerkeer(100, km, "Fiets", elektrisch)));
        } else {
            autoPuntenText.setText(String.format("%.0f gram CO2", new CO2(km,"auto").getUitstoot()));
            regionaalPuntenText.setText(String.format("%.0f gram CO2", new CO2(km,"regionaalOV").getUitstoot()));
            tramPuntenText.setText(String.format("%.0f gram CO2", new CO2(km,"tram").getUitstoot()));
            fietsPuntenText.setText(String.format("%.0f gram CO2", new CO2(km,"fiets").getUitstoot()));
        }
    }
}
