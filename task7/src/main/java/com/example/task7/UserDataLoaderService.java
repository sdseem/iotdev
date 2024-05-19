package com.example.task7;

import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;

@Service
public class UserDataLoaderService {
    public String loadData(String userId) {
        try (HttpClient client = HttpClient.newHttpClient()) {
            String requestPath = "http://localhost:8094/load-user?user_id=" + userId.replace(" ", "");
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(requestPath)).GET()
                    .build();
            String result = client
                    .sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .get();
            return result;
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
