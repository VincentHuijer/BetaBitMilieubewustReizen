package hhs.proj2_klas6_groep6d;

public class Id {
    private static int currentId = 0;
    private int idNummer;
    public Id(){
        generateId();
    }
    public void generateId(){
        int id = currentId;
        currentId++;
        this.idNummer = id;
    }

    public int getIdNummer() {
        return idNummer;
    }
}
