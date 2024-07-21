package com.kaique.music.model;

//User entity for responses,
public class CappedUserResponse {

    public CappedUserResponse(User source) {
        this.name = source.getName();
        this.surname = source.getSurname();
        this.username = source.getUsername();
    }
    private String name;
    private String surname;
    private String username;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }
}
