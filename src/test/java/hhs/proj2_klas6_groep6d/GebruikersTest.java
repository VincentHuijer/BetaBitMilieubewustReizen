package hhs.proj2_klas6_groep6d;

import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class GebruikersTest {

    @Test
    public void testAddGebruiker() {
        Gebruikers gebruikers = new Gebruikers();
        assertEquals(1, gebruikers.getGebruikers().size());
        Gebruiker testGebruiker = new Gebruiker("testNaam", "testWachtwoord", "testVoornaam", "testAchternaam", -1);

        gebruikers.addGebruiker(testGebruiker);
        //TODO In de bedrijf class zit al een testGebruiker/testAdmin met als parameters voor alles 1. Daarom is de actual 2 nadat we een gebruiker toevoegen.
        assertEquals(2, gebruikers.getGebruikers().size());
    }

    @Test
    public void testRemoveGebruiker() {
        Gebruikers gebruikers = new Gebruikers();
        assertEquals(1, gebruikers.getGebruikers().size());
        Gebruiker testGebruiker = new Gebruiker("testNaam", "testWachtwoord", "testVoornaam", "testAchternaam", -1);
        gebruikers.addGebruiker(testGebruiker); //TODO In de bedrijf class zit al een testGebruiker/testAdmin met als parameters voor alles 1. Daarom is de actual 2 nadat we een gebruiker toevoegen.
        assertEquals(2, gebruikers.getGebruikers().size());
        gebruikers.removeGebruiker(testGebruiker);
        assertEquals(1, gebruikers.getGebruikers().size());

    }
}