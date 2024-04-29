package com.kaique.music.model;

import java.util.UUID;

public class MusicRegister {
    private UUID id;
    private String nome;
    private UUID[] authorIDs;

    public String getNome() {
        return nome;
    }
    public UUID getId() {
        return id;
    }

    public UUID[] getAuthorIDs() {
        return authorIDs;
    }
}
