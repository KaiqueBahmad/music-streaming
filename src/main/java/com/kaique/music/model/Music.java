package com.kaique.music.model;


import jakarta.persistence.*;

import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

@Table(name = "musics")
@Entity
public class Music {
    public Music() {

    }

    public Music(String name, String[] authorIDS, String coverURL) {
        this.name = name;
        this.authorIDS.addAll(Arrays.asList(authorIDS));
        this.coverURL = coverURL;
    }

    //    public Music(MusicRegister newMusicReq) {
//        this.id = newMusicReq.getId();
//        this.name = newMusicReq.getNome();
//        this.authorIDS.addAll(Arrays.asList(newMusicReq.getAuthorIDs()));
//    }
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private ArrayList<String> authorIDS = new ArrayList<>();
    private String coverURL;
    private Long views = 0L;

    public UUID getId() {
        return id;
    }
    public void blankId() {
        this.id = null;
    }

    public String getCoverURL() {
        return coverURL;
    }

    public void setCoverURL(String coverURL) {
        this.coverURL = coverURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
