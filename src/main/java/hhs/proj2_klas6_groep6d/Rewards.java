package hhs.proj2_klas6_groep6d;

import java.util.ArrayList;

public final class Rewards {
    private String naam;
    private String beschrijving;
    private int rewardID;
    private int punten;

    public Rewards(String naam, String beschrijving, int rewardID, int punten) {

        this.naam = naam;
        this.beschrijving = beschrijving;
        this.rewardID = rewardID;
        this.punten = punten;
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

    public int getPunten() {
        return punten;
    }

}