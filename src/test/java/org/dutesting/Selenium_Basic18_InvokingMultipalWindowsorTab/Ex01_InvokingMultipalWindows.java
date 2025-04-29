package org.dutesting.Selenium_Basic18_InvokingMultipalWindowsorTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Ex01_InvokingMultipalWindows {

    @Test
    public void greenKart() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers"); //URL
        driver.manage().window().maximize();
    }
}