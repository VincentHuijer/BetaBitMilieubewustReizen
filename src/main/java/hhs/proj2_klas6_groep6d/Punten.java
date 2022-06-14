package hhs.proj2_klas6_groep6d;

import java.math.RoundingMode;

public class Punten { //deze class is verantwoordelijk voor het ophalen, toevoegen en verwijderen van punten.
    private double aantalPunten;

    public double getAantalPunten() {
        return aantalPunten;
    }

    public void addPunten(double aantalPunten) {
        this.aantalPunten += aantalPunten;
    }

    public void removePunten(double aantalPunten) {
        this.aantalPunten -= aantalPunten;
    }

    @Override
    public String toString() {
        return aantalPunten + "";
    }
}
