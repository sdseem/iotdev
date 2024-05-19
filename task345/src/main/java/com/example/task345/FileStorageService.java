package com.example.task345;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;

@Service("fileStorageService")
public class FileStorageService implements StorageService {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public String getJson() {
        try (BufferedReader reader = new BufferedReader(new FileReader("temp.txt"))) {
            String content = reader.lines().collect(Collectors.joining());
            if (content.isEmpty()) {
                return "";
            } else {
                return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapper.readTree(content));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String saveAsObject(String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("temp.txt", true))) {
            JsonNode node = mapper.readTree(text);
            String justifiedJson = node.isEmpty() ? "" : mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);
            Files.newBufferedWriter(Path.of("temp.txt")).close();
            writer.write(justifiedJson);
            return justifiedJson;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
