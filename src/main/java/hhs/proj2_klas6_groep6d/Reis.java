package hhs.proj2_klas6_groep6d;

import java.util.Date;

public class Reis {
    private Date date;
    private double punten;
    private double afstand;
    private String vervoersMiddel;
    private CO2 cO2;
    protected Persoon loggedIn;

    public Reis(Date date, double punten, double afstand, String vervoersMiddel, Persoon loggedIn) {
        this.date = date;
        this.punten = punten;
        this.afstand = afstand;
        this.cO2 = new CO2(afstand,vervoersMiddel);
        this.vervoersMiddel = vervoersMiddel;
        this.loggedIn = loggedIn;
    }

    public CO2 getCO2(){
        return this.cO2;
    }

    public Date getDate() {
        return date;
    }

    public double getAfstand() {
        return afstand;
    }

    public double getPunten() {
        return punten;
    }

    public String getVervoersMiddel() {
        return vervoersMiddel;
    }
}
