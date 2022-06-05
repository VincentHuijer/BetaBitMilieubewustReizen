package hhs.proj2_klas6_groep6d;

public class CO2 {
    double km;
    double uitstoot;

    public CO2(double km){
        this.km = km;
        this.uitstoot = berekenUitstoot();
    }

    public double getUitstoot(){
        return this.uitstoot;
    }

    private double berekenUitstoot(){
        //formule voor t berekenen van de CO2 uitstoot
        return 0.0;
    }
}
