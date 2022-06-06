package hhs.proj2_klas6_groep6d;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BedrijfTest {
    //private static ArrayList<Gebruiker> gebruikers = new ArrayList<>();


    @Test
    public void testAddGebruiker() {
        Bedrijf bedrijf = new Bedrijf();
        assertEquals(1, bedrijf.getGebruikers().size());
        Gebruiker testGebruiker = new Gebruiker("testNaam", "testWachtwoord", "testVoornaam", "testAchternaam");

        bedrijf.addGebruiker(testGebruiker);
        //TODO In de bedrijf class zit al een testGebruiker/testAdmin met als parameters voor alles 1. Daarom is de actual 2 nadat we een gebruiker toevoegen.
        assertEquals(2, bedrijf.getGebruikers().size());


    }

    @Test
    public void testRemoveGebruiker() {
        Bedrijf bedrijf = new Bedrijf();
        assertEquals(2, bedrijf.getGebruikers().size());
        Gebruiker testGebruiker = new Gebruiker("testNaam", "testWachtwoord", "testVoornaam", "testAchternaam");
        bedrijf.addGebruiker(testGebruiker); //TODO In de bedrijf class zit al een testGebruiker/testAdmin met als parameters voor alles 1. Daarom is de actual 2 nadat we een gebruiker toevoegen.
        assertEquals(3, bedrijf.getGebruikers().size());
        bedrijf.removeGebruiker(testGebruiker);
        assertEquals(2, bedrijf.getGebruikers().size());

    }
}