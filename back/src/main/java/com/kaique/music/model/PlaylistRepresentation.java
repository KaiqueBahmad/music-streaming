package com.kaique.music.model;

public class PlaylistRepresentation {

    public PlaylistRepresentation(Playlist source) {
        this.name  = source.getName();
        this.coverURL = source.getCoverURL();
    }

    public PlaylistRepresentation() {

    }
    String name;
    String coverURL;
}
