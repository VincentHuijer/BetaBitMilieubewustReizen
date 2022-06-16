package hhs.proj2_klas6_groep6d;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ReisTest {
    @Test
    void testGetAfstand() {
        //Test of afstand goed wordt geinitialiseerd bij aanmaken reis object.
        Gebruiker gebruiker = new Gebruiker("testGebruiker", "testWachtwoord", "testVoornaam", "testAchternaam", -1);
        Date date = new Date();
        Reis reis = new Reis(date,25.4, 132.4,"auto", gebruiker, false);
        assertEquals(132.4, reis.getAfstand());
    }

    @Test
    void testGetPunten() {
        //Test of hoeveelheid punten goed wordt geinitialiseerd bij aanmaken reis object.
        Gebruiker gebruiker = new Gebruiker("testGebruiker", "testWachtwoord", "testVoornaam", "testAchternaam", -1);

        Date date = new Date();
        Reis reis = new Reis(date,25.4, 132.4,"auto", gebruiker, false);
        gebruiker.getPunten().addPunten(reis.getPunten());

        assertEquals(25.4, reis.getPunten(), 0.1);
        assertEquals(25.4, gebruiker.getPunten().getAantalPunten(), 0.1);
    }

    @Test
    void testGetVervoersMiddel() {
        //Test of vervoersmiddel goed wordt geinitialiseerd bij aanmaken reis object.
        Gebruiker gebruiker = new Gebruiker("testGebruiker", "testWachtwoord", "testVoornaam", "testAchternaam", -1);
        Date date = new Date();
        Reis reis = new Reis(date,25.4, 132.4,"auto", gebruiker, false);
        assertEquals("auto", reis.getVervoersMiddel());
    }

    @Test
    public void testGetCo2(){
        //Test of de CO2 uitstoot bij specifieke vervoersmiddelen klopt.
        Gebruiker gebruiker = new Gebruiker("testGebruiker", "testWachtwoord", "testVoornaam", "testAchternaam", -1);
        Date date = new Date();

        //Auto niet elektrisch
        Reis autoReis = new WoonWerkReis(date,1, 25,"auto", gebruiker, false);
        Assertions.assertEquals(5600, autoReis.getCO2().getUitstoot(), 0.01);

        //Auto wel elektrisch
        Reis elektrischAutoReis = new WoonWerkReis(date,1, 25,"auto", gebruiker, true);
        Assertions.assertEquals(2675, elektrischAutoReis.getCO2().getUitstoot(), 0.01);

        //Bus
        Reis bus = new WoonWerkReis(date,1, 25,"regionaalOV", gebruiker, false);
        Assertions.assertEquals(2900, bus.getCO2().getUitstoot(), 0.01);
    }
}