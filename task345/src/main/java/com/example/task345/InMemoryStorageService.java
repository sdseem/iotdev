package com.example.task345;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service("inMemoryStorageService")
public class InMemoryStorageService implements StorageService {
    private String json = "";

    private ObjectMapper mapper = new ObjectMapper();

    private JsonNode saved;

    public String saveAsObject(String data) {
        try {
            JsonNode node = mapper.readTree(data);
            String jsonData = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);
            saved = node;
            json = jsonData;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return json;
    }

    public String getJson() {
        return json;
    }
}
