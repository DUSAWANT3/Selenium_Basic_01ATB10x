package org.dutesting.Selenium_BasicProject03;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Pro01_katalon_demo {
    //Open the URL - https://katalon-demo-cura.herokuapp.com/
    //Enter the username and password
    //Verify that the current URL changes to https://katalon-demo-cura.herokuapp.com/#appointment
    @Test
    @Description("Verify that the current URL changes to")

    public void testVerifyKatalonDemo(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        driver.manage().window().maximize();

        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");

        //Click on make appointment
        WebElement MakeAppointment = driver.findElement(By.id("btn-make-appointment"));
        MakeAppointment.click();

        //Enter username and Password
        WebElement UserName = driver.findElement(By.id("txt-username"));
        UserName.sendKeys("John Doe");

        WebElement Password = driver.findElement(By.id("txt-password"));
        Password.sendKeys("ThisIsNotAPassword");

        //click on Logim button
         WebElement LoginBut = driver.findElement(By.id("btn-login"));
        LoginBut.click();

        //Verify that the current URL changes to https://katalon-demo-cura.herokuapp.com/#appointment
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");

         driver.quit();
    }

}
