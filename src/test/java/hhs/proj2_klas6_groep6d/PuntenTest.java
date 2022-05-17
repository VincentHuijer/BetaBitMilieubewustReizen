package hhs.proj2_klas6_groep6d;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PuntenTest {



    @Test
   public void TestberekenAantalPuntenWoonWerkVerkeer() {
        Punten punten = new Punten();
        assertEquals(10, punten.berekenAantalPuntenWoonWerkVerkeer(20,10,"auto"),0001);
   //onmogelijke input   assertEquals(-1,punten.berekenAantalPuntenWoonWerkVerkeer(10,20,"motor"),0001);
        assertEquals(0.78,punten.berekenAantalPuntenWoonWerkVerkeer(1.5,2.3,"RegionaalOV"),0001);
    }

    @Test
    public void TestberekenAantalPuntenZakelijkVerkeer() {
        Punten punten = new Punten();
        assertEquals(0,punten.berekenAantalPuntenZakelijkVerkeer(20,"auto"),0001);
        assertEquals(0,punten.berekenAantalPuntenZakelijkVerkeer(0.1,"motor"),0001);
        assertEquals(0,punten.berekenAantalPuntenZakelijkVerkeer(99.9,"motor"),0001);
        assertEquals(6.5,punten.berekenAantalPuntenZakelijkVerkeer(9.43,"RegionaalOV"),0001);
        assertEquals(0.1,punten.berekenAantalPuntenZakelijkVerkeer(0.1,"RegionaalOV"),0001);
    }
}