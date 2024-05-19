package com.example.task7;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SimpleController {

    private final UserDataLoaderService service;

    public SimpleController(UserDataLoaderService service) {
        this.service = service;
    }

    @GetMapping("/user-info")
    public ResponseEntity<Map<String, String>> getInfo(@RequestParam("user_id") String userId) {
        Map<String, String> response = new HashMap<>();
        response.put("data", service.loadData(userId));
        return ResponseEntity.ok(response);
    }
}
