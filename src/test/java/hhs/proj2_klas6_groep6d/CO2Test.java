package hhs.proj2_klas6_groep6d;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CO2Test {


    @Test
    public void berekenCO2() {
        double autoUitstootExpected = 2240;
        double elektrischeAutoUitstootExpected = 1070;
        double busUitstootExpected = 1160;
        CO2 auto = new CO2(10, "auto", false);
        CO2 elektrischeAUto = new CO2(10, "auto", true);
        CO2 bus = new CO2(10, "RegionaalOV", false);
        assertEquals(autoUitstootExpected, auto.getUitstoot()); //test met een reguliere auto
        assertEquals(elektrischeAutoUitstootExpected, elektrischeAUto.getUitstoot()); //test met een elektrische auto
        assertEquals(busUitstootExpected, bus.getUitstoot()); //test met het regionaal OV (Een bus).
    }
}