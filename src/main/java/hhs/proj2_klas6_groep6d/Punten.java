package hhs.proj2_klas6_groep6d;

import java.math.RoundingMode;

public class Punten {
    private double aantalPunten;
/** waarom moet ik double aantalPunten meegeven voor de class punten? Heeft nog niets te maken met de methodes zoals ik het nu zie. Zowel excuses :-)
    Punten(double aantalPunten){
        this.aantalPunten = aantalPunten;
    }
*/
    public double getAantalPunten() {
        return aantalPunten;
    }

    public void addPunten(double aantalPunten){
        this.aantalPunten += aantalPunten;
    }

    public void setAantalPunten(double aantalPunten) {
        this.aantalPunten = aantalPunten;
    }

    //Formule voor berekenen aantal punten bij woon werkverkeer.
    public double berekenAantalPuntenWoonWerkVerkeer(double grootsteAfstandInKm, double afstand, String vervoersMiddel){
        double multiplier = 1;
        if(vervoersMiddel.equalsIgnoreCase("Auto") || vervoersMiddel.equalsIgnoreCase("Motor")){
            multiplier = 0;
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
    public double berekenAantalPuntenZakelijkVerkeer(double afstand, String vervoersMiddel){
        double multiplier = 1;
        if(vervoersMiddel.equalsIgnoreCase("Auto") || vervoersMiddel.equalsIgnoreCase("Motor")){
            multiplier = 0;
        }
        else if(vervoersMiddel.equalsIgnoreCase("RegionaalOV")){
            multiplier = 0.69;
        }

        return (Math.round(afstand * multiplier));
    }


}
