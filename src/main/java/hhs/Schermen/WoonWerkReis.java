package hhs.Schermen;

import javafx.scene.text.Text;

public class WoonWerkReis extends TypeReis {

    public WoonWerkReis(double km, boolean elektrisch, Object arg) {
        super();
        kiesAlternatiefVervoer(km, elektrisch, arg);
    }

    public void kiesAlternatiefVervoer( double km, boolean elektrisch, Object arg) { //
        Text alternatief = (Text) scene.lookup("#AlternatieveText");
        if (arg.toString().equalsIgnoreCase("auto")) {
            alternatiefWoonWerkVerkeer("regionaalOV", km, elektrisch, arg, alternatief);
        } else if (arg.toString().equalsIgnoreCase("RegionaalOV")) {
            alternatiefWoonWerkVerkeer("tram", km, elektrisch, arg, alternatief);
        } else if (arg.toString().equalsIgnoreCase("Tram")) {
            alternatief.setText("");
        }
    }

    private void alternatiefWoonWerkVerkeer(String vervoersmiddel, double km, boolean elektrisch, Object arg, Text alternatief) { //Zet tekst neer om gebruiker op de hoogte te stellen van een betere optie die meer punten oplevert
        alternatief.setText("Voor meer punten kunt u met de duurzamere optie gaan want dan krijgt u "
                + (loggedIn.getPunten().berekenAantalPuntenWoonWerkVerkeer(100, km, vervoersmiddel, elektrisch) - loggedIn.getPunten().berekenAantalPuntenWoonWerkVerkeer(100, km, arg.toString(), elektrisch))
                + " punten meer.");
    }
}
