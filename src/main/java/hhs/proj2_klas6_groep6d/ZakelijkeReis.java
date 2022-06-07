package hhs.proj2_klas6_groep6d;

import hhs.Schermen.TypeReis;
import javafx.scene.text.Text;

import java.util.Date;

public class ZakelijkeReis extends Reis {
    public ZakelijkeReis(Date date, double punten, double afstand, String vervoersMiddel, Gebruiker loggedIn){
        super(date, punten, afstand, vervoersMiddel, loggedIn);
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
                + (loggedIn.getPunten().berekenAantalPuntenWoonWerkVerkeer(100, km, vervoersmiddel, elektrisch) - loggedIn.getPunten().berekenAantalPuntenWoonWerkVerkeer(100, km, arg.toString(), elektrisch))
                + " punten meer.");
    }
}
