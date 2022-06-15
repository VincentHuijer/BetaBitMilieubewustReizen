package hhs.proj2_klas6_groep6d;
import hhs.controllersAndScreens.LoginController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class LoginTest {
    @Test
    public void loginTest(){
        Gebruikers gebruikers = new Gebruikers();
        Gebruiker gebruiker = new Gebruiker("Username", "Password", "Test", "Test", -1);
        gebruikers.addGebruiker(gebruiker);
        LoginController login = new LoginController();
        // Condition/Decision Coverage
        Assertions.assertTrue(login.auth(gebruiker, "Password", "Username", -1)); // C=111 D=1
        Assertions.assertFalse(login.auth(gebruiker, "FoutPassword", "FouteUsername", -2)); //C=000 D=0

        // Condition Coverage
        Assertions.assertFalse(login.auth(gebruiker, "Password", "Username", -2)); // C=110 D=0
        Assertions.assertFalse(login.auth(gebruiker, "FoutPassword", "FouteUsername", -1)); // C=001 D=0

        // Decision Coverage
        Assertions.assertTrue(login.auth(gebruiker, "Password", "Username", -1)); // C=111 D=1
        Assertions.assertFalse(login.auth(gebruiker, "FoutPassword", "Username", -1)); //C=011 D=0

        //Multiple Coverage
        Assertions.assertTrue(login.auth(gebruiker, "Password", "Username", -1)); // C=111 D=1
        Assertions.assertFalse(login.auth(gebruiker, "Password", "Username", -2)); //C=110 D=0
        Assertions.assertFalse(login.auth(gebruiker, "Password", "FouteUsername", -1)); //C=101 D=0
        Assertions.assertFalse(login.auth(gebruiker, "FoutPassword", "Username", -1)); //C=011 D=0
        Assertions.assertFalse(login.auth(gebruiker, "Password", "FouteUsername", -2)); //C=100 D=0
        Assertions.assertFalse(login.auth(gebruiker, "FoutPassword", "FouteUsername", -1)); //C=001 D=0
        Assertions.assertFalse(login.auth(gebruiker, "FoutPassword", "FouteUsername", -2)); //C=000 D=0
        Assertions.assertFalse(login.auth(gebruiker, "FoutPassword", "Username", -2)); //C=010 D=0

    }
}
