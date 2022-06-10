package hhs.proj2_klas6_groep6d;

import org.junit.jupiter.api.Test;

import java.util.Date;

public class CO2Test {
    @Test
    void testGetCO2() {
        Gebruiker gebruiker = new Gebruiker("testGebruiker", "testWachtwoord", "testVoornaam", "testAchternaam", -1);
        Date date = new Date();
        Reis reis = new Reis(date, 25.4, 132.4, "auto", gebruiker, false);
        System.out.println(reis.getCO2().getUitstoot());
    }

}
