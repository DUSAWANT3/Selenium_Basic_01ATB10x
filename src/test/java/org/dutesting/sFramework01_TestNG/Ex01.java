package org.dutesting.sFramework01_TestNG;

//import org.junit.Test;
import org.testng.annotations.Test;

public class Ex01 {
//TestNG Basic Syntax:
    @Test
    public void sayHello() {
        System.out.println("Hello from TestNG!");
    }

    @Test
    public void secondTest(){
        System.out.println("2 Test case");
    }
}
