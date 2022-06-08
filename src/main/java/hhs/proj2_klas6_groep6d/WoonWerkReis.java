package hhs.proj2_klas6_groep6d;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.util.Date;

public class WoonWerkReis extends Reis {
    public WoonWerkReis(Date date, double punten, double afstand, String vervoersMiddel, Persoon loggedIn){
        super(date, punten, afstand, vervoersMiddel, loggedIn);
    }



    public void kiesAlternatiefVervoer(Text alternatief, double km, boolean elektrisch, Object arg) { //
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