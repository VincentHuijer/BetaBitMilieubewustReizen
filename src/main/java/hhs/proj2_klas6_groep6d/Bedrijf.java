package hhs.proj2_klas6_groep6d;

import java.util.ArrayList;
//TODO Bedrijf is niet een goede naam voor een class die alleen gaat over het toevoegen en verwijderen van gebruikers.
public class Bedrijf {
    private String naam;
    private static ArrayList<Persoon> gebruikers = new ArrayList<>();

    public Bedrijf(){
        if(gebruikers.size() == 0) {
            gebruikers.add(new Gebruiker("1", "1", "1", "1", 1)); //TODO verwijderen in definitieve code.
            gebruikers.add(new Admin("admin", "admin", "admin", "admin", 0)); //Admin accounts kunnen niet registreren. Ze moeten als het waren door iemand hoger in het bedrijf toegevoegd worden voor veiligheidsregelen.
        }
    }

    public String getNaam() {
        return naam;
    }

    public ArrayList<Persoon> getGebruikers() {
        return gebruikers;
    }

    public void addGebruiker(Persoon gebruiker){
        gebruikers.add(gebruiker);
    }

    public void removeGebruiker(Persoon gebruiker){
        for(int i=0; i< gebruikers.size(); i++){
            if (gebruiker.getId() == gebruikers.get(i).getId()){
                gebruikers.remove(i);
            }
        }
    }
}
