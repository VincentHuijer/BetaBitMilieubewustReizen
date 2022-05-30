package hhs.proj2_klas6_groep6d;

import java.util.ArrayList;

public class RewardsList {

    public  ArrayList<Rewards> rewardsLijst = new ArrayList<>();
    public void addRewards(ArrayList<Rewards> toAdd) {
        for(Rewards reward : toAdd){
            rewardsLijst.add(reward);
        }
    }

    public void removeRewards(int id) { //verdere mogelijkheid zou zijn om een naam mee te geven. Zou voor een gebruiker toepasselijker zijn.
        for(int i = 0; i < rewardsLijst.size();i++){
            if(rewardsLijst.get(i).getRewardID() == (id)){
                rewardsLijst.remove(i);
            }
        }
    }

    public void printRewardLijst() {
        for (int i = 0; i < rewardsLijst.size(); i++) {
            System.out.println(rewardsLijst.get(i).getNaam());
        }
    }

    public ArrayList<Rewards> getRewardsLijst() {
        return rewardsLijst;
    }
}