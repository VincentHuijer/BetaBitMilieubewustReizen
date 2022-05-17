package hhs.proj2_klas6_groep6d;

import java.util.ArrayList;

public class Bedrijf {
    private String naam;
    private ArrayList<Team> teams = new ArrayList<>();

    public Bedrijf(String naam, ArrayList<Team> teams){
        this.naam = naam;
        this.teams = teams;
    }

    public String getNaam() {
        return naam;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void addTeams(Team team){
        teams.add(team);
    }
}
