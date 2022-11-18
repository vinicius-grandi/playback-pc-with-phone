package com.playpackpc.desktop_playbackpc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class AudioFileExplorer {
    public static JSONObject walk( String path ) {

        File root = new File( path );
        File[] list = root.listFiles();
        JSONObject directoryContent = new JSONObject();
        List<String> directories = new ArrayList<>();
        List<String> audios = new ArrayList<>();

        for ( File f : list ) {
            if ( f.isDirectory() ) {
                directories.add(f.getPath());
            }
            else {
                String filePath = f.getPath();
                if (filePath.endsWith(".mp3"))
                    audios.add(filePath);
            }
        }
        directoryContent.put("directories", directories);
        directoryContent.put("audios", audios);

        return directoryContent;
    }

    public static JSONObject root() {
        return walk("c:\\" );
    }
}
