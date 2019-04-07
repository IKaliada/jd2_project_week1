package com.gmail.rebel249.service;

import com.gmail.rebel249.service.impl.ServiceModuleImpl;
import org.junit.Assert;
import org.junit.Test;

public class ServiceModuleTest {

    @Test
    public void checkIfSumOfNumbersIsNull() {
        ServiceModule serviceModule = new ServiceModuleImpl();
        String s = "";
        int expectedSum = 0;
        Assert.assertEquals(expectedSum, ((ServiceModuleImpl) serviceModule).sumOfStringsNumbers(s));
    }
    @Test
    public void checkSumOfOneNumber() {
        ServiceModule serviceModule = new ServiceModuleImpl();
        String s = "2";
        int expectedSum = 2;
        Assert.assertEquals(expectedSum, ((ServiceModuleImpl) serviceModule).sumOfStringsNumbers(s));
    }

    @Test
    public void checkSumOfTwoNumbers() {
        ServiceModule serviceModule = new ServiceModuleImpl();
        String s = "25, 5";
        int expectedSum = 30;
        Assert.assertEquals(expectedSum, ((ServiceModuleImpl) serviceModule).sumOfStringsNumbers(s));
    }
}