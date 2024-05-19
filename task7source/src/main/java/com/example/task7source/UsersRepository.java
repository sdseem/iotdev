package com.example.task7source;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UsersRepository {
    private final Map<String, String> usersData = new HashMap<>();

    public UsersRepository() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        Map<String, String> map3 = new HashMap<>();
        map1.put("name", "John");
        map1.put("age", "35");
        map2.put("name", "Ann");
        map2.put("age", "30");
        map3.put("name", "Victor");
        map3.put("age", "25");
        String s1 = ow.writeValueAsString(map1);
        String s2 = ow.writeValueAsString(map2);
        String s3 = ow.writeValueAsString(map3);
        usersData.put("1", s1);
        usersData.put("2", s2);
        usersData.put("3", s3);
    }

    public String getUserData(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Null value of argument not allowed");
        }
        return usersData.get(key);
    }
}
