package hhs.proj2_klas6_groep6d;

import java.util.Date;

public class Reis { //een reis bevat een datum, aantal punten die je verdient voor de reis, afstand, vervoersmiddel, de persoon die de rit heeft uitgevoerd en er word gekeken of de persoon elektrische vervoer heeft gebruikt als relevant.
    private Date date;
    private double punten;
    private double afstand;
    private String vervoersMiddel;
    private CO2 cO2;
    protected Persoon loggedIn;
    private boolean elektrisch;

    public Reis(Date date, double punten, double afstand, String vervoersMiddel, Persoon loggedIn, boolean elektrisch) {
        this.date = date;
        this.punten = punten;
        this.afstand = afstand;
        this.cO2 = new CO2(afstand, vervoersMiddel, elektrisch);
        this.vervoersMiddel = vervoersMiddel;
        this.loggedIn = loggedIn;
        this.elektrisch = elektrisch;
    }

    public CO2 getCO2() {
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
