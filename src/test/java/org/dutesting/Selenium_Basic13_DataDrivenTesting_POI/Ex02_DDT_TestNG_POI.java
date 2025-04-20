package org.dutesting.Selenium_Basic13_DataDrivenTesting_POI;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Ex02_DDT_TestNG_POI {
    public class Ex01_DDT_TestNG_POI {
        @Test(dataProvider = "getData")
        public void iframe(String email,String password) {

            System.out.println(email + " _ " +password);
        }

        @DataProvider
        public Object[][] getData(){
            //Read the data from the excel file
            //Give them in the 2D Array
            //Create a Util file
            return new Object[][]{};
        }
    }
}
