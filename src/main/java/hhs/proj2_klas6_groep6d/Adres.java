package hhs.proj2_klas6_groep6d;

public class Adres {
    private String straatNaam;
    private int huisNummer;
    private String postcode;

    public Adres(String straatNaam, int huisNummer, String postcode){
        this.straatNaam = straatNaam;
        this.huisNummer = huisNummer;
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return this.straatNaam + " " + this.huisNummer + " " + this.postcode;
    }
}
