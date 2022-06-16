package hhs.proj2_klas6_groep6d;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RewardsTest {

    @Test
    public void testGetNaam() {
        Rewards rewards = new Rewards("testRewardNaam", "testBeschrijving",1111,66.67);

        assertEquals("testRewardNaam", rewards.getNaam());
    }

    @Test
    public void testGetBeschrijving() {
        Rewards rewards = new Rewards("testRewardNaam", "testBeschrijving",1111,66.67);
        assertEquals("testBeschrijving", rewards.getBeschrijving());

    }

    @Test
    public void testGetRewardID() {
        Rewards rewards = new Rewards("testRewardNaam", "testBeschrijving",1111,66.67);
        assertEquals(1111,rewards.getRewardID());
    }

    @Test
    public void testGetPunten() {
        Rewards rewards = new Rewards("testRewardNaam", "testBeschrijving",1111,66.67);
        assertEquals(66.67, rewards.getPunten());
    }
}