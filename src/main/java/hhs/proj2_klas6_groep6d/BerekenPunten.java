package hhs.proj2_klas6_groep6d;

public class BerekenPunten {

    //Formule voor berekenen aantal punten bij woon werkverkeer.
    public static double berekenAantalPuntenWoonWerkVerkeer(double grootsteAfstandInKm, double afstand, String vervoersMiddel, boolean elektrisch){
        double multiplier = 1;
        if(vervoersMiddel.equalsIgnoreCase("Auto") || vervoersMiddel.equalsIgnoreCase("Motor")){ //auto en motor geven even veel punten.
            multiplier = 0;
            if(elektrisch){
                multiplier = 0.69;
            }
        }
        else if(vervoersMiddel.equalsIgnoreCase("RegionaalOV")){
            multiplier = 0.69;
        }
        else if(afstand > 10 && !vervoersMiddel.equalsIgnoreCase("Tram")){
            multiplier = 1.5;
        }
        if (grootsteAfstandInKm < afstand){
            return -1;
        }
        return (Math.round(grootsteAfstandInKm - afstand + (afstand * multiplier)));
    }

    //Formule berekenen aantal punten bij zakelijk verkeer (tussen werk en klant).
    public static double berekenAantalPuntenZakelijkVerkeer(double afstand, String vervoersMiddel, boolean elektrisch){
        double multiplier = 1;
        if(vervoersMiddel.equalsIgnoreCase("Auto") || vervoersMiddel.equalsIgnoreCase("Motor")){ //auto en motor zijn niet zuinig en belonen geen punten.
            multiplier = 0;
            if(elektrisch){ //elektrisch vervoer is zuiniger en beloond evenveel punten als regionaal OV voor nu.
                multiplier = 0.69;
            }
        }
        else if(vervoersMiddel.equalsIgnoreCase("RegionaalOV")){
            multiplier = 0.69;
        }else if(afstand > 10 && !vervoersMiddel.equalsIgnoreCase("Tram")){
            multiplier = 1.5;
        }

        return (Math.round(afstand * multiplier));
    }
}
