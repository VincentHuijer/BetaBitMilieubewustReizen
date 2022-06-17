package hhs.proj2_klas6_groep6d;

import java.util.ArrayList;

public abstract class Persoon { //Deze class bevat eigenschappen die iedere persoon; voor nu een Gebruiker en Admin moet hebben.
    protected String voornaam;
    protected String achternaam;
    protected String wachtwoord;
    protected String username;
    protected int id;
    protected Punten punten = new Punten();
    protected double aantalPunten;
    protected double monthtotaalKm;
    protected ArrayList<Reis> alleReizen = new ArrayList<>();
    protected double totaalKm = 0;
    protected double puntenSaldo;

    public Persoon(String username, String wachtwoord, String voornaam, String achternaam, int id) {
        this.username = username;
        this.wachtwoord = wachtwoord;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.id = id;
    }
    public abstract String displayName();

    public abstract String getVoornaam();

    public abstract String getAchternaam();

    public abstract String getWachtwoord();

    public abstract String getUsername();

    public Punten getPunten() {
        return punten;
    }

    public int getId() {
        return id;
    }

    public double getAantalPunten() {
        return aantalPunten;
    }

    public double getMonthtotaalKm() {
        return monthtotaalKm;
    }

    public abstract boolean isAdmin();

    public void berekenTotaalKM() {
        double sum = 0;
        for (Reis reis : alleReizen) {
            sum += reis.getAfstand();
        }
        this.totaalKm = sum;
    }

    public double getTotaalKm() {
        return totaalKm;
    }

    public ArrayList<Reis> getAlleReizen() {
        return alleReizen;
    }

    public double getCo2Uitstoot() {
        double count = 0;
        for (Reis trip : alleReizen) {
            count += trip.getCO2().getUitstoot();
        }

        return count;
    }

    public double getPuntenSaldo() {
        return puntenSaldo;
    }


}
