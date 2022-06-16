package hhs.proj2_klas6_groep6d;

import javafx.scene.text.Text;

import java.util.Date;

public class ZakelijkeReis extends Reis { //zakelijkReis houd in verkeer van huis naar klant.
    public ZakelijkeReis(Date date, double punten, double afstand, String vervoersMiddel, Persoon loggedIn, boolean elektrisch) {
        super(date, punten, afstand, vervoersMiddel, loggedIn, elektrisch);
    }

    public void kiesAlternatiefVervoer(Text alternatief, double km, boolean elektrisch, Object arg) { //
        if (arg.toString().equalsIgnoreCase("auto")) {
            alternatiefZakelijkVerkeer("regionaalOV", km, elektrisch, arg, alternatief);
        } else if (arg.toString().equalsIgnoreCase("RegionaalOV")) {
            alternatiefZakelijkVerkeer("tram", km, elektrisch, arg, alternatief);
        } else if (arg.toString().equalsIgnoreCase("Tram")) {
            alternatief.setText("");
        }
    }

    private void alternatiefZakelijkVerkeer(String vervoersmiddel, double km, boolean elektrisch, Object arg, Text alternatief) { //Zet tekst neer om gebruiker op de hoogte te stellen van een betere optie die meer punten oplevert
        alternatief.setText("Voor meer punten kunt u met de duurzamere optie gaan want dan krijgt u "
                + (BerekenPunten.berekenAantalPuntenWoonWerkVerkeer(100, km, vervoersmiddel, elektrisch) - BerekenPunten.berekenAantalPuntenWoonWerkVerkeer(100, km, arg.toString(), elektrisch))
                + " punten meer.");
    }
}