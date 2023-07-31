module com.example.idm {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.idm to javafx.fxml;
    exports com.example.idm;
}