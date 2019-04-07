package com.gmail.rebel249.repository;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface RepositoryModule {
    List<String> saveFile(File file) throws FileNotFoundException;
}
