package org.dutesting.Selenium_Basic13_DataDrivenTesting_POI;

import org.dutesting.UtilExcel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Ex02_DDT_TestNG_POI {

    @Test(dataProvider = "getData")
    public void testLogin(String email, String password) {
        System.out.println(email + " _ " + password);
    }

    @DataProvider
    public Object[][] getData() {
        return UtilExcel.getTestDataFromExcel("Sheet1"); // make sure sheet name is correct
    }
}