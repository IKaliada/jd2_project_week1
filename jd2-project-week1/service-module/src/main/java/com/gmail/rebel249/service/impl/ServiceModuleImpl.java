package com.gmail.rebel249.service.impl;


import com.gmail.rebel249.repository.RepositoryModule;
import com.gmail.rebel249.repository.impl.RepositoryModuleImpl;
import com.gmail.rebel249.service.ServiceModule;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ServiceModuleImpl implements ServiceModule {
    @Override
    public List<String> add(File file) throws FileNotFoundException {
        RepositoryModule repositoryModule = new RepositoryModuleImpl();
        List<String> list = repositoryModule.saveFile(file);
        List<String> listOfSums = new ArrayList<>();
        for (String s : list) {
            String sum = String.valueOf(sumOfStringsNumbers(s));
            listOfSums.add(sum);
        }
        return listOfSums;

    }

    public int sumOfStringsNumbers(String numbers) {
        int sum = 0;
        if (numbers.matches("^$|^(\\d+)$|^(\\d+)(,|,\\s|\\s|:|\\n|\\|)\\d+$")) {
            if (numbers.matches("^$")) {
                return sum;
            } else if (numbers.matches("^(\\d+)(,|,\\s|\\s|:|\\n|\\|)\\d+$")) {
                String[] num = numbers.trim().split("[, :|]+");
                for (String n : num) {
                    sum += Integer.parseInt(n);
                }
            } else if (numbers.matches("^\\d+$")) {
                 sum = Integer.parseInt(numbers);
            }
            return sum;
        }return 0;
    }
}
