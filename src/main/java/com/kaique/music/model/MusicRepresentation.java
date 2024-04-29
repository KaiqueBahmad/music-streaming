package com.kaique.music.model;

import java.nio.file.Path;

public class MusicRepresentation {

    public MusicRepresentation(Music source) {
        this.name  = source.getName();
        this.coverURL = source.getCoverURL();
    }

    public MusicRepresentation() {

    }
    String name;
    String coverURL;
}
