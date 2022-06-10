package hhs.proj2_klas6_groep6d;

public class BerekenPunten {

    //Formule voor berekenen aantal punten bij woon werkverkeer.
    public static double berekenAantalPuntenWoonWerkVerkeer(double grootsteAfstandInKm, double afstand, String vervoersMiddel, boolean elektrisch){
        double multiplier = 1;
        if(vervoersMiddel.equalsIgnoreCase("Auto") || vervoersMiddel.equalsIgnoreCase("Motor")){
            multiplier = 0;
            if(elektrisch){
                multiplier = 0.69;
            }
        }
        else if(vervoersMiddel.equalsIgnoreCase("RegionaalOV")){
            multiplier = 0.69;
        }
        if (grootsteAfstandInKm < afstand){
            return -1;
        }
        return (Math.round(grootsteAfstandInKm - afstand + (afstand * multiplier)));
    }

    //Formule berekenen aantal punten bij zakelijk verkeer (tussen werk en klant).
    public static double berekenAantalPuntenZakelijkVerkeer(double afstand, String vervoersMiddel, boolean elektrisch){
        double multiplier = 1;
        if(vervoersMiddel.equalsIgnoreCase("Auto") || vervoersMiddel.equalsIgnoreCase("Motor")){
            multiplier = 0;
            if(elektrisch){
                multiplier = 0.69;
            }
        }
        else if(vervoersMiddel.equalsIgnoreCase("RegionaalOV")){
            multiplier = 0.69;
        }

        return (Math.round(afstand * multiplier));
    }
}
