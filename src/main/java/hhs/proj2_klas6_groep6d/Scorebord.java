package hhs.proj2_klas6_groep6d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Scorebord {
    private ArrayList<Gebruiker> scorebord = new ArrayList<>();
    public Scorebord(){
        initialiseerScoreBord();
    }

    public void initialiseerScoreBord(){
        for(Gebruiker gebruiker : Main.bedrijf.getGebruikers()){
            add(gebruiker);
        }
    }
    public void add(Gebruiker gebruiker){
        scorebord.add(gebruiker);
    }

    public ArrayList<Gebruiker> orderByPoints(){
        Comparator<Gebruiker> comparator = Comparator.comparingDouble(Gebruiker::getPuntenSaldo);
        scorebord.sort(comparator);
        return scorebord;
    }

    public ArrayList<Gebruiker> orderByCo2Uitstoot(){
        Comparator<Gebruiker> comparator = Comparator.comparingDouble(Gebruiker :: getCo2Uitstoot);
        scorebord.sort(comparator);
        return scorebord;
    }

    public void printScorebord(ArrayList<Gebruiker> toPrint){
        //Print scorebord in javafx
    }

}
