package hhs.proj2_klas6_groep6d;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PuntenTest {


    @Test
    public void TestberekenAantalPuntenWoonWerkVerkeer() {
        Punten punten = new Punten();
        assertEquals(10, BerekenPunten.berekenAantalPuntenWoonWerkVerkeer(20, 10, "auto", false), 0.01);
        assertEquals(88.0, BerekenPunten.berekenAantalPuntenWoonWerkVerkeer(100, 12.2, "auto", false), 0.01);
        assertEquals(-1, BerekenPunten.berekenAantalPuntenWoonWerkVerkeer(10, 20, "motor", false), 0.01);
        assertEquals(6.0, BerekenPunten.berekenAantalPuntenWoonWerkVerkeer(6.75, 3.69, "RegionaalOV", false), 0.01);
        assertEquals(19.0, BerekenPunten.berekenAantalPuntenWoonWerkVerkeer(23.32, 14.41, "RegionaalOV", false), 0.01);
    }

    @Test
    public void TestberekenAantalPuntenZakelijkVerkeer() {
        Punten punten = new Punten();
        assertEquals(0, BerekenPunten.berekenAantalPuntenZakelijkVerkeer(20, "auto", false), 0.01);
        assertEquals(0, BerekenPunten.berekenAantalPuntenZakelijkVerkeer(0.1, "motor", false), 0.01);
        assertEquals(0, BerekenPunten.berekenAantalPuntenZakelijkVerkeer(99.9, "motor", false), 0.01);
        assertEquals(7, BerekenPunten.berekenAantalPuntenZakelijkVerkeer(9.43, "RegionaalOV", false), 0.01);
        assertEquals(0.0, BerekenPunten.berekenAantalPuntenZakelijkVerkeer(0.1, "RegionaalOV", false), 0.01);
        assertEquals(4.0, BerekenPunten.berekenAantalPuntenZakelijkVerkeer(5.41, "RegionaalOV", false), 0.01);
    }
}