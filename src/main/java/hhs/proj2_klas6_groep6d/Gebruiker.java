package hhs.proj2_klas6_groep6d;

public class Gebruiker {
    private String voornaam;
    private String achternaam;
    private Adres adres;
    private Id id;
    private double co2Uitstoot;
    private int totaalAantalVerdiendePunten;
    private int puntenSaldo;
    private double afstandVanWerkInKm;

    public Gebruiker(String voornaam, String achternaam, Adres adres){
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.adres = adres;
        initialiseerGebruiker();
    }

    public void initialiseerGebruiker(){
        this.id = new Id();
        //afstandVanWerkInKm uitrekenen dmv api
        this.puntenSaldo = 0;
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

    public Id getId() {
        return id;
    }

    public double getAfstandVanWerkInKm() {
        return afstandVanWerkInKm;
    }

    public double getCo2Uitstoot() {
        return co2Uitstoot;
    }

    public int getPuntenSaldo() {
        return puntenSaldo;
    }

    public int getTotaalAantalVerdiendePunten() {
        return totaalAantalVerdiendePunten;
    }
}
