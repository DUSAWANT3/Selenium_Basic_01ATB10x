package org.dutesting.sFramework01_TestNG;


import org.testng.annotations.*;


public class Ex01 {
//TestNG Basic Syntax:

    //Sequen -> (Before) Suit - test - class -Method
    @Parameters({"url"}) //get data from testng.xml file
                         //<parameter name="url" value="https://www.google.com/"></parameter>
    @Test
    public void sayHello(String url) {
        System.out.println("1 Hello from TestNG!");
        System.out.println(url);
    }

    @Test
    public void secondTest(){
        System.out.println("2 Test case");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test case");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test case");
    }

    @BeforeSuite
    public void beforeSuitTest(){
        System.out.println("Before Suit Test case");
    }

    @AfterSuite
    public void afterSuitTest(){
        System.out.println("After Suit Test case");
    }

    //Data Driven testing - verify login functionality using multipal data set
    @Test (dataProvider = "getData")
    public void loginpage(String username , String password){
        System.out.println("loginpage");
        System.out.println(username);
        System.out.println(password);
    }

    //3- how may data set rows
    //2 how many value passing column
    @DataProvider
    public Object[][] getData() {
       Object[][] data = new Object[3][2];
       data[0][0] = "firstsetusername";
        data[0][1] = "firstssetpasswoed";
        //2nd data set
        data[1][0] = "secondtsetusername";
        data[1][1] = "secondsetpasswoed";
        //3rd data set
        data[2][0] = "thiredsetusername";
        data[2][1] = "thiredsetpasswoed";
        return data;
    }
}
