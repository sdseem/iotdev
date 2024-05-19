package com.example.task7source;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SimpleController {
    private final UsersRepository repository;

    public SimpleController(UsersRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/load-user")
    public ResponseEntity<Map<String, String>> loadUserData(@RequestParam("user_id") String userId) {
        Map<String, String> response = new HashMap<>();
        response.put("data", repository.getUserData(userId));
        return ResponseEntity.ok(response);
    }
}
