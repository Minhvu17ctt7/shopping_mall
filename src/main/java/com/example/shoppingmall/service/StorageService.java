package com.example.shoppingmall.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

public interface StorageService {

    String getStoredFilename(MultipartFile file, String id);

    Path getRootLocation();

    void setRootLocation(Path rootLocation);

    void store(MultipartFile file, String storedFileName);

    Resource loadAsResource(String filename);

    Path load(String filename);

    void delete(String storedFilename) throws IOException;

//    void init();
}
