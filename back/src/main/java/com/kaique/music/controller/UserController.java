package com.kaique.music.controller;

import com.kaique.music.model.CappedUserResponse;
import com.kaique.music.model.ModifyUserBody;
import com.kaique.music.model.User;
import com.kaique.music.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;


@RestController
@RequestMapping({"/user"})
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/{id}")
    public ResponseEntity<CappedUserResponse> showUser(@PathVariable String id){
        UUID uid = UUID.fromString(id);
        System.out.println(uid);
        return ResponseEntity.ok(new CappedUserResponse(this.userService.getUserById(uid)));
    }

    @PostMapping("/mod/{id}")
    public void modifyUser(@PathVariable UUID id, @RequestBody ModifyUserBody body) {
        this.userService.modifyUser(id, body.field, body.value);
    }

    @GetMapping("/sample-user")
    public String newProduct(Model model) {
        userService.saveUser(new User("teste","da silva","teste.silva","testedasilva@gmail.com", "ansjkdbnjaskzxk!21"));
        return "User criado";
    }
    
}
