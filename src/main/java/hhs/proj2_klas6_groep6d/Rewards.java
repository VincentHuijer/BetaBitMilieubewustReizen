package hhs.proj2_klas6_groep6d;

import java.util.ArrayList;

public final class Rewards { //beloningen kunnen verkregen worden door het uitgeven van punten.
    private final String naam;
    private final String beschrijving;
    private final int rewardID;
    private final double prijsInPunten;

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


}