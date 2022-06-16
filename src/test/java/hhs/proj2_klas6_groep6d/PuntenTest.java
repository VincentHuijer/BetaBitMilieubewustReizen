package hhs.proj2_klas6_groep6d;

import hhs.controllersAndScreens.ReisSysteemController;
import hhs.controllersAndScreens.ReisSysteemScherm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PuntenTest {


    @Test
    public void testberekenAantalPuntenWoonWerkVerkeer() {
        //Test of de puntenberekening bij woon werk verkeer goed gaat.
        assertEquals(10, BerekenPunten.berekenAantalPuntenWoonWerkVerkeer(20, 10, "auto", false), 0.01);
        assertEquals(88.0, BerekenPunten.berekenAantalPuntenWoonWerkVerkeer(100, 12.2, "auto", false), 0.01);
        assertEquals(-1, BerekenPunten.berekenAantalPuntenWoonWerkVerkeer(10, 20, "motor", false), 0.01);
        assertEquals(6.0, BerekenPunten.berekenAantalPuntenWoonWerkVerkeer(6.75, 3.69, "RegionaalOV", false), 0.01);
        assertEquals(19.0, BerekenPunten.berekenAantalPuntenWoonWerkVerkeer(23.32, 14.41, "RegionaalOV", false), 0.01);
    }

    @Test
    public void testberekenAantalPuntenZakelijkVerkeer() {
        //Test of de puntenberekening bij zakelijk verkeer goed gaat.
        assertEquals(0, BerekenPunten.berekenAantalPuntenZakelijkVerkeer(20, "auto", false), 0.01);
        assertEquals(0, BerekenPunten.berekenAantalPuntenZakelijkVerkeer(0.1, "motor", false), 0.01);
        assertEquals(0, BerekenPunten.berekenAantalPuntenZakelijkVerkeer(99.9, "motor", false), 0.01);
        assertEquals(7, BerekenPunten.berekenAantalPuntenZakelijkVerkeer(9.43, "RegionaalOV", false), 0.01);
        assertEquals(0.0, BerekenPunten.berekenAantalPuntenZakelijkVerkeer(0.1, "RegionaalOV", false), 0.01);
        assertEquals(4.0, BerekenPunten.berekenAantalPuntenZakelijkVerkeer(5.41, "RegionaalOV", false), 0.01);
    }
    @Test
    public void testBerekenPuntenMultiplierEquivalentie(){
        //Als de gebruiker loopt of fietst, krijgt hij/zij 1.5x zoveel punten als hij/zij meer dan 10km afstand aflegt en 2x zoveel punten bij meer dan 20km.
        //Dit is een equivalentietest met randwaarden. (Zie eindverslag voor beslissingstabel bij equivalentie tests)
        assertEquals(1, BerekenPunten.berekenMultiplier(10, "fiets", false));
        assertEquals(1.5, BerekenPunten.berekenMultiplier(11, "fiets", false));
        assertEquals(1.5, BerekenPunten.berekenMultiplier(20, "fiets", false));
        assertEquals(2.0, BerekenPunten.berekenMultiplier(21, "fiets", false));
    }

    @Test
    public void testVeranderKleurKnop(){ //De kleur van het toevoegen van een reis verandert naar mate je meer punten hebt. 0 t/m 999 is groen, 1000 t/m 2999 is blauw. 3000 of meer is oranje.
        //Dit is een equivalentie test met randwaarden. (Zie eindverslag voor beslissingstabel bij equivalentie tests)
        ReisSysteemScherm rs = new ReisSysteemScherm();
        rs.setLoggedIn(new Gebruiker("testUsername", "testWachtwoord", "testVoornaam", "testAchternaam", -1));
        ReisSysteemController reisSysteemController = new ReisSysteemController();
        reisSysteemController.generateReisKnopKleur(0);
        assertEquals("-fx-background-color: #63D13c;", reisSysteemController.generateReisKnopKleur(0));
        assertEquals("-fx-background-color: #63D13c;", reisSysteemController.generateReisKnopKleur(999));
        assertEquals("-fx-background-color: #0033ff;", reisSysteemController.generateReisKnopKleur(1000));
        assertEquals("-fx-background-color: #0033ff;", reisSysteemController.generateReisKnopKleur(2999));
        assertEquals("-fx-background-color: #ff4400;", reisSysteemController.generateReisKnopKleur(3000));
    }

}