module com.example.proj2_klas6_groep6d {
    requires javafx.controls;
    requires javafx.fxml;


    opens hhs.proj2_klas6_groep6d to javafx.fxml;
    exports hhs.proj2_klas6_groep6d;
    exports hhs.Controllers;
    opens hhs.Controllers to javafx.fxml;
    exports hhs.Schermen;
    opens hhs.Schermen to javafx.fxml;
}