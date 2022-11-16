module com.playpackpc.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.swing;

    opens com.playpackpc.demo to javafx.fxml;
    exports com.playpackpc.demo;
}