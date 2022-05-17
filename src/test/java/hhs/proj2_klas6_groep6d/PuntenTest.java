package hhs.proj2_klas6_groep6d;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PuntenTest {


    @Test
    public void TestberekenAantalPuntenWoonWerkVerkeer() {
        Punten punten = new Punten();
        assertEquals(10, punten.berekenAantalPuntenWoonWerkVerkeer(20, 10, "auto"), 0.01);
        assertEquals(-1, punten.berekenAantalPuntenWoonWerkVerkeer(10, 20, "motor"), 0.01);
        assertEquals(6.0, punten.berekenAantalPuntenWoonWerkVerkeer(6.75, 3.69, "RegionaalOV"), 0.01);
        assertEquals(19.0, punten.berekenAantalPuntenWoonWerkVerkeer(23.32, 14.41, "RegionaalOV"), 0.01);
    }

    @Test
    public void TestberekenAantalPuntenZakelijkVerkeer() {
        Punten punten = new Punten();
        assertEquals(0, punten.berekenAantalPuntenZakelijkVerkeer(20, "auto"), 0.01);
        assertEquals(0, punten.berekenAantalPuntenZakelijkVerkeer(0.1, "motor"), 0.01);
        assertEquals(0, punten.berekenAantalPuntenZakelijkVerkeer(99.9, "motor"), 0.01);
        assertEquals(7, punten.berekenAantalPuntenZakelijkVerkeer(9.43, "RegionaalOV"), 0.01);
        assertEquals(0.0, punten.berekenAantalPuntenZakelijkVerkeer(0.1, "RegionaalOV"), 0.01);
        assertEquals(4.0, punten.berekenAantalPuntenZakelijkVerkeer(5.41, "RegionaalOV"), 0.01);
    }
}