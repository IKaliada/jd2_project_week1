package com.gmail.rebel249.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface ServiceModule {
    List<String> add(File file) throws FileNotFoundException;

}
