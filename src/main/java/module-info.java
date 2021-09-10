module ddorcak {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens ddorcak.nekonecneHry.App to javafx.fxml;
    exports ddorcak.nekonecneHry.App;
}
