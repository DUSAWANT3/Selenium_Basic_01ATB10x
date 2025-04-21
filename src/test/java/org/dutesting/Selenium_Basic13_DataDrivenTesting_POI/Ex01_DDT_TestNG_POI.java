package org.dutesting.Selenium_Basic13_DataDrivenTesting_POI;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Ex01_DDT_TestNG_POI {

    @Test(dataProvider = "getData")
    public void DDT(String email, String password) {

        System.out.println(email + " _ " +password);
    }
    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                new Object[]{"abc@gmail.com","pass123"},
                new Object[]{"abc@gmail.com","pass333"},
                new Object[]{"abc@gmail.com","pass112"}
        };
    }
}