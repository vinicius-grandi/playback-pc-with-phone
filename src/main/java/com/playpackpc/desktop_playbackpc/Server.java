package com.playpackpc.desktop_playbackpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    // declaring required variables
    private static ServerSocket serverSocket;
    private static boolean isServerEnded = true;

    public static void main(String[] args) {

        try {
            // creating a new ServerSocket at port 4444
            serverSocket = new ServerSocket(4444);

        } catch (IOException e) {
            System.out.println("Could not listen on port: 4444");
        }

        System.out.println("Server started. Listening to the port 4444");

        while (isServerEnded) {
            try {

                Socket clientSocket = serverSocket.accept();

                // get the input stream from socket, which will have
                // the message from the clients
                InputStreamReader inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String message = bufferedReader.readLine();
                String[] commandTuple = message.split("\\|");

                String action = commandTuple[0].toLowerCase();

                Runnable closeAll = () -> {
                    try {
                        inputStreamReader.close();
                        clientSocket.close();
                    } catch (IOException e) {
                        System.out.println("Problem in message reading");
                    }
                };

                switch (action) {
                    case "over" -> {
                        isServerEnded = false;
                        serverSocket.close();
                        closeAll.run();
                        System.exit(0);
                    }
                    case "play" -> {
                        AudioPlayer.getSoundAndPlay();
                        closeAll.run();
                    }
                    case "pause" -> {
                        AudioPlayer.pause();
                        closeAll.run();
                    }
                    case "volumeup" -> {
                        AudioPlayer.volumeUp();
                        closeAll.run();
                    }
                    case "volumedown" -> {
                        AudioPlayer.volumeDown();
                        closeAll.run();
                    }
                    default -> closeAll.run();
                }
                closeAll.run();
            } catch (IOException ex) {
                System.out.println("Problem in message reading");
            }
        }
    }
}
