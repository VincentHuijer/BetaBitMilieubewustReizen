package hhs.proj2_klas6_groep6d;

public class CO2 {
    double km;
    double uitstoot;
    String vervoersmiddel;
    boolean elektrisch;

    public CO2(double km, String vervoersmiddel, boolean elektrisch) {
        this.km = km;
        this.vervoersmiddel = vervoersmiddel;
        this.elektrisch = elektrisch;
        this.uitstoot = berekenUitstoot();

    }

    public double getUitstoot() {
        return this.uitstoot;
    }

    private double berekenUitstoot() {
        //formule voor het berekenen van de CO2 uitstoot
        if (vervoersmiddel.equalsIgnoreCase("auto")) {
            if (elektrisch) {
                return this.km * 107;
            } else {
                return this.km * 224;
            }
        }

        if (vervoersmiddel.equalsIgnoreCase("RegionaalOV")) {
            return this.km * 116;
            //Bus
        }

        return 0;
    }
}