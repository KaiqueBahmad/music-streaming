package com.kaique.music.service;

import com.kaique.music.model.User;
import com.kaique.music.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.Override;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl {
    @Autowired
    private UserRepository userRepository;

    
    public Iterable<User> listAllUser() {
        return userRepository.findAll();
    }

    
    public User getUserById(UUID id) {
        return userRepository.findById(id).get();
    }
    public Optional<User> getUserByUsername(String name){
        return userRepository.findByUsername(name);
    }

    
    public boolean idIsAvaliable(UUID id) {
        if (id == null) {
            return false;
        }
        return userRepository.findById(id).isEmpty();
    }

    
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    
    public void modifyUser(UUID id,String field, String value) {
        if (field.equals("name")) {
            User user = userRepository.findById(id).get();
            user.setName(value);
            userRepository.save(user);
        }
    }


    
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
