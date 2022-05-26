package hhs.proj2_klas6_groep6d;

import java.util.ArrayList;

public final class Rewards {
    private String naam;
    private String beschrijving;
    private int rewardID;
    private double prijsInPunten;

    public Rewards(String naam, String beschrijving, int rewardID, double prijsInPunten) {

        this.naam = naam;
        this.beschrijving = beschrijving;
        this.rewardID = rewardID;
        this.prijsInPunten = prijsInPunten;
    }

    public String getNaam() {
        return naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public int getRewardID() {
        return rewardID;
    }

    public double getPunten() {
        return prijsInPunten;
    }

    public void select(Gebruiker gebruiker){
        Punten puntenGebruiker = gebruiker.getPunten();
        if(puntenGebruiker.getAantalPunten() >= prijsInPunten){
            puntenGebruiker.removePunten(prijsInPunten);
            //Iets toevoegen om te laten weten dat de transactie is gelukt.
        }
        else{
            //Gebruiker laten weten dat hij/zij niet genoeg punten heeft.
        }
    }

}