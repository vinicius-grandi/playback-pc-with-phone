package com.playpackpc.desktop_playbackpc;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;

import static javafx.scene.media.MediaPlayer.Status.*;


public class AudioPlayer {
    static {
        new JFXPanel();
    }
    private static MediaPlayer mediaPlayer;
    private static MediaPlayer.Status status = STOPPED;

    public static void playSound(String sound){
        Runnable getMedia = () -> {
            final Media media = new Media(sound);
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
        };
        if (status == STOPPED) {
            getMedia.run();
            status = PLAYING;
        } else {
            mediaPlayer.stop();
            getMedia.run();
            status = STOPPED;
        }
    }

    public static void getSoundAndPlay() {
        var file = Paths.get("C:/Users/breno/Downloads/sample.mp3");
        playSound(file.toUri().toString());
    }

    public static void pause() {
        mediaPlayer.pause();
    }

    private static void setVolume(double volume) {
        mediaPlayer.setVolume(mediaPlayer.getVolume() + volume);
    }

    public static void volumeUp() {
        setVolume(+0.1);
    }

    public static void volumeDown() {
        setVolume(-0.1);
    }
}