module com.playpackpc.desktop_playbackpc {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.swing;
    requires org.json;

    opens com.playpackpc.desktop_playbackpc to javafx.fxml;
    exports com.playpackpc.desktop_playbackpc;
}