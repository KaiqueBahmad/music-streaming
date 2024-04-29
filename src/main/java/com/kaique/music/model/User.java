package com.kaique.music.model;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.UUID;

@Table(name = "users")
@Entity
public class User {
    public User() {}
    public User(String name, String surname, String username, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String surname;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    private ArrayList<UUID> playlistIDs = new ArrayList<>();

    public void addPlaylist(UUID uuid) {
        if (!playlistIDs.contains(uuid)) {
            playlistIDs.add(uuid);
        }
    }

    public void blankId() {
        this.id = null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean havePlaylist(UUID id) {
        return this.playlistIDs.contains(id);
    }

    public void removePLaylist(UUID id) {
        if (this.playlistIDs.contains(id)) {
            this.playlistIDs.remove(id);
        }
    }
}
