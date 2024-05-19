package com.example.task345;

import java.io.IOException;

public interface StorageService {
    String getJson();

    String saveAsObject(String text) throws IOException;
}
