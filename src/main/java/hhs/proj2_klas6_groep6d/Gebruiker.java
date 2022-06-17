package hhs.proj2_klas6_groep6d;

import java.util.ArrayList;
import java.util.Date;

public class Gebruiker extends Persoon { //een gebruiker is een standaard persooneelslid van BetaBit
    private static final int currentId = 0;
    private final String voornaam;
    private final String achternaam;
    private final String username;
    private final String wachtwoord;
    private final int id; // Medewerkers van betabit krijgen vanuit het bedrijf al een id. Dit onderdeel schrappen we misschien nog.
    private double puntenSaldo;
    private double totaalKm = 0;

    public Gebruiker(String username, String wachtwoord, String voornaam, String achternaam, int id) {
        super(username, wachtwoord, voornaam, achternaam, id);
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.id = id;
        this.username = username;
        this.wachtwoord = wachtwoord;
        initialiseerGebruiker();
    }

    @Override
    public String displayName() {
        return voornaam + " " + achternaam;
    }

    public double getMonthtotaalKm() {
        int month = new Date().getMonth();

        double count = 0;
        for (Reis trip : alleReizen) {
            if (trip.getDate().getMonth() == month) {
                count += trip.getAfstand();
            }
        }

        return count;
    }

    public double getMonthco2Uitstoot() {
        int month = new Date().getMonth();

        double count = 0;
        for (Reis trip : alleReizen) {
            if (trip.getDate().getMonth() == month) {
                count += trip.getCO2().getUitstoot();
            }
        }

        return count / 1000;
    }


    public double getOldMonthco2Uitstoot() {
        int month = new Date().getMonth() - 1;

        double count = 0;
        for (Reis trip : alleReizen) {
            if (trip.getDate().getMonth() == month) {
                count += trip.getCO2().getUitstoot();
            }
        }

        return count / 1000;
    }

    public double getMonthpunten() {
        int month = new Date().getMonth();

        double count = 0;
        for (Reis trip : alleReizen) {
            if (trip.getDate().getMonth() == month) {
                count += trip.getPunten();
            }
        }

        return count;
    }

    public void initialiseerGebruiker() {
        //afstandVanWerkInKm eventueel uitrekenen dmv api voor afstand
        this.puntenSaldo = punten.getAantalPunten();
    }

    @Override
    public String getVoornaam() {
        return voornaam;
    }

    @Override
    public String getAchternaam() {
        return achternaam;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public double getCo2Uitstoot() {
        double count = 0;
        for (Reis trip : alleReizen) {
            count += trip.getCO2().getUitstoot();
        }

        return count;
    }

    @Override
    public double getPuntenSaldo() {
        return puntenSaldo;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getWachtwoord() {
        return wachtwoord;
    }

    @Override
    public Punten getPunten() {
        return punten;
    }

    @Override
    public boolean isAdmin() {
        return false;
    }

    @Override
    public ArrayList<Reis> getAlleReizen() {
        return alleReizen;
    }

    @Override
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
}
