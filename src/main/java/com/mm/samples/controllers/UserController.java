package com.mm.samples.controllers;

import com.mm.samples.domain.UserEntity;
import com.mm.samples.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class UserController {


    private final UserRepository userRepository;

    public UserController(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/test")
    public List<UserEntity> getUsers() {
        List<UserEntity> users  = userRepository.findAll();
        System.out.println(users);
        return users;
    }

    @GetMapping("/add")
    public UserEntity add() {
        Random r = new Random();
        Integer id = r.nextInt();
        UserEntity user = new UserEntity("Aaaa", "BBBB");
        userRepository.saveAndFlush(user);
//        UserEntity dbUser = userRepository.findById(id).orElse(null);
        return user;
    }
}
