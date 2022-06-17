package hhs.proj2_klas6_groep6d;

import java.util.ArrayList;

public class RewardsList { //Bevat de lijst van beloningen. Nieuwe beloningen kunnen alleen toegevoegd worden door admins.

    public ArrayList<Rewards> rewardsLijst = new ArrayList<>();

    public ArrayList<Rewards> getRewardsLijst() {
        return rewardsLijst;
    }
}