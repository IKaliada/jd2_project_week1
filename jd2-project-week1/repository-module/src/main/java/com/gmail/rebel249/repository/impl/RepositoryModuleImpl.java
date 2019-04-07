package com.gmail.rebel249.repository.impl;

import com.gmail.rebel249.repository.RepositoryModule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryModuleImpl implements RepositoryModule {
    private static final Logger logger = LogManager.getLogger(RepositoryModule.class);
    @Override
    public List<String> saveFile(File file) {
        List<String> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                    list.add(line);
            }
        } catch (IOException e) {
            logger.info("File not found " + e.getMessage());
        }
        return list;
    }
}
