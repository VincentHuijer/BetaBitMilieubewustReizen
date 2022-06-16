package hhs.proj2_klas6_groep6d;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GebruikerTest {
    @Test
    public void testGebruikerData(){
        Gebruiker gebruiker = new Gebruiker("Test_1", "Wachtwoord_1", "Voornaam1", "Achternaam1", -1);

        Assertions.assertEquals(gebruiker.getUsername(), "Test_1");

        Assertions.assertEquals(gebruiker.getWachtwoord(), "Wachtwoord_1");

        Assertions.assertEquals(gebruiker.getVoornaam(), "Voornaam1");

        Assertions.assertEquals(gebruiker.getAchternaam(), "Achternaam1");

    }
}
