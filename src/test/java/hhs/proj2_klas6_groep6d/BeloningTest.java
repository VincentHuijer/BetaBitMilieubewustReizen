package hhs.proj2_klas6_groep6d;

import hhs.Controllers.BeloningController;
import hhs.Schermen.BeloningScherm;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;


import java.util.ArrayList;


public class BeloningTest {

    @Test
    public void BeloningScherm(){
        BeloningScherm beloningScherm = new BeloningScherm();
        Gebruiker gebruiker = new Gebruiker("test", "test", "test", "test");
        beloningScherm.setLoggedIn(gebruiker);
        BeloningController controller = new BeloningController();
        RewardsList rewards = beloningScherm.getRewardsList();
        ArrayList<Rewards> alleRewards = rewards.getRewardsLijst();
        alleRewards.add(new Rewards("test", "test", 0, 100.0)); // 100 is de prijs in punten.
        Assertions.assertFalse(controller.claimRewardCheck(1)); //Reward nummer 1
        gebruiker.getPunten().addPunten(100);
        Assertions.assertTrue(controller.claimRewardCheck(1)); // Reward nummer 1
    }
}
