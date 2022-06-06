package hhs.proj2_klas6_groep6d;

import java.util.ArrayList;

public class Gebruiker {
    private static int currentId = 0;
    private ArrayList<Reis> alleReizen = new ArrayList<>();
    private String voornaam;
    private String achternaam;
    private String username;
    private String wachtwoord;
    private Adres adres; // Eventueel later nodig voor API met afstand berekenen
    private int id; // Medewerkers van betabit krijgen vanuit het bedrijf al een id. Dit onderdeel schrappen we misschien nog.
    private double co2Uitstoot;
    private int totaalAantalVerdiendePunten; // Nodig voor scorebord
    private Punten punten = new Punten();
    private double puntenSaldo;
    private double afstandVanWerkInKm; // Eventueel later nodig voor API met afstand berekenen
    private double totaalKm = 0;

    public Gebruiker(String username, String wachtwoord, String voornaam, String achternaam){
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        //this.adres = adres;
        this.username = username;
        this.wachtwoord = wachtwoord;
        initialiseerGebruiker();
    }

    public void initialiseerGebruiker(){
        this.id = generateId();
        //afstandVanWerkInKm eventueel uitrekenen dmv api voor afstand
        this.puntenSaldo = punten.getAantalPunten();
        this.co2Uitstoot = 0; //Hier moet nog een methode voor gemaakt worden.
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
        double count = 0;
        for(Reis trip: alleReizen){
            count += trip.getCO2().getUitstoot();
        }

        return count;
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

    public boolean isAdmin(){
        return false;
    }

    public ArrayList<Reis> getAlleReizen() {
        return alleReizen;
    }
    public void berekenTotaalKM(){
        double sum = 0;
        for(Reis reis : alleReizen){
            sum += reis.getAfstand();
        }
        this.totaalKm = sum;
    }

    public double getTotaalKm() {
        return totaalKm;
    }

    public int generateId(){
        int id = currentId;
        currentId++;
        return id;
    }
}
