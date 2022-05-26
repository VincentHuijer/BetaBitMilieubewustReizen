package hhs.proj2_klas6_groep6d;

public class Admin extends Gebruiker{
    public Admin(String username, String wachtwoord, String voornaam, String achternaam) {
        super(username, wachtwoord, voornaam, achternaam);
    }

    @Override
    public boolean isAdmin() {
        return true;
    }
}
