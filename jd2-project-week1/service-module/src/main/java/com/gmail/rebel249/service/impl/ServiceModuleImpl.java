package com.gmail.rebel249.service.impl;


import com.gmail.rebel249.repository.RepositoryModule;
import com.gmail.rebel249.repository.impl.RepositoryModuleImpl;
import com.gmail.rebel249.service.ServiceModule;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServiceModuleImpl implements ServiceModule {
    private static final String REGEX_CONST = "^(\\d+)(\\W\\s)\\d+$";

    @Override
    public List<String> add(File file) {
        RepositoryModule repositoryModule = new RepositoryModuleImpl();
        List<String> list = null;
        try {
            list = repositoryModule.saveFile(file);
        } catch (FileNotFoundException e) {
            return null;
        }
        if (!list.isEmpty()) {
            List<String> listOfSums = new ArrayList<>();
            for (String s : list) {
                String sum = String.valueOf(sumOfStringsNumbers(s));
                if (Integer.parseInt(sum) >= 0) {
                    listOfSums.add(sum);
                }
            }
            return listOfSums;
        }return Collections.emptyList();

    }

    //"^$|^(\\d+)$|^(\\d+)(,|,\\s|\\s|:|\\n|\\|)\\d+$"
    public int sumOfStringsNumbers(String numbers) {
        int sum = 0;
        if (numbers.matches("^$|^(\\d+)$|" + REGEX_CONST)) {
            if (numbers.matches("^$")) {
                return sum;
            } else if (numbers.matches(REGEX_CONST)) {
                String[] num = numbers.trim().split("[, :|]+");
                for (String n : num) {
                    sum += Integer.parseInt(n);
                }
            } else if (numbers.matches("^\\d+$")) {
                sum = Integer.parseInt(numbers);
            }
            return sum;
        }
        return -1;
    }
}