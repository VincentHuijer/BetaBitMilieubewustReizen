package hhs.proj2_klas6_groep6d;

public class CO2 {
    double km;
    double uitstoot;
    String vervoersmiddel;

    public CO2(double km, String vervoersmiddel){
        this.km = km;
        this.vervoersmiddel = vervoersmiddel;
        this.uitstoot = berekenUitstoot();
    }

    public double getUitstoot(){
        return this.uitstoot;
    }

    private double berekenUitstoot(){
        //formule voor t berekenen van de CO2 uitstoot

        if(vervoersmiddel.equalsIgnoreCase("auto")){
            return 1;
        }
        if(vervoersmiddel.equalsIgnoreCase("RegionaalOV")){
            return 2;
        }
        if(vervoersmiddel.equalsIgnoreCase("Tram")){
            return 3;
        }
        if(vervoersmiddel.equalsIgnoreCase("Fiets")){
            return 4;
        }

        return 1.0;
    }
}