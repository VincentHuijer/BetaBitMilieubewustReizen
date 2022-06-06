package hhs.proj2_klas6_groep6d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Scorebord {//Deze code is niet van toepassing omdat we in javafx een andere manier hebben gevonden om een scorebord te laten zien.
    private ArrayList<Persoon> scorebord = new ArrayList<>();
    public Scorebord(){
        initialiseerScoreBord();
    }

    public void initialiseerScoreBord(){
        Bedrijf bedrijf = new Bedrijf();
        for(Persoon gebruiker : bedrijf.getGebruikers()){
            add(gebruiker);
        }
    }
    public void add(Persoon gebruiker){
        scorebord.add(gebruiker);
    }

    public ArrayList<Persoon> orderByPoints(){
        Comparator<Persoon> comparator = Comparator.comparingDouble(Persoon::getPuntenSaldo);
        scorebord.sort(comparator);
        return scorebord;
    }

    public ArrayList<Persoon> orderByCo2Uitstoot(){
        Comparator<Persoon> comparator = Comparator.comparingDouble(Persoon :: getCo2Uitstoot);
        scorebord.sort(comparator);
        return scorebord;
    }

    public void printScorebord(ArrayList<Gebruiker> toPrint){
        //Print scorebord in javafx
    }

}
