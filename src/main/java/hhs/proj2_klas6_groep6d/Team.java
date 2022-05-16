package hhs.proj2_klas6_groep6d;

import java.util.ArrayList;

public class Team {
    private String teamNaam;
    private ArrayList<Gebruiker> teamLeden = new ArrayList<>();

    public Team(String teamNaam, ArrayList<Gebruiker> teamLeden){
        this.teamLeden = teamLeden;
        this.teamNaam = teamNaam;
    }

    public ArrayList<Gebruiker> getTeamLeden() {
        return teamLeden;
    }

    public String getTeamNaam() {
        return teamNaam;
    }
}
