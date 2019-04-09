package com.gmail.rebel249.repository;

import com.gmail.rebel249.repository.impl.RepositoryModuleImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class RepositoryModuleTest {

    @Test
    public void checkIfFileNotNull() throws FileNotFoundException {
        RepositoryModule repositoryModule = new RepositoryModuleImpl();
        File file = new File("File.txt");
        List<String> list = repositoryModule.saveFile(file);
        Assert.assertNotNull(list);
    }

    @Test
    public void checkIfFileIsCreated(){
        File file = new File("File.txt");
        Assert.assertTrue(file.exists());
    }
}
