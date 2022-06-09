package hhs.proj2_klas6_groep6d;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class CO2Test {
    @Test
    public void berekenCO2() {
        CO2 auto = new CO2(10, "auto");
        CO2 bus = new CO2(10, "RegionaalOV");

        double autoUitstoot = 2240;
        double busUitstoot = 1160;

        Assertions.assertEquals(auto.getUitstoot(), autoUitstoot);
        Assertions.assertEquals(bus.getUitstoot(), busUitstoot);
    }

}
