package com.kaique.music.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.UUID;

@Table(name = "playlist")
@Entity
public class Playlist {
    public Playlist() {}
    public Playlist(String nome) {
        this.name = nome;
        this.length = 0;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String name;
    private float length;
    private ArrayList<UUID> musicIDs = new ArrayList<>();
    private String coverURL;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public ArrayList<UUID> getMusicIDs() {
        ArrayList<UUID> clone = (ArrayList<UUID>) musicIDs.clone();
        return clone;

    }

    public void addMusic(UUID musicID) {
        if (!this.musicIDs.contains(musicID)) {
            this.musicIDs.add(musicID);
        }
    }

    public void removeMusic(UUID musicID) {
        this.musicIDs.remove(musicID);
    }

    public String getCoverURL() {
        return coverURL;
    }

    public void setCoverURL(String coverURL) {
        this.coverURL = coverURL;
    }
}
