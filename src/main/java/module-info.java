module com.playpackpc.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.swing;

    opens com.playpackpc.desktop_playbackpc to javafx.fxml;
    exports com.playpackpc.desktop_playbackpc;
}