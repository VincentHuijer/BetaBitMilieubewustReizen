package hhs.proj2_klas6_groep6d;

import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class GebruikersOpslagTest {

    @Test
    public void testAddGebruiker() {
        //Test of een gebruiker toevoegen goed gaat.
        GebruikersOpslag gebruikersOpslag = new GebruikersOpslag();
        assertEquals(1, gebruikersOpslag.getGebruikers().size());
        Gebruiker testGebruiker = new Gebruiker("testNaam", "testWachtwoord", "testVoornaam", "testAchternaam", -1);

        gebruikersOpslag.addGebruiker(testGebruiker);
        assertEquals(2, gebruikersOpslag.getGebruikers().size());
    }

    @Test
    public void testRemoveGebruiker() {
        //Test of een gebruiker verwijderen goed gaat.
        GebruikersOpslag gebruikersOpslag = new GebruikersOpslag();
        assertEquals(1, gebruikersOpslag.getGebruikers().size());
        Gebruiker testGebruiker = new Gebruiker("testNaam", "testWachtwoord", "testVoornaam", "testAchternaam", -1);
        gebruikersOpslag.addGebruiker(testGebruiker); 
        assertEquals(2, gebruikersOpslag.getGebruikers().size());
        gebruikersOpslag.removeGebruiker(testGebruiker);
        assertEquals(1, gebruikersOpslag.getGebruikers().size());

    }
}