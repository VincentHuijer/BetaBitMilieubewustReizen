package hhs.proj2_klas6_groep6d;

public class Admin extends Persoon {

    public Admin(String username, String wachtwoord, String voornaam, String achternaam, int id) {
        super(username, wachtwoord, voornaam, achternaam, id);
    }

    @Override
    public String getVoornaam() {
        return voornaam;
    }

    @Override
    public String getAchternaam() {
        return achternaam;
    }

    @Override
    public String getWachtwoord() {
        return wachtwoord;
    }

    @Override
    public String getUsername() {
        return username;
    }


    @Override
    public boolean isAdmin(){
        return true;
    }


    }
