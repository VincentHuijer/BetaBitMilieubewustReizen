package hhs.proj2_klas6_groep6d;

import hhs.Schermen.TypeReis;
import javafx.scene.text.Text;

public class ZakelijkeReis extends TypeReis {

    public void alternatiefZakelijkVerkeer(String vervoersmiddel, double km, boolean elektrisch, Object arg) { //Zet tekst neer om gebruiker op de hoogte te stellen van een betere optie die meer punten oplevert
        Text alternatief = (Text) scene.lookup("#AlternatieveText");
        alternatief.setText("Voor meer punten kunt u met de duurzamere optie gaan want dan krijgt u "
                + (loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer(km, vervoersmiddel, elektrisch) - loggedIn.getPunten().berekenAantalPuntenZakelijkVerkeer(km, arg.toString(), elektrisch))
                + " punten meer.");
    }
}
