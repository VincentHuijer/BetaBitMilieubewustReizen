package hhs.proj2_klas6_groep6d;

import java.util.ArrayList;


public class GebruikersOpslag {
    private static final ArrayList<Persoon> gebruikers = new ArrayList<>();

    public GebruikersOpslag() {
        if (gebruikers.size() == 0) {
            gebruikers.add(new Gebruiker("1", "1", "1", "1", 1));
            gebruikers.add(new Admin("admin", "admin", "admin", "admin", 0)); //Admin accounts kunnen niet registreren. Ze moeten als het waren door iemand hoger in het bedrijf toegevoegd worden voor veiligheidsregelen.
        }
    }

    public ArrayList<Persoon> getGebruikers() {
        return gebruikers;
    }

    public void addGebruiker(Persoon gebruiker) {
        gebruikers.add(gebruiker);
    }

    public void removeGebruiker(Persoon gebruiker) {
        for (int i = 0; i < gebruikers.size(); i++) {
            if (gebruiker.getId() == gebruikers.get(i).getId()) {
                gebruikers.remove(i);
            }
        }
    }
}
