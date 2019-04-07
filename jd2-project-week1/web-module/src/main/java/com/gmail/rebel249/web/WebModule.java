package com.gmail.rebel249.web;

import com.gmail.rebel249.service.ServiceModule;
import com.gmail.rebel249.service.impl.ServiceModuleImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class WebModule {
    private static final Logger logger = LogManager.getLogger(WebModule.class);

    public static void main(String[] args) {
        ServiceModule serviceModule = new ServiceModuleImpl();
        File file = new File("File.txt");
        List<String> listOfSums = null;
        try {
            listOfSums = serviceModule.add(file);
        } catch (FileNotFoundException e) {
            logger.info("File not found " + e);
        }
        logger.info("List of sums " + listOfSums );
    }
}
