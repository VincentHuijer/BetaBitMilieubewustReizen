package hhs.proj2_klas6_groep6d;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GebruikerTest {
    @Test
    public void addGebruiker(){
        Gebruiker gebruiker = new Gebruiker("Test_1", "Wachtwoord_1", "Voornaam1", "Achternaam1", new Adres("Straatnaam", 4, "2527AB"), new Team("Teamnaam1", new ArrayList<Gebruiker>()));

        Assertions.assertEquals(gebruiker.getUsername(), "Test_1");

        Assertions.assertEquals(gebruiker.getWachtwoord(), "Wachtwoord_1");

        Assertions.assertEquals(gebruiker.getVoornaam(), "Voornaam1");

        Assertions.assertEquals(gebruiker.getAchternaam(), "Achternaam1");

        Assertions.assertEquals(gebruiker.getAdres().toString(), "Straatnaam 4 2527AB");
    }
}
