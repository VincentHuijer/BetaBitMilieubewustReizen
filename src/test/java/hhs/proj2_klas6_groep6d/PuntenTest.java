package hhs.proj2_klas6_groep6d;

import hhs.Controllers.ReisSysteemController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PuntenTest {


    @Test
    public void testberekenAantalPuntenWoonWerkVerkeer() {
        assertEquals(10, BerekenPunten.berekenAantalPuntenWoonWerkVerkeer(20, 10, "auto", false), 0.01);
        assertEquals(88.0, BerekenPunten.berekenAantalPuntenWoonWerkVerkeer(100, 12.2, "auto", false), 0.01);
        assertEquals(-1, BerekenPunten.berekenAantalPuntenWoonWerkVerkeer(10, 20, "motor", false), 0.01);
        assertEquals(6.0, BerekenPunten.berekenAantalPuntenWoonWerkVerkeer(6.75, 3.69, "RegionaalOV", false), 0.01);
        assertEquals(19.0, BerekenPunten.berekenAantalPuntenWoonWerkVerkeer(23.32, 14.41, "RegionaalOV", false), 0.01);
    }

    @Test
    public void testberekenAantalPuntenZakelijkVerkeer() {
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
        assertEquals(1, BerekenPunten.berekenMultiplier(10, "fiets", false));
        assertEquals(1.5, BerekenPunten.berekenMultiplier(11, "fiets", false));
        assertEquals(1.5, BerekenPunten.berekenMultiplier(20, "fiets", false));
        assertEquals(2.0, BerekenPunten.berekenMultiplier(21, "fiets", false));
    }

    @Test
    public void testVeranderKleurKnop(){
        ReisSysteemController reisSysteemController = new ReisSysteemController();
        reisSysteemController.changeAddReisKnopKleur(0);
        assertEquals("-fx-background-color: #63D13c;", reisSysteemController.changeAddReisKnopKleur(0));
        assertEquals("-fx-background-color: #0033ff;", reisSysteemController.changeAddReisKnopKleur(999));
        assertEquals("-fx-background-color: #0033ff;", reisSysteemController.changeAddReisKnopKleur(1000));
        assertEquals("-fx-background-color: #0033ff;", reisSysteemController.changeAddReisKnopKleur(1001));
        assertEquals("-fx-background-color: #0033ff;", reisSysteemController.changeAddReisKnopKleur(2999));
        assertEquals("-fx-background-color: #ff4400;", reisSysteemController.changeAddReisKnopKleur(3000));
        assertEquals("-fx-background-color: #ff4400;", reisSysteemController.changeAddReisKnopKleur(3001));
    }

}