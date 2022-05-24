package hhs.proj2_klas6_groep6d;

import java.util.ArrayList;

public class Bedrijf {
    private String naam;
    private static ArrayList<Gebruiker> gebruikers = new ArrayList<>();

    public Bedrijf(){
        gebruikers.add(new Gebruiker("1", "1", "1", "1"));
    }

    public String getNaam() {
        return naam;
    }

    public ArrayList<Gebruiker> getGebruikers() {
        return gebruikers;
    }

    public void addGebruiker(Gebruiker gebruiker){
        gebruikers.add(gebruiker);
    }

    public void removeGebruiker(Gebruiker gebruiker){
        for(int i=0; i< gebruikers.size(); i++){
            if (gebruiker.getId() == gebruikers.get(i).getId()){
                gebruikers.remove(i);
            }
        }
    }
}
