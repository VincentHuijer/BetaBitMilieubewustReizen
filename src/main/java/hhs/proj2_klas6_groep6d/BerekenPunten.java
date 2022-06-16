package hhs.proj2_klas6_groep6d;

public class BerekenPunten {  // In deze class worden de punten berekend
    private static double multiplier;

    public static double berekenMultiplier(double afstand, String vervoersMiddel, boolean elektrisch) {
        double multi = 1;
        if (vervoersMiddel.equalsIgnoreCase("Auto") || vervoersMiddel.equalsIgnoreCase("Motor")) { //auto en motor geven even veel punten.
            multi = 0;
            if (elektrisch) {
                multi = 0.69;
            }
        } else if (vervoersMiddel.equalsIgnoreCase("RegionaalOV")) {
            multi = 0.69;
        } else if (afstand > 10 && afstand <= 20 && !vervoersMiddel.equalsIgnoreCase("Tram")) {
            multi = 1.5;
        } else if (afstand > 20 && !vervoersMiddel.equalsIgnoreCase("Tram")) {
            multi = 2;
        }
        return multi;
    }

    //Formule voor berekenen aantal punten bij woon-werkverkeer.
    public static double berekenAantalPuntenWoonWerkVerkeer(double grootsteAfstandInKm, double afstand, String vervoersMiddel, boolean elektrisch) {
        multiplier = berekenMultiplier(afstand, vervoersMiddel, elektrisch);
        if (grootsteAfstandInKm < afstand) {
            return -1;
        }
        return (Math.round(grootsteAfstandInKm - afstand + (afstand * multiplier)));
    }

    //Formule berekenen aantal punten bij zakelijk verkeer (tussen werk en klant).
    public static double berekenAantalPuntenZakelijkVerkeer(double afstand, String vervoersMiddel, boolean elektrisch) {

        multiplier = berekenMultiplier(afstand, vervoersMiddel, elektrisch);

        return (Math.round(afstand * multiplier));
    }
}
