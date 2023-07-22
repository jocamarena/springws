package com.example.springws.rest;

import com.example.springws.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stubs.com.example.springws.ws.user_service.User;

@RestController
@RequestMapping("/api")
public class DefaultContoller {
    private UserService userService;
    public DefaultContoller(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello World!");
    }
    @GetMapping("/hello/{name}")
    public ResponseEntity<String> helloName(@PathVariable String name){
        return ResponseEntity.ok(String.format("Hello %s!, and enjoy your visit.", name));
    }
    @GetMapping("/user/default")
    public ResponseEntity<User> defaultUser(){
        return ResponseEntity.ok(User.builder()
                .firstname("John")
                .lastname("Doe")
                .age(37)
                .build());
    }
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        User newUser = userService.saveUser(user);
        return ResponseEntity.ok(newUser);
    }
}
