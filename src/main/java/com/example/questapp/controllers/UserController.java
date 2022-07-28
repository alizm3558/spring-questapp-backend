package com.example.questapp.controllers;

import com.example.questapp.entities.User;
import com.example.questapp.repos.UserRepository;
import com.example.questapp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")//root endpoint
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping()
    public User createUser(@RequestBody User newUser) {
        return userService.save(newUser);
    }

    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId) {
        //custom expection ekle , bu id olmayabilir
        return userService.getOneUser(userId);
    }

    @PutMapping("/{userId}") //güncelleme
    public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {// newUser: update edilecek olan user
        return userService.updateOneUser(userId,newUser);

    }

    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId) {
        userService.deleteById(userId);
    }


}
