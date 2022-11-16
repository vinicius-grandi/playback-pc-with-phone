package com.playpackpc.demo;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;


public class HelloApplication {
    static {
        new JFXPanel();
    }
    private static MediaPlayer mediaPlayer;
    public static void playSound(String sound){
        final Media media = new Media(sound);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setOnEndOfMedia(() -> {
            System.exit(0);
        });
        mediaPlayer.play();
    }

    public static void main(String[] args) {
        var file = Paths.get("C:/Users/breno/Downloads/sample.mp3");
        playSound(file.toUri().toString());
    }
}