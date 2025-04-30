package org.dutesting.sFramework01_TestNG;


import org.testng.annotations.*;


public class Ex01 {
//TestNG Basic Syntax:

    //Sequen -> (Before) Suit - test - class -Method
    @Test
    public void sayHello() {
        System.out.println("1 Hello from TestNG!");
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
    //Before Suit Test case
    //Before Test case
    //1 Hello from TestNG!
    //2 Test case
    //After Test case
    //After Suit Test case
}
