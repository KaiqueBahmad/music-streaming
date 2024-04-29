package com.kaique.music.service;

import com.kaique.music.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService  {
    Iterable<User> listAllUser();
    User getUserById(UUID id);

    boolean idIsAvaliable(UUID id);
    Optional<User> getUserByUsername(String username);
    User saveUser(User user);
    void modifyUser(UUID id,String field, String value);
    void deleteUser(UUID id);
}
