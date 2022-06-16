package hhs.proj2_klas6_groep6d;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RewardsTest {

    @Test
    public void testGetNaam() {
        //Test of naam goed wordt geinitialiseerd bij aanmaken reward object.
        Rewards rewards = new Rewards("testRewardNaam", "testBeschrijving",1111,66.67);

        assertEquals("testRewardNaam", rewards.getNaam());
    }

    @Test
    public void testGetBeschrijving() {
        //Test of beschrijving goed wordt geinitialiseerd bij aanmaken reward object.
        Rewards rewards = new Rewards("testRewardNaam", "testBeschrijving",1111,66.67);
        assertEquals("testBeschrijving", rewards.getBeschrijving());

    }

    @Test
    public void testGetRewardID() {
        //Test of ID goed wordt geinitialiseerd bij aanmaken reward object.
        Rewards rewards = new Rewards("testRewardNaam", "testBeschrijving",1111,66.67);
        assertEquals(1111,rewards.getRewardID());
    }

    @Test
    public void testGetPunten() {
        //Test of prijs goed wordt geinitialiseerd bij aanmaken reward object.
        Rewards rewards = new Rewards("testRewardNaam", "testBeschrijving",1111,66.67);
        assertEquals(66.67, rewards.getPunten());
    }
}