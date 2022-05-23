package hhs.proj2_klas6_groep6d;

public class Gebruiker {
    private static int currentId = 0;
    private String voornaam;
    private String achternaam;
    private String username;
    private String wachtwoord;
    private Adres adres;
    private int id;
    private double co2Uitstoot;
    private int totaalAantalVerdiendePunten;
    private Punten punten;
    private double puntenSaldo;
    private double afstandVanWerkInKm;

    public Gebruiker(String username, String wachtwoord, String voornaam, String achternaam, Adres adres){
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.adres = adres;
        this.username = username;
        this.wachtwoord = wachtwoord;
        initialiseerGebruiker();
    }

    public void initialiseerGebruiker(){
        this.id = generateId();
        //afstandVanWerkInKm uitrekenen dmv api
        this.puntenSaldo = punten.getAantalPunten();
        this.co2Uitstoot = 0;
    }

    public Adres getAdres() {
        return adres;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public int getId() {
        return id;
    }

    public double getAfstandVanWerkInKm() {
        return afstandVanWerkInKm;
    }

    public double getCo2Uitstoot() {
        return co2Uitstoot;
    }

    public double getPuntenSaldo() {
        return puntenSaldo;
    }

    public int getTotaalAantalVerdiendePunten() {
        return totaalAantalVerdiendePunten;
    }

    public String getUsername() {
        return username;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public Punten getPunten() {
        return punten;
    }

    public int generateId(){
        int id = currentId;
        currentId++;
        return id;
    }
}
