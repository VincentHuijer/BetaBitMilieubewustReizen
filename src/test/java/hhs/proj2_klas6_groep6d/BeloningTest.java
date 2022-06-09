package hhs.proj2_klas6_groep6d;

import hhs.Controllers.BeloningController;
import hhs.Schermen.BeloningScherm;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;


import java.util.ArrayList;


public class BeloningTest {

    @Test
    public void testRewardClaimen(){
        BeloningScherm beloningScherm = new BeloningScherm();
        Gebruiker gebruiker = new Gebruiker("test", "test", "test", "test", -4);
        beloningScherm.setLoggedIn(gebruiker);
        BeloningController controller = new BeloningController();
        RewardsList rewards = beloningScherm.getRewardsList();
        ArrayList<Rewards> alleRewards = rewards.getRewardsLijst();
        alleRewards.add(new Rewards("test", "test", 0, 100.0)); // 100 is de prijs in punten.
        alleRewards.add(new Rewards("test2", "test2", 1, 200.0));
        Punten puntenGebruiker = gebruiker.getPunten();
        Assertions.assertFalse(controller.claimRewardCheck(1)); //Reward nummer 1
        Assertions.assertFalse(controller.claimRewardCheck(2)); //Reward nummer 2
        puntenGebruiker.addPunten(100);
        Assertions.assertEquals(100, puntenGebruiker.getAantalPunten());
        Assertions.assertTrue(controller.claimRewardCheck(1)); // Reward nummer 1
        Assertions.assertFalse(controller.claimRewardCheck(2));// Reward nummer 2
        puntenGebruiker.removePunten(100);
        Assertions.assertEquals(0, puntenGebruiker.getAantalPunten());
        puntenGebruiker.addPunten(200);
        Assertions.assertTrue(controller.claimRewardCheck(1)); // Reward nummer 1
        Assertions.assertTrue(controller.claimRewardCheck(2)); // Reward nummer 2
        Assertions.assertEquals(200, puntenGebruiker.getAantalPunten());
    }
}
