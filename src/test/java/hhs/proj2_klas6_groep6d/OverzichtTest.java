package hhs.proj2_klas6_groep6d;
import hhs.controllersAndScreens.OverzichtController;
import hhs.controllersAndScreens.Stats;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static java.lang.String.valueOf;

public class OverzichtTest {
    @Test
    public void testOverzichtCO2() {
        //Test of de gegevens op het overzichtscherm juist zijn.
        Date date = new Date();
        int lastMonth = date.getMonth();
        int currentMonth = lastMonth + 1;


        Gebruiker Guan = new Gebruiker("Guan","GUAN1234","Guan","Juan",7);//Gebruiker "Guan" wordt toegevoegd en krijgt een reis om de CO2 uitstoot te meten
        int km = 100;
        String vervoersMiddel = "Auto";
        boolean elektrisch = false;
        double punten = BerekenPunten.berekenAantalPuntenZakelijkVerkeer(km, vervoersMiddel, elektrisch);
        Reis reis = new Reis(new Date(), punten, km, vervoersMiddel, Guan, elektrisch);
        Guan.getAlleReizen().add(reis);

        OverzichtController overzicht = new OverzichtController();
        ObservableList<Persoon> sb = FXCollections.observableArrayList();
        Gebruikers gebruikers = new Gebruikers();
        gebruikers.addGebruiker(Guan);
        for(int i = 0; i< gebruikers.getGebruikers().size(); i++){
            sb.add(gebruikers.getGebruikers().get(i));
        }
        Stats currentMonthStats = overzicht.getMonthStats(currentMonth, sb);

        Assertions.assertEquals(22400.0, currentMonthStats.uitstoot);//expected is 22400.0 omdat dit de uitstoot is van de hierboven toegevoegde reis en er geen andere reis is
    }
    @Test
    public void testOverzichtCO2Leeg() {
        //Test of een bepaalde Reis waarbij geen CO2 wordt uitgestoten juist weergegeven wordt.
        Date date = new Date();
        int lastMonth = date.getMonth();
        int currentMonth = lastMonth + 1;

        OverzichtController overzicht = new OverzichtController();
        ObservableList<Persoon> sb = FXCollections.observableArrayList();
        Gebruikers gebruikers = new Gebruikers();
        for(int i = 0; i< gebruikers.getGebruikers().size(); i++){
            sb.add(gebruikers.getGebruikers().get(i));
        }
        Stats currentMonthStats = overzicht.getMonthStats(currentMonth, sb);

        Assertions.assertEquals(0, ((Stats) currentMonthStats).uitstoot);//expected is 0 omdat er geen gebruiker is met een reis waar CO2 bij wordt uitgestoten
    }
}
