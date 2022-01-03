module com.gamerpg.gamerpg {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.gamerpg to javafx.fxml;
    exports com.gamerpg;
}