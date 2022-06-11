package hhs.proj2_klas6_groep6d;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReisTest {
    @Test
    void testGetAfstand() {
        Gebruiker gebruiker = new Gebruiker("testGebruiker", "testWachtwoord", "testVoornaam", "testAchternaam", -1);
        Date date = new Date();
        Reis reis = new Reis(date,25.4, 132.4,"auto", gebruiker, false);
        assertEquals(132.4, reis.getAfstand());
    }

    @Test
    void testGetPunten() {
        Gebruiker gebruiker = new Gebruiker("testGebruiker", "testWachtwoord", "testVoornaam", "testAchternaam", -1);

        Date date = new Date();
        Reis reis = new Reis(date,25.4, 132.4,"auto", gebruiker, false);
        gebruiker.getPunten().addPunten(reis.getPunten());

        assertEquals(25.4, reis.getPunten(), 0.1);
        assertEquals(25.4, gebruiker.getPunten().getAantalPunten(), 0.1);
    }

    @Test
    void testGetVervoersMiddel() {
        Gebruiker gebruiker = new Gebruiker("testGebruiker", "testWachtwoord", "testVoornaam", "testAchternaam", -1);
        Date date = new Date();
        Reis reis = new Reis(date,25.4, 132.4,"auto", gebruiker, false);
        assertEquals("auto", reis.getVervoersMiddel());
    }
}